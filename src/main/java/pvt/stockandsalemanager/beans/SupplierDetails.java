/**
 * 
 */
package pvt.stockandsalemanager.beans;

/**
 * @author Sahil Jain
 *
 */
public class SupplierDetails implements java.io.Serializable {
	private static final long serialVersionUID = -7911967671399000248L;
	private int supplierId; // Primary Key
	private String supplierName;
	private String supplierAddress;
	private String supplierCity;
	private String supplierState;
	private int supplierZipCode;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SupplierDetails [supplierId=");
		builder.append(supplierId);
		builder.append(", supplierName=");
		builder.append(supplierName);
		builder.append(", supplierAddress=");
		builder.append(supplierAddress);
		builder.append(", supplierCity=");
		builder.append(supplierCity);
		builder.append(", supplierState=");
		builder.append(supplierState);
		builder.append(", supplierZipCode=");
		builder.append(supplierZipCode);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the supplierId
	 */
	public int getSupplierId() {
		return supplierId;
	}

	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * @return the supplierName
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * @param supplierName the supplierName to set
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	/**
	 * @return the supplierAddress
	 */
	public String getSupplierAddress() {
		return supplierAddress;
	}

	/**
	 * @param supplierAddress the supplierAddress to set
	 */
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	/**
	 * @return the supplierCity
	 */
	public String getSupplierCity() {
		return supplierCity;
	}

	/**
	 * @param supplierCity the supplierCity to set
	 */
	public void setSupplierCity(String supplierCity) {
		this.supplierCity = supplierCity;
	}

	/**
	 * @return the supplierState
	 */
	public String getSupplierState() {
		return supplierState;
	}

	/**
	 * @param supplierState the supplierState to set
	 */
	public void setSupplierState(String supplierState) {
		this.supplierState = supplierState;
	}

	/**
	 * @return the supplierZipCode
	 */
	public int getSupplierZipCode() {
		return supplierZipCode;
	}

	/**
	 * @param supplierZipCode the supplierZipCode to set
	 */
	public void setSupplierZipCode(int supplierZipCode) {
		this.supplierZipCode = supplierZipCode;
	}
}
