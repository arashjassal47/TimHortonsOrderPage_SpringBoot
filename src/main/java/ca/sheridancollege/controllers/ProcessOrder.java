/**
 * 
 * @author Arashdeep Singh
 * @date 6 Oct 2020
 */
package ca.sheridancollege.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Order;

@Controller
public class ProcessOrder {
	List<Order> orderList = new CopyOnWriteArrayList<Order>();
	private double cost;
	public double totalCost;
	public Integer sugar=0;
	public Integer cream=0;
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	@PostMapping("/output")
	public String output(Model model, @RequestParam String type, @RequestParam String size ,@RequestParam Integer noOfCups) { 
		switch(type) {
			case "Regular":
				sugar=1;
				cream=1;
				cost=1.49;
				break;
			case "DoubleDouble":
				sugar=2;
				cream=2;
				cost=1.79;
				break;
			case "TripleTriple":
				sugar=3;
				cream=3;
				cost=1.99;
				break;
			case "Black":
				sugar=0;
				cream=0;
				cost=1.79;
				break;
			case "BlackOneSugar":
				sugar=1;
				cream=0;
				cost=1.79;
				break;
			case "BlackTwoSugar":
				sugar=2;
				cream=0;
				cost=1.99;
				break;
			case "BlackThreeSugar":
				sugar=3;
				cream=0;
				cost=1.99;
				break;
		}
		
		//Cost calculator
		totalCost=(cost*noOfCups)+((cost*noOfCups*13)/100);
		String strTotalCost= String.format("%,5.2f", totalCost);
		Order order = new Order(noOfCups,size,type,totalCost);
		orderList.add(order);
		double totalCost2=0;
		for(Order o:orderList) {
			totalCost2 += o.getTotalCost();
		}
		totalCost2=Math.round(totalCost2*100.0)/100.0;
		model.addAttribute("orderList", orderList);
		model.addAttribute("noOfCups",noOfCups);
		model.addAttribute("sugar", sugar);
		model.addAttribute("cream",cream);
		model.addAttribute("totalCost",strTotalCost);
		model.addAttribute("totalCost2",totalCost2);
		model.addAttribute("cost",cost);
		return "output";
	}
	
}
