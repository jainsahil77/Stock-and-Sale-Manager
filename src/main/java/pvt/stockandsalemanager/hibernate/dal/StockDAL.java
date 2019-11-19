package pvt.stockandsalemanager.hibernate.dal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pvt.stockandsalemanager.beans.ItemDetails;
import pvt.stockandsalemanager.hibernate.HibernateConnection;

public class StockDAL {
	public static final Logger LOGGER = LogManager.getLogger();

	public static boolean insertItemDetails(ItemDetails itemDetails) {
		boolean isSuccess = false;
		Session session = HibernateConnection.getSession();
		LOGGER.info("Got session. Creating transaction for item details");
		Transaction transaction = session.beginTransaction();
		LOGGER.info("Transaction created");
		try {
			session.saveOrUpdate(itemDetails);
			LOGGER.info("Committing item details");
			transaction.commit();
			LOGGER.info("Commit successfull", itemDetails.toString());
			isSuccess = true;
		} catch (Exception ex) {
			transaction.rollback();
			LOGGER.error("Error encontered. Rolledback data.", ex);
		} finally {
			session.close();
		}
		LOGGER.info("Insert Item Details status: ", isSuccess);
		return isSuccess;
	}
}
