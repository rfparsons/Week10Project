/**
 * @author Bobby - rfparsons
 * CIS175 - Spring 2022
 * Mar 31, 2022
 */
package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bobby
 *
 */
@Data
@Entity
@NoArgsConstructor
public class Item {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int quantity;
	private String partNo;
	private String supplier;
	/**
	 * @param name
	 * @param quantity
	 * @param partNo
	 * @param supplier
	 */
	public Item(String name, int quantity, String partNo, String supplier) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.partNo = partNo;
		this.supplier = supplier;
	}
	/**
	 * @param id
	 * @param name
	 * @param quantity
	 * @param partNo
	 * @param supplier
	 */
	public Item(long id, String name, int quantity, String partNo, String supplier) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.partNo = partNo;
		this.supplier = supplier;
	}
	
	
}
