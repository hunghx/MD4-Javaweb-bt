package ra.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ra.mvc.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
//@RequestMapping("/home") // định nghia url mapping áp dụng cho lớp
public class HomeController {
//    @RequestMapping // khớp vs đường dẫn rỗng
    @GetMapping // phương thư get
    public String home() {
        return "home";
    }
//    @RequestMapping(value = "/product",method = RequestMethod.POST) // /home/product
    @PostMapping("/product") // theo phơng thức post
    public String product(ModelMap map) {
        map.addAttribute("banana","chuối");
        map.containsAttribute("banana"); // có các tính chất của MAP collection
        return "product";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String doAdd(Model model){
        // model dung de vận chuyển dữ liệu tư controller sang view
        model.addAttribute("name","hunghx");
        model.addAttribute("age","19");
        return "add"; // view name
    }
    @RequestMapping(value = "/about",method = RequestMethod.POST)
    public ModelAndView about(){
        // sự kết hợp giữ model và view
//        View view = new View() {
//            @Override
//            public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//                request.setAttribute();
//                 request.getRequestDispatcher("/views/add.jsp").forward(request,response);
//            }
//            @Override
//            public String getContentType() {
//                return View.super.getContentType();
//            }
//        };
        ViewResolver viewResolver = new InternalResourceViewResolver();
        ModelAndView modelAndView = new ModelAndView("about");
//        modelAndView.setView(view);
        modelAndView.addObject("name","hunghx");
        modelAndView.addObject("age","19");
        return modelAndView;
    }
    // định nghĩa các đường dẫn theo phương thức cụ thể
    // định nghĩa đường dẫn có tham số
    @GetMapping("/product/{id:^[0-9]+$}") // đinh nghĩa 1 tham số là id trên đường dẫn - ví dụ /product/1
    public String findById(@PathVariable("id") int idDetail){
//        id =????
        return "details";


    }
    // biểu thư chính qui
    @GetMapping("/regex/{name:^\\w+@gmail.com$}")
    public String handle(@PathVariable("name") String name){
        return "hehe";
    }

    // xử lí đăng nhâp
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session){
        // sau khi check thoong tin ddawng nhaapj thif luu o dau ?
        // session cuar server
        session.setAttribute("userlogin",new User());
        return "redirect:/";
    }

    // mua hangf
    @PostMapping("/cart")
    public String handlerCart ( HttpSession session){
       User user = (User) session.getAttribute("userlogin");
       // laays ddc thoong tin ng dung
        return "cart";
    }

}
