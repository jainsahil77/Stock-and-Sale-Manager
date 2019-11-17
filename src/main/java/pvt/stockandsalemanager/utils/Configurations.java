/**
 * 
 */
package pvt.stockandsalemanager.utils;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Sahil Jain
 *
 */
public class Configurations {
	private Configurations() {
		// Adding a private constructor to hide the implicit public one.
	}

	private static int threadPoolSize;
	private static int waitTimeOutForThreadsShutDown;

	/**
	 * @return the waitTimeOutForThreadsShutDown
	 */
	public static int getWaitTimeOutForThreadsShutDown() {
		return waitTimeOutForThreadsShutDown;
	}

	/**
	 * @param waitTimeOutForThreadsShutDown the waitTimeOutForThreadsShutDown to set
	 */
	public static void setWaitTimeOutForThreadsShutDown(int waitTimeOutForThreadsShutDown) {
		Configurations.waitTimeOutForThreadsShutDown = waitTimeOutForThreadsShutDown;
	}

	/**
	 * @return the threadPoolSize
	 */
	public static int getThreadPoolSize() {
		return threadPoolSize;
	}

	/**
	 * @param threadPoolSize the threadPoolSize to set
	 */
	public static void setThreadPoolSize(int threadPoolSize) {
		Configurations.threadPoolSize = threadPoolSize;
	}

	/**
	 * This method initializes the configurations and returns boolean values based
	 * on success or failure
	 * 
	 * @return true iff configurations successfully loaded
	 */
	public static boolean initializeConfigurations() {
		boolean isConfigLoaded = false;
		try (AbstractApplicationContext abstractApplicationContext = new FileSystemXmlApplicationContext(
				"src/main/resources/configurations/Configurations.xml")) {
			abstractApplicationContext.getBean("Configurations");
			isConfigLoaded = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return isConfigLoaded;
	}
}
