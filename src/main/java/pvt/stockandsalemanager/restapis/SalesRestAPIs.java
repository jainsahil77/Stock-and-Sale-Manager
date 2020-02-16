/**
 * 
 */
package pvt.stockandsalemanager.restapis;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pvt.stockandsalemanager.beans.ItemDetails;
import pvt.stockandsalemanager.beans.SalesDetailsListWrapper;
import pvt.stockandsalemanager.hibernate.dal.SalesDAL;

/**
 * @author Sahil Jain
 *
 */
@RestController
@RequestMapping(value = "/sales")
public class SalesRestAPIs {
	@GetMapping(value = "/getAllItems")
	public ResponseEntity<Object> getAllItems() {
		List<ItemDetails> itemDetailsRecords = SalesDAL.getItemDetailsRecords();
		if (!itemDetailsRecords.isEmpty()) {
			return new ResponseEntity<>("No records found", HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(itemDetailsRecords, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/searchItem/{itemName}")
	public ResponseEntity<Object> searchItemByName(@PathVariable("itemName") String itemName) {
		List<ItemDetails> itemDetailsRecords = SalesDAL.searchItemByName(itemName);
		if (itemDetailsRecords.isEmpty()) {
			return new ResponseEntity<>("No item found", HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(itemDetailsRecords, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/insertSalesDetails", consumes = MediaType.ALL_VALUE)
	public ResponseEntity<Object> insertSalesDetails(@RequestBody SalesDetailsListWrapper salesDetailsListWrapper) {
//		List<ItemDetails> itemDetailsRecords = SalesDAL.insertSalesData(saleDetailsList);
//		if (itemDetailsRecords.isEmpty()) {
//			return new ResponseEntity<>("No item found", HttpStatus.NO_CONTENT);
//		} else {
//			return new ResponseEntity<>(itemDetailsRecords, HttpStatus.OK);
//		}
		SalesDAL.insertSalesData(salesDetailsListWrapper.getSalesDetailsList());
//		SalesDetails salesDetails = new SalesDetails();
//		salesDetails.setCouponCodeUsed("LOL");
//		salesDetails.setDiscountAppliedPercentage(10F);
//		salesDetails.setItemId("2231");
//		salesDetails.setPurchaseId(22345L);
//		salesDetails.setQuantity(2F);
//		salesDetails.setSalesId(31234);
//		salesDetails.setSellingPrice(35F);
//		salesDetails.setTotalAmount(70F);
//		LinkedList<SalesDetails> linkedList = new LinkedList<SalesDetails>();
//		linkedList.add(salesDetails);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
