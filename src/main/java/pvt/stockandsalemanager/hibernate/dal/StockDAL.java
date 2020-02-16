package pvt.stockandsalemanager.hibernate.dal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pvt.stockandsalemanager.beans.ItemDetails;
import pvt.stockandsalemanager.beans.SupplierDetails;
import pvt.stockandsalemanager.hibernate.HibernateConnection;

public class StockDAL {

	private StockDAL() {
		// Adding a private constructor to hide the implicit public one.
	}

	public static final Logger LOGGER = LogManager.getLogger();

	public static boolean addItemDetails(ItemDetails itemDetails) {
		boolean isSuccess = false;
		Session session = HibernateConnection.getSession();
		LOGGER.info("Got session. Creating transaction for item details");
		Transaction transaction = session.beginTransaction();
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

	public static boolean addSupplierDetails(SupplierDetails supplierDetails) {
		boolean isSuccess = false;
		Session session = HibernateConnection.getSession();
		LOGGER.info("Got session. Creating transaction for supplier details");
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(supplierDetails);
			LOGGER.info("Committing supplier details");
			transaction.commit();
			LOGGER.info("Commit successfull", supplierDetails.toString());
			isSuccess = true;
		} catch (Exception ex) {
			transaction.rollback();
			LOGGER.error("Error encontered. Rolledback data.", ex);
		} finally {
			session.close();
		}
		LOGGER.info("Insert supplier Details status: ", isSuccess);
		return isSuccess;
	}

	public static boolean updateAvailableStockInItemDetails(String itemId, int quantity) {
		boolean isSuccess = false;
		Session session = HibernateConnection.getSession();
		LOGGER.info("Got session. Creating transaction for item details");
		Transaction transaction = session.beginTransaction();
		try {
			ItemDetails itemDetails = (ItemDetails) session.createQuery("FROM ItemDetails where itemId=?")
					.setParameter(0, itemId).list().get(0);
			itemDetails.setAvailableStock(itemDetails.getAvailableStock() - quantity);
			session.saveOrUpdate(itemDetails);
			LOGGER.info("Committing item details");
			transaction.commit();
			LOGGER.info("Commit successfull", itemDetails.toString());
			isSuccess = true;
		} catch (Exception ex) {
			transaction.rollback();
			LOGGER.error("Error encontered. Rolledback data.", ex);
		} finally {
			HibernateConnection.closeSession(session);
		}
		LOGGER.info("Insert Item Details status: ", isSuccess);
		return isSuccess;
	}
}
