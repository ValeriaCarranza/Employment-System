package MySpring.MySpring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import MySpring.MySpring.dao.CompensationDAO;
import MySpring.MySpring.dao.ContactDAO;
import MySpring.MySpring.dao.EmployeeDAO;
import MySpring.MySpring.model.Compensation;
import MySpring.MySpring.model.CompensationValidation;
import MySpring.MySpring.model.Contact;
import MySpring.MySpring.model.Employee;
import MySpring.MySpring.model.EmployeeValidation;

@Controller
public class HomeController {

	@Autowired
	private EmployeeDAO emDAO;
	@Autowired
	private CompensationDAO comDAO;
	
	private EmployeeValidation emVa;
	private CompensationValidation comVa;
	
	

	public HomeController() {
		this.emVa= new EmployeeValidation();
		this.comVa = new CompensationValidation();
	}

	@RequestMapping(value = "/")
	public ModelAndView listContact(ModelAndView model) {
		List<Employee> list = emDAO.get();
		model.addObject("list", list);
		model.setViewName("home");
		return model;

	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newEmployee(ModelAndView model) {
		Employee newEmployee = new Employee();
		model.addObject("employee", newEmployee);
		model.setViewName("employee_form");
		
		return model;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee, RedirectAttributes flash,
										BindingResult result,
										SessionStatus status
			) {
		this.emVa.validate(employee, result);
		
		if(result.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.addObject("employee", employee);
			model.setViewName("employee_form");
			
			return model;
		}else {
			
			if(emDAO.employeExist(employee.getFirst_name(), employee.getMiddle_name(), employee.getLast_name(), employee.getBirth()).isEmpty()) {
				emDAO.save(employee);
				flash.addFlashAttribute("success", "The employee has been added successfully");
				return new ModelAndView("redirect:/");
			}else {
				flash.addFlashAttribute("failed", "The employee cannot be added because he already exists");
				return new ModelAndView("redirect:/");
			}
		}
		
		
	}
		
	 @RequestMapping(value="/edit", method = RequestMethod.GET) 
	 public ModelAndView editContact(HttpServletRequest request) { 
	 Integer id = Integer.parseInt(request.getParameter("id")); 
	 Employee employee = emDAO.get(id);
	
	 ModelAndView model = new ModelAndView("info_form");
	 model.addObject("employee", employee);
	
	  return model; 
	  }
	 
	
	 
	 @RequestMapping(value="/update", method = RequestMethod.POST)
		public ModelAndView updateEmployee(@ModelAttribute Employee employee, RedirectAttributes flash ) {
			System.out.println(employee);
			emDAO.update(employee);
			flash.addFlashAttribute("editSuccess", "The employee has been successfully edited");
			return new ModelAndView("redirect:/");
		}
	 
	 @RequestMapping(value="/delete", method = RequestMethod.GET) public
	 ModelAndView deleteContact(@RequestParam Integer id) 
	 { 
		 emDAO.delete(id);
	  
	 return new ModelAndView("redirect:/");
	 
	 }
	 
	 ////////////////////////////////////Compensations
	 
	 @RequestMapping(value="/compensations", method = RequestMethod.GET)
	 public ModelAndView listCompensations(HttpServletRequest request) {
		 Integer id = Integer.parseInt(request.getParameter("id")); 
		 Employee newEmploye = emDAO.get(id);
		 List<Compensation> compensation = comDAO.getCompensations(id);
		 ModelAndView model = new ModelAndView("compensation_employe");
		 model.addObject("list", compensation);
		 model.addObject("id", newEmploye);
		 return model;
	 }
	 
	 @RequestMapping(value = "/newCompensation", method = RequestMethod.GET)
		public ModelAndView newCompensation(HttpServletRequest request) {
		 Integer id = Integer.parseInt(request.getParameter("id")); 
		 	Employee newEmploye = emDAO.get(id);
			Compensation com = new Compensation();
			ModelAndView model = new ModelAndView("compensation_form");
			model.addObject("compensation", newEmploye);
			model.addObject("com", com);
			
			
			return model;
		}
	 
	 @RequestMapping(value="/saveCompensation", method = RequestMethod.POST)
		public ModelAndView saveCompensation(@ModelAttribute Compensation compensation,  
															 RedirectAttributes flash,
															 BindingResult result,
																SessionStatus status) {
		 
		    String type = compensation.getType_com();
		    String date = compensation.getDate_com();
		    System.out.print(type);
		    
		    if(!type.equals("Salary")) {
		    	comDAO.save(compensation);
				flash.addFlashAttribute("success", "The compensation has been added successfully");
				return new ModelAndView("redirect:/compensations?id="+compensation.getId_employee());
		    }else {
		    	if(comDAO.salaryExist(compensation.getId_employee(), date).isEmpty()) {
			    	System.out.println(compensation);
					comDAO.save(compensation);
					flash.addFlashAttribute("success", "The compensation has been added successfully");
					return new ModelAndView("redirect:/compensations?id="+compensation.getId_employee());
			    }else {
			    	flash.addFlashAttribute("failed", "The type of compensation cannot be Salary because there is already one in this month");
					return new ModelAndView("redirect:/compensations?id="+compensation.getId_employee());
			    }
		    }
		    
		    
		}
	 
	 @RequestMapping(value="/editCom", method = RequestMethod.GET)
	 public ModelAndView editCompensation(HttpServletRequest request) {
		 Integer id = Integer.parseInt(request.getParameter("id")); 
		 Compensation compensation = comDAO.get(id);
		
		 ModelAndView model = new ModelAndView("compensation_form_edit");
		 model.addObject("compensation", compensation);
		
		  return model; 
	 }
	 
	 @RequestMapping(value="/updated", method = RequestMethod.POST)
		public ModelAndView updateCompe(@ModelAttribute Compensation compensation, RedirectAttributes flash) {
			System.out.println(compensation);
			comDAO.update(compensation);
			flash.addFlashAttribute("editSuccess", "The compensation has been successfully edited");
			return new ModelAndView("redirect:/compensations?id="+compensation.getId_employee());
		}
	 
	 @RequestMapping(value="/deleteCom", method = RequestMethod.GET) 
	 public ModelAndView deleteCom(@RequestParam Integer id) 
	 { 
		 Compensation compensation = comDAO.get(id);
		 comDAO.delete(id);
	  
	 return new ModelAndView("redirect:/compensations?id="+compensation.getId_employee());
	 
	 }
	 
	 @RequestMapping(value="/compensationMonth", method = RequestMethod.POST) 
	 public ModelAndView compensationMonth(@RequestParam Integer id, String year, String month) 
	 { 
		 String date = year + "-" + month + "-01";
		 int total = 0;
		 Employee newEmploye = emDAO.get(id);
		 List<Compensation> compensation = comDAO.getCompensations(id, date);
		 for(Compensation em : compensation) {
				total += em.getAmount();
			}
		 ModelAndView model = new ModelAndView("compensation_employe");
		 model.addObject("list", compensation);
		 model.addObject("id", newEmploye);
		 model.addObject("total", total);
		 return model; 
	 }
	 
}
