package ra.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String home(Model model) {
        int age =10;
        String name = "Nguyễn VĂn A";
        String html = "<a>Link</a>";
        int[] array = {1,2,3,4,6,7,8,9};
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("arr", array);
        model.addAttribute("html", html);
        return "home";
    }
    @GetMapping("/product")
    public String product(){
        return "product";
    }
}
