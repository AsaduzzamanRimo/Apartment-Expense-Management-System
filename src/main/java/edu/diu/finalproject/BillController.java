package edu.diu.finalproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BillController {
	
	@Autowired
	 private BillService service;
	
	// handler methods...
	@RequestMapping("/bill")
	public String viewHomePage(Model model) {
		List<Bill> listBill = service.listAll();
		model.addAttribute("listBill" , listBill);
		return "bill_index";
		
		
	}
	
	@RequestMapping("/newBill")
	public String showNewBillPage(Model model) {
		
		Bill bill = new Bill();
		model.addAttribute("bill" , bill);
		return "new_bill";
		
	}
	
	@RequestMapping(value = "/saveBill" , method = RequestMethod.POST)
	public String saveBill(@ModelAttribute("bill") Bill bill,Model model) {
		
		service.save(bill);
		List<Bill> listBill = service.listAll();
		model.addAttribute("listBill" , listBill);
		return "redirect:/";
		
		
	}
	
	@RequestMapping(value = "/updateBill" , method = RequestMethod.POST)
	public String updateBill(@ModelAttribute("bill") Bill bill,Model model) {
		
		Bill b = service.get(bill.getBillId());
		b.setBillName(bill.getBillName());
		service.save(b);
		List<Bill> listBill = service.listAll();
		model.addAttribute("listBill" , listBill);
		return "redirect:/";
	}
	
	@RequestMapping("/editBill/{id}")
			public ModelAndView showEditBillPage(@PathVariable(name = "id") int id) {
				ModelAndView mav = new ModelAndView("edit_bill");
				Bill bill = service.get(id);
				mav.addObject("bill", bill);
				return mav;
				
				
			}
	@RequestMapping("/deleteBill/{id}")
	public String deleteBill(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
		
	}
	
	
			
			
		
	
	
	

}
