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
public class TotalBillController {
	
	@Autowired
	private TotalBillService service;
	
	
	// handler methods...
				@RequestMapping("/totalBill")
				public String viewHomePage(Model model) {
					List<TotalBill> listTotalBill = service.listAll();
					model.addAttribute("listTotalBill" , listTotalBill);
					return "totalBill_index";
					
					
				}
				
				@RequestMapping("/newTotalBill")
				public String showNewTotalBillPage(Model model) {
					
					TotalBill totalBill = new TotalBill();
					model.addAttribute("totalBill" , totalBill);
					return "new_totalBill";
					
				}
				
				@RequestMapping(value = "/saveTotalBill" , method = RequestMethod.POST)
				public String saveTotalBill(@ModelAttribute("totalBill") TotalBill totalBill,Model model) {
					
					service.save(totalBill);
					List<TotalBill> listTotalBill = service.listAll();
					model.addAttribute("listTotalBill" , listTotalBill);
					return "redirect:/";
					
					
				}
				
				@RequestMapping(value = "/updateTotalBill" , method = RequestMethod.POST)
				public String updateTotalBill(@ModelAttribute("totalBill") TotalBill totalBill,Model model) {
					
					TotalBill t = service.get(totalBill.getBillNumber());
					t.setBillTime(totalBill.getBillTime());
					service.save(t);
					List<TotalBill> listTotalBill = service.listAll();
					model.addAttribute("listTotalBill" , listTotalBill);
					return "redirect:/";
				}
				
				@RequestMapping("/editTotalBill/{id}")
						public ModelAndView showEditTotalBillPage(@PathVariable(name = "id") int id) {
							ModelAndView mav = new ModelAndView("edit_totalBill");
							TotalBill totalBill = service.get(id);//.get(id);
							mav.addObject("totalBill", totalBill);
							return mav;
							
							
						}
				@RequestMapping("/deleteTotalBill/{id}")
				public String deleteTotalBill(@PathVariable(name = "id") int id) {
					service.delete(id);
					return "redirect:/";

				}

}
