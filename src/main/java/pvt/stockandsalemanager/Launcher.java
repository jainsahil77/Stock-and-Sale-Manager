package pvt.stockandsalemanager;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pvt.stockandsalemanager.hibernate.HibernateConnection;
import pvt.stockandsalemanager.utils.Configurations;
import pvt.stockandsalemanager.utils.Constants;

@SpringBootApplication
public class Launcher {
	public static final Logger LOGGER = LogManager.getLogger();
	private static ExecutorService fixedThreadPoolExecutorService;

	public static void main(String[] args) {
		try {
			if (initialize()) {
				SpringApplication.run(Launcher.class, args);
				fixedThreadPoolExecutorService = Executors.newFixedThreadPool(Configurations.getThreadPoolSize());
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
		boolean isConfigurationsInitialized = Configurations.initializeConfigurations();
		LOGGER.info("Configurations Initialized");
		return isConnectionEstablished && isConfigurationsInitialized;
	}

	private static void terminate() {
		fixedThreadPoolExecutorService.shutdown();
		int waitTime = 0;
		LOGGER.info("Shuting down threads");
		while (!fixedThreadPoolExecutorService.isShutdown()
				&& waitTime < Configurations.getWaitTimeOutForThreadsShutDown()) {
			try {
				Thread.sleep(Constants.INT_1000);
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
