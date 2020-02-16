/**
 * 
 */
package pvt.stockandsalemanager.restapis;

import java.util.LinkedList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pvt.stockandsalemanager.beans.ItemDetails;
import pvt.stockandsalemanager.beans.SalesDetails;
import pvt.stockandsalemanager.beans.SalesDetailsListWrapper;

/**
 * @author Sahil Jain
 *
 */
@RestController
@RequestMapping(value = "/stocks")
public class StockRestAPIs {

	@PostMapping(value = "/insertItemDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insertSalesDetails(@RequestBody ItemDetails itemDetails) {
		System.out.println(itemDetails);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
