/**
 * 文 件 名:  RequestAttributeHystrixConcurrencyStrategy
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/13 0013
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.web.config;

import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariable;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableLifecycle;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisher;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;
import com.netflix.hystrix.strategy.properties.HystrixProperty;
import com.quanteng.tland.common.thread.Language;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.quanteng.tland.common.cons.Constants.Cons.LOCAL_LANG_ID;
import static com.quanteng.tland.common.cons.Constants.Cons.TRANCE_ID;
import static com.quanteng.tland.common.cons.Constants.Cons.X_TRANCE_ID;

/**
 * <Hystrix 默认使用Thread做隔离策略，参数无法传递；自定义并发策略>
 *
 * @author zping
 * @version 2018/4/13 0013
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class RequestAttributeHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy
{

	private static final Logger LOGGER = LoggerFactory.getLogger (RequestAttributeHystrixConcurrencyStrategy.class);

	private HystrixConcurrencyStrategy delegate;

	public RequestAttributeHystrixConcurrencyStrategy ()
	{
		try
		{
			this.delegate = HystrixPlugins.getInstance ().getConcurrencyStrategy ();
			if (this.delegate instanceof RequestAttributeHystrixConcurrencyStrategy)
			{
				return;
			}
			HystrixCommandExecutionHook commandExecutionHook = HystrixPlugins.getInstance ().getCommandExecutionHook ();
			HystrixEventNotifier eventNotifier = HystrixPlugins.getInstance ().getEventNotifier ();
			HystrixMetricsPublisher metricsPublisher = HystrixPlugins.getInstance ().getMetricsPublisher ();
			HystrixPropertiesStrategy propertiesStrategy = HystrixPlugins.getInstance ().getPropertiesStrategy ();
			this.logCurrentStateOfHystrixPlugins (eventNotifier, metricsPublisher, propertiesStrategy);
			HystrixPlugins.reset ();
			HystrixPlugins.getInstance ().registerConcurrencyStrategy (this);
			HystrixPlugins.getInstance ().registerCommandExecutionHook (commandExecutionHook);
			HystrixPlugins.getInstance ().registerEventNotifier (eventNotifier);
			HystrixPlugins.getInstance ().registerMetricsPublisher (metricsPublisher);
			HystrixPlugins.getInstance ().registerPropertiesStrategy (propertiesStrategy);
		}
		catch (Exception e)
		{
			LOGGER.error ("Failed to register Sleuth Hystrix Concurrency Strategy", e);
		}
	}

	private void logCurrentStateOfHystrixPlugins (HystrixEventNotifier eventNotifier,
			HystrixMetricsPublisher metricsPublisher, HystrixPropertiesStrategy propertiesStrategy)
	{
		if (LOGGER.isDebugEnabled ())
		{
			LOGGER.debug ("Current Hystrix plugins configuration is [" + "concurrencyStrategy [" + this.delegate + "],"
					+ "eventNotifier [" + eventNotifier + "]," + "metricPublisher [" + metricsPublisher + "],"
					+ "propertiesStrategy [" + propertiesStrategy + "]," + "]");
			LOGGER.debug ("Registering Sleuth Hystrix Concurrency Strategy.");
		}
	}

	@Override
	public ThreadPoolExecutor getThreadPool (HystrixThreadPoolKey threadPoolKey, HystrixProperty<Integer> corePoolSize,
			HystrixProperty<Integer> maximumPoolSize, HystrixProperty<Integer> keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue)
	{
		return this.delegate
				.getThreadPool (threadPoolKey, corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	public ThreadPoolExecutor getThreadPool (HystrixThreadPoolKey threadPoolKey,
			HystrixThreadPoolProperties threadPoolProperties)
	{
		return this.delegate.getThreadPool (threadPoolKey, threadPoolProperties);
	}

	@Override
	public BlockingQueue<Runnable> getBlockingQueue (int maxQueueSize)
	{
		return this.delegate.getBlockingQueue (maxQueueSize);
	}

	@Override
	public <T> HystrixRequestVariable<T> getRequestVariable (HystrixRequestVariableLifecycle<T> rv)
	{
		return this.delegate.getRequestVariable (rv);
	}

	/**
	 * wrapCallable 方法拿到 RequestContextHolder.getRequestAttributes() ，也就是我们想传播的对象；
	 * 在 WrappedCallable 类中，我们将要传播的对象作为成员变量，并在其中的call方法中，为静态方法设值。
	 * 这样，在Hystrix包裹的方法中，就可以使用RequestContextHolder.getRequestAttributes() 获取到相关属性——也就是说，可以拿到RequestContextHolder 中的ThreadLocal属性。
	 *
	 * @param callable
	 * @param <T>
	 * @return
	 */
	@Override
	public <T> Callable<T> wrapCallable (Callable<T> callable)
	{
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes ();
		String tranceID = ThreadContext.get (TRANCE_ID);
		String language = Language.getLanguage ();
		return new WrappedCallable<> (callable, requestAttributes, tranceID, language);
	}

	/**
	 * 实现Callable类，封装Request对象
	 *
	 * @param <T>
	 */
	static class WrappedCallable<T> implements Callable<T>
	{
		private final Callable<T> target;
		private final RequestAttributes requestAttributes;
		private final String tranceID;
		private final String language;

		public WrappedCallable (Callable<T> target, RequestAttributes requestAttributes, String tranceID,
				String language)
		{
			this.target = target;
			this.requestAttributes = requestAttributes;
			this.tranceID = tranceID;
			this.language = language;
		}

		@Override
		public T call () throws Exception
		{
			try
			{
				requestAttributes.setAttribute (X_TRANCE_ID, tranceID, RequestAttributes.SCOPE_REQUEST);
				requestAttributes.setAttribute (LOCAL_LANG_ID, language, RequestAttributes.SCOPE_REQUEST);
				RequestContextHolder.setRequestAttributes (requestAttributes);
				return target.call ();
			}
			finally
			{
				RequestContextHolder.resetRequestAttributes ();
			}
		}
	}
}
