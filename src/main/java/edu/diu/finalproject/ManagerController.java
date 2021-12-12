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
public class ManagerController {
	
	@Autowired
	private ManagerService service;
	
	
	// handler methods...
		@RequestMapping("/manager")
		public String viewHomePage(Model model) {
			List<Manager> listManager = service.listAll();
			model.addAttribute("list" , listManager);
			return "manager_index";
			
			
		}
		
		@RequestMapping("/newManager")
		public String showNewManagerPage(Model model) {
			
			Manager manager = new Manager();
			model.addAttribute("manager" , manager);
			return "new_manager";
			
		}
		
		@RequestMapping(value = "/saveManager" , method = RequestMethod.POST)
		public String saveManager(@ModelAttribute("manager") Manager manager,Model model) {
			
			service.save(manager);
			List<Manager> listManager = service.listAll();
			model.addAttribute("listManager" , listManager);
			return "redirect:/";
			
			
		}
		
		@RequestMapping(value = "/updateManager" , method = RequestMethod.POST)
		public String updateBill(@ModelAttribute("manager") Manager manager,Model model) {
			
			Manager m = service.get(manager.getmId());
			m.setmName(manager.getmName());
			service.save(m);
			List<Manager> listManager = service.listAll();
			model.addAttribute("listManager" , listManager);
			return "redirect:/";
		}
		
		@RequestMapping("/editManager/{id}")
				public ModelAndView showEditManagerPage(@PathVariable(name = "id") int id) {
					ModelAndView mav = new ModelAndView("edit_manager");
					Manager manager = service.get(id);
					mav.addObject("manager", manager);
					return mav;
					
					
				}
		@RequestMapping("/deleteManager/{id}")
		public String deleteManager(@PathVariable(name = "id") int id) {
			service.delete(id);
			return "redirect:/";

		}
}
