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
public class LiftBillController {
	
	
	@Autowired
	private LiftBillService service;
	
	
	// handler methods...
		@RequestMapping("/liftBill")
		public String viewHomePage(Model model) {
			List<LiftBill> listliftBill = service.listAll();
			model.addAttribute("listliftBill" , listliftBill);
			return "liftBill_index";
			
			
		}
		
		@RequestMapping("/newLiftBill")
		public String showNewLiftBillPage(Model model) {
			
			LiftBill liftBill = new LiftBill();
			model.addAttribute("liftBill" , liftBill);
			return "new_liftBill";
			
		}
		
		@RequestMapping(value = "/saveLiftBill" , method = RequestMethod.POST)
		public String saveLiftBill(@ModelAttribute("liftBill") LiftBill liftBill,Model model) {
			
			service.save(liftBill);
			List<LiftBill> listliftBill = service.listAll();
			model.addAttribute("listliftBill" , listliftBill);
			return "redirect:/";
			
			
		}
		
		@RequestMapping(value = "/updateLiftBill" , method = RequestMethod.POST)
		public String updateLiftBill(@ModelAttribute("liftBill") LiftBill liftBill,Model model) {
			
			LiftBill lb = service.get(liftBill.getLiftBillId());
			lb.setLiftBillId(liftBill.getLiftBillId());
			service.save(lb);
			List<LiftBill> listliftBill = service.listAll();
			model.addAttribute("listliftBill" , listliftBill);
			return "redirect:/";
		}
		
		@RequestMapping("/editLiftBill/{id}")
				public ModelAndView showEditLiftBillPage(@PathVariable(name = "id") int id) {
					ModelAndView mav = new ModelAndView("edit_liftBill");
					LiftBill liftBill = service.get(id);
					mav.addObject("liftBill", liftBill);
					return mav;
					
					
				}
		@RequestMapping("/deleteLiftBill/{id}")
		public String deleteLiftBill(@PathVariable(name = "id") int id) {
			service.delete(id);
			return "redirect:/";
			
		}

}
