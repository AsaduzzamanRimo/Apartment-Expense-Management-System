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
public class DustServiceBillController {
	
	@Autowired
	private DustServiceBillService service;
	
	
	// handler methods...
				@RequestMapping("/dustServiceBill")
				public String viewHomePage(Model model) {
					List<DustServiceBill> listDustServiceBill = service.listAll();
					model.addAttribute("list" , listDustServiceBill);
					return "dustServiceBill _index";
					
					
				}
				
				@RequestMapping("/newdustServiceBill")
				public String showNewDustServiceBillPage(Model model) {
					
					DustServiceBill dustServiceBill = new DustServiceBill();
					model.addAttribute("dustServiceBill" , dustServiceBill);
					return "new_dustServiceBill";
					
				}
				
				@RequestMapping(value = "/saveDustServiceBill" , method = RequestMethod.POST)
				public String saveCommonCurrentBill(@ModelAttribute("dustServiceBill") DustServiceBill dustServiceBill,Model model) {
					
					service.save(dustServiceBill);
					List<DustServiceBill> listDustServiceBill = service.listAll();
					model.addAttribute("listDustServiceBill" , listDustServiceBill);
					return "redirect:/";
					
					
				}
				
				@RequestMapping(value = "/updateDustServiceBill" , method = RequestMethod.POST)
				public String updateBill(@ModelAttribute("DustServiceBill") DustServiceBill dustServiceBill,Model model) {
					
					DustServiceBill dsb = service.get(dustServiceBill.getDustServiceBillId());
					dsb.setDustServiceBillId(dustServiceBill.getDustServiceBillId());//.setBillTime(dustServiceBill.getBillTime());
					service.save(dsb);
					List<DustServiceBill> listDustServiceBill = service.listAll();
					model.addAttribute("listDustServiceBill" , listDustServiceBill);
					return "redirect:/";
				}
				
				@RequestMapping("/editDustServiceBill/{id}")
						public ModelAndView showEditDustServiceBillPage(@PathVariable(name = "id") int id) {
							ModelAndView mav = new ModelAndView("edit_DustServiceBill");
							DustServiceBill dustServiceBill = service.get(id);
							mav.addObject("dustServiceBill", dustServiceBill);
							return mav;
							
							
						}
				@RequestMapping("/deleteDustServiceBill/{id}")
				public String deleteDustServiceBill(@PathVariable(name = "id") int id) {
					service.delete(id);
					return "redirect:/";

				}

}
