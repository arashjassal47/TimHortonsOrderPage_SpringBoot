/**
 * 
 * @author Arashdeep Singh
 * @date 6 Oct 2020
 */
package ca.sheridancollege.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
	static final long serialVersionUID=1;
	private Integer noOfCups;
	private String size;
	private String type;
	private double totalCost;

	
}
