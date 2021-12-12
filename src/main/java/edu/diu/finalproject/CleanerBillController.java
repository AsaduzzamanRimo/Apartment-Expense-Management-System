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
public class CleanerBillController {
	
	@Autowired
	private CleanerBillService service;
	
	// handler methods...
				@RequestMapping("/cleanerBill")
				public String viewHomePage(Model model) {
					List<CleanerBill> listCleanerBill = service.listAll();
					model.addAttribute("listCleanerBill" , listCleanerBill);
					return "cleanerBill_index";
					
					
				}
				
				@RequestMapping("/newcleanerBill")
				public String showNewCleanerBillPage(Model model) {
					
					CleanerBill cleanerBill = new CleanerBill();
					model.addAttribute("cleanerBill" , cleanerBill);
					return "new_cleanerBill";
					
				}
				
				@RequestMapping(value = "/saveCleanerBill" , method = RequestMethod.POST)
				public String saveCleanerBill(@ModelAttribute("cleanerBill") CleanerBill cleanerBill,Model model) {
					
					service.save(cleanerBill);
					List<CleanerBill> listCleanerBill = service.listAll();
					model.addAttribute("listCleanerBill" , listCleanerBill);
					return "redirect:/";
					
					
				}
				
				@RequestMapping(value = "/updateCleanerBill" , method = RequestMethod.POST)
				public String updateBill(@ModelAttribute("CleanerBill") CleanerBill cleanerBill,Model model) {
					
					CleanerBill cb = service.get(cleanerBill.getCleanerBillId());
					cb.setCleanerBillId(cleanerBill.getCleanerBillId());//.getBillTime());
					service.save(cb);
					List<CleanerBill> listCleanerBill = service.listAll();
					model.addAttribute("listCleanerBill" , listCleanerBill);
					return "redirect:/";
				}
				
				@RequestMapping("/editCleanerBill/{id}")
						public ModelAndView showEditCleanerBillPage(@PathVariable(name = "id") int id) {
							ModelAndView mav = new ModelAndView("edit_CleanerBill");
							CleanerBill cleanerBill = service.get(id);
							mav.addObject("cleanerBill", cleanerBill);
							return mav;
							
							
						}
				@RequestMapping("/deleteCleanerBill/{id}")
				public String deleteCleanerBill(@PathVariable(name = "id") int id) {
					service.delete(id);
					return "redirect:/";

				}
	

}
