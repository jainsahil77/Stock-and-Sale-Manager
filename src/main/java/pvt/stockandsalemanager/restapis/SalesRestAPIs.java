/**
 * 
 */
package pvt.stockandsalemanager.restapis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sahil Jain
 *
 */
@RestController
public class SalesRestAPIs {
	@RequestMapping(value = "/")
	public String hello() {
		return "Hello World";
	}
}
