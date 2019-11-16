package pvt.stockandsalemanager.hibernate;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;

/**
 * @author Sahil Jain
 *
 */
public class HibernateConnection {
	public static final Logger LOGGER = LogManager.getLogger();

	private HibernateConnection() {
		// Added a private constructor to hide the implicit public one.
	}

	private static Session session;
	private static Connection connection;

	public static boolean openDatabaseConnection() {
		boolean isConnectionEstablished = false;
		if (!checkDatabaseConnection()) {
			try {
				File hibernateConfigFile = new File("src/main/resources/hibernate/hibernate.cfg.xml");
				SessionFactory sessionFactory = new Configuration().configure(hibernateConfigFile)
						.buildSessionFactory();
				session = sessionFactory.openSession();
				LOGGER.info("Session Opened");
				session.doWork(new Work() {
					@Override
					public void execute(Connection connection) throws SQLException {
						// TODO do your work using connection
						HibernateConnection.connection = connection;
					}
				});

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

	public static boolean checkDatabaseConnection() {
		return !Objects.isNull(session) && session.isOpen() && session.isConnected();
	}

	public static Connection getConnection() {
		if (!checkDatabaseConnection()) {
			LOGGER.info("Hibernate Database Connection is not open. Connecting...");
			openDatabaseConnection();
		} else {
			LOGGER.info("Hibernate Database Connection is already open");
		}
		return connection;
	}

	public static void closeDatabaseConnection() {
		if (checkDatabaseConnection()) {
			session.disconnect();
			LOGGER.info("Hibernate Database Disconnected");
			session.close();
			LOGGER.info("Hibernate Database Connection Closed");
		} else {
			LOGGER.info("Hibernate Database Connection is already closed");
		}
	}
}
