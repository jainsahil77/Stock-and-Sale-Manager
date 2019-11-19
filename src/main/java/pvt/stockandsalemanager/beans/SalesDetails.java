/**
 * 
 */
package pvt.stockandsalemanager.beans;

/**
 * @author Sahil Jain
 *
 */
public class SalesDetails implements java.io.Serializable {
	private static final long serialVersionUID = 7744354212280282290L;
	// Composite Primary Key (purchaseId and itemId)
	private long purchaseId; // Foreign Key from PaymentDetails
	private String itemId; // Foreign Key from Item Details
	private float quantity;
	private float sellingPrice;
	private float totalAmount;
	private float discountAppliedPercentage;
	private float salesId;
	private String couponCodeUsed;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalesDetails [purchaseId=");
		builder.append(purchaseId);
		builder.append(", itemId=");
		builder.append(itemId);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", sellingPrice=");
		builder.append(sellingPrice);
		builder.append(", totalAmount=");
		builder.append(totalAmount);
		builder.append(", discountAppliedPercentage=");
		builder.append(discountAppliedPercentage);
		builder.append(", salesId=");
		builder.append(salesId);
		builder.append(", couponCodeUsed=");
		builder.append(couponCodeUsed);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the salesId
	 */
	public float getSalesId() {
		return salesId;
	}

	/**
	 * @param salesId the salesId to set
	 */
	public void setSalesId(float salesId) {
		this.salesId = salesId;
	}

	/**
	 * @return the purchaseId
	 */
	public long getPurchaseId() {
		return purchaseId;
	}

	/**
	 * @param purchaseId the purchaseId to set
	 */
	public void setPurchaseId(long purchaseId) {
		this.purchaseId = purchaseId;
	}

	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the quantity
	 */
	public float getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the sellingPrice
	 */
	public float getSellingPrice() {
		return sellingPrice;
	}

	/**
	 * @param sellingPrice the sellingPrice to set
	 */
	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	/**
	 * @return the totalAmount
	 */
	public float getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the discountAppliedPercentage
	 */
	public float getDiscountAppliedPercentage() {
		return discountAppliedPercentage;
	}

	/**
	 * @param discountAppliedPercentage the discountApplied to set
	 */
	public void setDiscountAppliedPercentage(float discountAppliedPercentage) {
		this.discountAppliedPercentage = discountAppliedPercentage;
	}

	/**
	 * @return the couponCodeUsed
	 */
	public String getCouponCodeUsed() {
		return couponCodeUsed;
	}

	/**
	 * @param couponCodeUsed the couponCodeUsed to set
	 */
	public void setCouponCodeUsed(String couponCodeUsed) {
		this.couponCodeUsed = couponCodeUsed;
	}
}
