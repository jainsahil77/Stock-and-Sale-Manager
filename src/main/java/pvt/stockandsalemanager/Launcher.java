package pvt.stockandsalemanager;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pvt.stockandsalemanager.hibernate.HibernateConnection;

/**
 *
 */
public class Launcher {
	public static final Logger LOGGER = LogManager.getLogger();
	private static ExecutorService fixedThreadPoolExecutorService;

	public static void main(String[] args) {
		try {
			fixedThreadPoolExecutorService = Executors.newFixedThreadPool(10);
			if (initialize()) {
				// TODO Launch service
				LOGGER.info("Enter 0 for exiting");
				try (Scanner scannerObj = new Scanner(System.in)) {
					String input = "";
					while (!input.equals("0")) {
						input = scannerObj.next();
					}
				}
			}
		} catch (Exception ex) {
			LOGGER.error("Error while starting service", ex);
		} finally {
			terminate();
		}
	}

	/**
	 * @return the fixedThreadPoolExecutorService
	 */
	public static ExecutorService getFixedThreadPoolExecutorService() {
		return fixedThreadPoolExecutorService;
	}

	private static boolean initialize() {
		boolean isConnectionEstablished = HibernateConnection.openDatabaseConnection();
		LOGGER.info("Established Database Connection");
		// TODO Initialized configurations
		boolean isConfigurationsInitialized = true;
		return isConnectionEstablished && isConfigurationsInitialized;
	}

	private static void terminate() {
		fixedThreadPoolExecutorService.shutdown();
		int waitTime = 0;
		LOGGER.info("Shuting down threads");
		while (!fixedThreadPoolExecutorService.isShutdown() && waitTime < 10) {
			try {
				Thread.sleep(1000);
				waitTime++;
			} catch (InterruptedException e) {
				LOGGER.error("Wait thread interrupted. Caught.", e);
			}
		}
		if (!fixedThreadPoolExecutorService.isShutdown()) {
			LOGGER.info("Threads not terminated gracefully. Forcing shutdown.");
			fixedThreadPoolExecutorService.shutdownNow();
		}
		HibernateConnection.closeDatabaseConnection();
		LOGGER.info("GoodBye...");
		System.exit(0);
	}
}
