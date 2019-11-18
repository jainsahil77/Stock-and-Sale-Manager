package pvt.stockandsalemanager.beans;

import java.util.Objects;

import pvt.stockandsalemanager.utils.GenericEnums.StockMeasurementUnit;

/**
 * @author Sahil Jain
 *
 *         Hibernate bean object for Item Details
 */
public class ItemDetails implements java.io.Serializable {
	private static final long serialVersionUID = -4589964730251394570L;
	private String itemId; // Primary Key
	private String itemName;
	private float itemPurchasePrice;
	private int itemSupplierId; // Foreign Key from Supplier Details
	private float itemMRP;
	private float availableStock;
	private StockMeasurementUnit itemMeasuringUnit;

	public ItemDetails() {
		// Constructor for Hibernate
	}

	/**
	 * @param itemName
	 * @param itemPurchasePrice
	 * @param itemSupplierId
	 * @param itemMRP
	 * @param availableStock
	 * @param itemMeasuringUnit
	 */
	public ItemDetails(String itemName, float itemPurchasePrice, int itemSupplierId, float itemMRP,
			float availableStock, StockMeasurementUnit itemMeasuringUnit) {
		this.itemName = itemName;
		this.itemPurchasePrice = itemPurchasePrice;
		this.itemSupplierId = itemSupplierId;
		this.itemMRP = itemMRP;
		this.availableStock = availableStock;
		this.itemMeasuringUnit = itemMeasuringUnit;
		this.itemId = String.valueOf(this.hashCode());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.itemName, this.itemSupplierId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ItemDetails)) {
			return false;
		}
		ItemDetails other = (ItemDetails) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(itemName, other.itemName)
				&& itemSupplierId == other.itemSupplierId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemDetails [itemId=");
		builder.append(itemId);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", itemPurchasePrice=");
		builder.append(itemPurchasePrice);
		builder.append(", itemSupplierId=");
		builder.append(itemSupplierId);
		builder.append(", itemMRP=");
		builder.append(itemMRP);
		builder.append(", availableStock=");
		builder.append(availableStock);
		builder.append(", itemMeasuringUnit=");
		builder.append(itemMeasuringUnit);
		builder.append("]");
		return builder.toString();
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
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemPurchasePrice
	 */
	public float getItemPurchasePrice() {
		return itemPurchasePrice;
	}

	/**
	 * @param itemPurchasePrice the itemPurchasePrice to set
	 */
	public void setItemPurchasePrice(float itemPurchasePrice) {
		this.itemPurchasePrice = itemPurchasePrice;
	}

	/**
	 * @return the itemSupplierId
	 */
	public int getItemSupplierId() {
		return itemSupplierId;
	}

	/**
	 * @param itemSupplierId the itemSupplierId to set
	 */
	public void setItemSupplierId(int itemSupplierId) {
		this.itemSupplierId = itemSupplierId;
	}

	/**
	 * @return the itemMRP
	 */
	public float getItemMRP() {
		return itemMRP;
	}

	/**
	 * @param itemMRP the itemMRP to set
	 */
	public void setItemMRP(float itemMRP) {
		this.itemMRP = itemMRP;
	}

	/**
	 * @return the availableStock
	 */
	public float getAvailableStock() {
		return availableStock;
	}

	/**
	 * @param availableStock the availableStock to set
	 */
	public void setAvailableStock(float availableStock) {
		this.availableStock = availableStock;
	}

	/**
	 * @return the itemMeasuringUnit
	 */
	public StockMeasurementUnit getItemMeasuringUnit() {
		return itemMeasuringUnit;
	}

	/**
	 * @param itemMeasuringUnit the itemMeasuringUnit to set
	 */
	public void setItemMeasuringUnit(StockMeasurementUnit itemMeasuringUnit) {
		this.itemMeasuringUnit = itemMeasuringUnit;
	}
}
