/**
 * 
 */
package pvt.stockandsalemanager.hibernate.dal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pvt.stockandsalemanager.beans.ItemDetails;
import pvt.stockandsalemanager.beans.PaymentDetails;
import pvt.stockandsalemanager.beans.SalesDetails;
import pvt.stockandsalemanager.hibernate.HibernateConnection;

/**
 * @author Sahil Jain
 *
 */
public class SalesDAL {
	public static final Logger LOGGER = LogManager.getLogger();

	@SuppressWarnings("unchecked")
	public static List<ItemDetails> getItemDetailsRecords() {
		List<ItemDetails> itemDetailsList = new LinkedList<>();
		Session session = HibernateConnection.getSession();
		try {
			LOGGER.info("Got session. Fetching Item Details");
			session.beginTransaction();
			itemDetailsList = session.createQuery("FROM item_details order by item_name").list();
		} catch (Exception ex) {
			LOGGER.error("Error encontered. Nothing to rollback.", ex);
		} finally {
			HibernateConnection.closeSession(session);
		}
		return itemDetailsList;
	}

	@SuppressWarnings("unchecked")
	public static List<ItemDetails> searchItemByName(String itemName) {
		List<ItemDetails> itemDetailsList = new LinkedList<>();
		Session session = HibernateConnection.getSession();
		try {
			LOGGER.info("Got session. Searching item by name");
			session.beginTransaction();
			itemDetailsList = session.createQuery("FROM item_details where item_name like %?%")
					.setParameter(0, itemName).list();
		} catch (Exception ex) {
			LOGGER.error("Error encontered. Nothing to rollback.", ex);
		} finally {
			HibernateConnection.closeSession(session);
		}
		return itemDetailsList;
	}

	public static boolean insertSalesData(List<SalesDetails> saleDetailsList) {
		boolean isSuccess = false;
		Session session = HibernateConnection.getSession();
		LOGGER.info("Got session. Creating transaction for sale details");
		Transaction transaction = session.beginTransaction();
		LOGGER.info("Transaction created");
		for (Iterator<SalesDetails> iterator = saleDetailsList.iterator(); iterator.hasNext();) {
			SalesDetails salesDetails = iterator.next();
			salesDetails.getItemId();
			salesDetails.getQuantity();
			try {
				session.save(salesDetails);
				LOGGER.info("Insert success salesDetails", salesDetails);
			} catch (Exception ex) {
				LOGGER.error("Error encontered. for sales details: " + salesDetails.toString(), ex);
			}
		}
		try {
			LOGGER.info("Committing item details");
			transaction.commit();
			isSuccess = true;
		} catch (Exception ex) {
			transaction.rollback();
			LOGGER.error("Error encontered while committing. Rolledback data.", ex);
		} finally {
			HibernateConnection.closeSession(session);
		}
		LOGGER.info("Insert Sale Details status: ", isSuccess);
		return isSuccess;
	}

	public static boolean insertPaymentDetails(PaymentDetails paymentDetails) {
		boolean isSuccess = false;
		Session session = HibernateConnection.getSession();
		LOGGER.info("Got session. Creating transaction for payment details");
		Transaction transaction = session.beginTransaction();
		LOGGER.info("Transaction created");
		try {
			session.save(paymentDetails);
			LOGGER.info("Insert success payment details", paymentDetails);
			transaction.commit();
			LOGGER.info("Commit success payment details");
			isSuccess = true;
		} catch (Exception ex) {
			transaction.rollback();
			LOGGER.error("Error encontered while committing. Rolledback data.", ex);
		} finally {
			HibernateConnection.closeSession(session);
		}
		LOGGER.info("Insert payment Details status: ", isSuccess);
		return isSuccess;
	}
}
