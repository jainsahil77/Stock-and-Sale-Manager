package pvt.stockandsalemanager.hibernate;

import java.io.File;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Sahil Jain
 *
 */
public class HibernateConnection {
	public static final Logger LOGGER = LogManager.getLogger();

	private HibernateConnection() {
		// Added a private constructor to hide the implicit public one.
	}

	private static SessionFactory sessionFactory;

	public static boolean openDatabaseConnection() {
		boolean isConnectionEstablished = false;
		if (!checkSessionFactoryStatus()) {
			try {
				File hibernateConfigFile = new File("src/main/resources/hibernate/hibernate.cfg.xml");
				sessionFactory = new Configuration().configure(hibernateConfigFile).buildSessionFactory();
				// session = sessionFactory.openSession();
				LOGGER.info("Session Factory Opened");
				LOGGER.info("Hibernate Database Connected");
				isConnectionEstablished = true;
			} catch (Exception ex) {
				LOGGER.error("Error while opening connection", ex);
			}
		} else {
			LOGGER.info("Hibernate Database Connection is already open");
		}
		return isConnectionEstablished;
	}

	public static boolean checkSessionFactoryStatus() {
		return !Objects.isNull(sessionFactory) && sessionFactory.isOpen();
	}

	public static Session getSession() {
		if (!checkSessionFactoryStatus()) {
			LOGGER.info("Hibernate Database Connection is not open. Connecting...");
			openDatabaseConnection();
		}
		return sessionFactory.openSession();
	}

	public static void closeDatabaseConnection() {
		if (checkSessionFactoryStatus()) {
			sessionFactory.close();
			LOGGER.info("Hibernate Database Disconnected");
		} else {
			LOGGER.info("Hibernate Database Connection is already closed");
		}
	}
}