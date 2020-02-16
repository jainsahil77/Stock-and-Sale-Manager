/**
 * 
 */
package pvt.stockandsalemanager.beans;

import java.util.List;

/**
 * @author Sahil Jain
 *
 */
public class SalesDetailsListWrapper implements java.io.Serializable {
	private static final long serialVersionUID = -3937355659367888879L;
	private List<SalesDetails> salesDetailsList;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalesDetailsListWrapper [salesDetailsList=");
		builder.append(salesDetailsList);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the salesDetailsList
	 */
	public List<SalesDetails> getSalesDetailsList() {
		return salesDetailsList;
	}

	/**
	 * @param salesDetailsList the salesDetailsList to set
	 */
	public void setSalesDetailsList(List<SalesDetails> salesDetailsList) {
		this.salesDetailsList = salesDetailsList;
	}
}
