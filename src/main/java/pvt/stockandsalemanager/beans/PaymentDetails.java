/**
 * 
 */
package pvt.stockandsalemanager.beans;

import pvt.stockandsalemanager.utils.GenericEnums.PaymentModes;

/**
 * @author Sahil Jain
 *
 */
public class PaymentDetails implements java.io.Serializable {
	private static final long serialVersionUID = -249343157357618258L;
	private int purchaseId; // Primary Key
	private PaymentModes paymentMode;
	private float amountPayed;
	private String remarks;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaymentDetails [purchaseId=");
		builder.append(purchaseId);
		builder.append(", paymentMode=");
		builder.append(paymentMode);
		builder.append(", amountPayed=");
		builder.append(amountPayed);
		builder.append(", remarks=");
		builder.append(remarks);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the purchaseId
	 */
	public int getPurchaseId() {
		return purchaseId;
	}

	/**
	 * @param purchaseId the purchaseId to set
	 */
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	/**
	 * @return the paymentMode
	 */
	public PaymentModes getPaymentMode() {
		return paymentMode;
	}

	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(PaymentModes paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * @return the amountPayed
	 */
	public float getAmountPayed() {
		return amountPayed;
	}

	/**
	 * @param amountPayed the amountPayed to set
	 */
	public void setAmountPayed(float amountPayed) {
		this.amountPayed = amountPayed;
	}
}
