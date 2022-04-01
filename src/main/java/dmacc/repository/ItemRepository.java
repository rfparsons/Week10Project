/**
 * @author Bobby - rfparsons
 * CIS175 - Spring 2022
 * Mar 31, 2022
 */
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Item;

/**
 * @author Bobby
 *
 */
public interface ItemRepository extends JpaRepository<Item, Long> { }
