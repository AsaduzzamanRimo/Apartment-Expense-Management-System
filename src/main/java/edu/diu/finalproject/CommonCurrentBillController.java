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
public class CommonCurrentBillController {
	
	@Autowired
	private CommonCurrentBillService service;
	
	
	// handler methods...
			@RequestMapping("/commonCurrentBill")
			public String viewHomePage(Model model) {
				List<CommonCurrentBill> listCommonCurrentBill = service.listAll();
				model.addAttribute("list" , listCommonCurrentBill);
				return "commonCurrentBill_index";
				
				
			}
			
			@RequestMapping("/newcommonCurrentBill")
			public String showNewCommonCurrentBillPage(Model model) {
				
				CommonCurrentBill commonCurrentBill = new CommonCurrentBill();
				model.addAttribute("commonCurrentBill" , commonCurrentBill);
				return "new_commonCurrentBill";
				
			}
			
			@RequestMapping(value = "/saveCommonCurrentBill" , method = RequestMethod.POST)
			public String saveCommonCurrentBill(@ModelAttribute("commonCurrentBill") CommonCurrentBill commonCurrentBill,Model model) {
				
				service.save(commonCurrentBill);
				List<CommonCurrentBill> listCommonCurrentBill = service.listAll();
				model.addAttribute("listCommonCurrentBill" , listCommonCurrentBill);
				return "redirect:/";
				
				
			}
			
			@RequestMapping(value = "/updateCommonCurrentBill" , method = RequestMethod.POST)
			public String updateBill(@ModelAttribute("CommonCurrentBill") CommonCurrentBill commonCurrentBill,Model model) {
				
				CommonCurrentBill ccb = service.get(commonCurrentBill.getCommonCurrentBillId());
				ccb.setCommonCurrentBillId(commonCurrentBill.getCommonCurrentBillId());//setBillTime(commonCurrentBill.getBillTime());
				service.save(ccb);
				List<CommonCurrentBill> listCommonCurrentBill = service.listAll();
				model.addAttribute("listCommonCurrentBill" , listCommonCurrentBill);
				return "redirect:/";
			}
			
			@RequestMapping("/editCommonCurrentBill/{id}")
					public ModelAndView showEditCommonCurrentBillPage(@PathVariable(name = "id") int id) {
						ModelAndView mav = new ModelAndView("edit_CommonCurrentBill");
						CommonCurrentBill commonCurrentBill = service.get(id);
						mav.addObject("commonCurrentBill", commonCurrentBill);
						return mav;
						
						
					}
			@RequestMapping("/deleteCommonCurrentBill/{id}")
			public String deleteCommonCurrentBill(@PathVariable(name = "id") int id) {
				service.delete(id);
				return "redirect:/";

			}

}
