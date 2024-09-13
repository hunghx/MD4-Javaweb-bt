package ra.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ra.mvc.model.Customer;
import ra.mvc.service.customer.ICustomerService;

@Controller
@RequestMapping({"/customers","/"})
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @RequestMapping({"/list",""})
    public String showList(Model model){
        model.addAttribute("customers",customerService.findAll());
        return "list-customer";
    }
    @RequestMapping("/add")
    public String showFormAdd(){
        return "add-customer";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String doAdd(@ModelAttribute Customer customer){
        customer.setId(0);
        customerService.save(customer);
        // dieu huog lai danh sach
        return "redirect:/customers/list";
    }
}
