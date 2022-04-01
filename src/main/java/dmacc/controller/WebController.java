/**
 * @author Bobby - rfparsons
 * CIS175 - Spring 2022
 * Mar 31, 2022
 */
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Item;
import dmacc.repository.ItemRepository;

/**
 * @author Bobby
 *
 */
public class WebController {
	@Autowired
	ItemRepository repo;
	
	@GetMapping({"/", "/viewAll"})
	public String viewAllItems(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewItem(model);
		}
		model.addAttribute("Items", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputItem")
	public String addNewItem(Model model) {
		Item c = new Item();
		model.addAttribute("newItem", c);
		return "input";
	}
	
	@PostMapping("/inputItem")
	public String addNewItem(@ModelAttribute Item c, Model model) {
		repo.save(c);
		return viewAllItems(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateItem(@PathVariable("id") long id, Model model) {
		Item c = repo.findById(id).orElse(null);
		model.addAttribute("newItem", c);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseItem(Item c, Model model) {
		repo.save(c);
		return viewAllItems(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Item c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllItems(model);
	}
}
