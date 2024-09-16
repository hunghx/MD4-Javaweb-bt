package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ProductService;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/") // định nghĩa mapping đường dẫn, mặc đinnh là get
    public String home(Model model) {
        // lấy dữ liệu
        List<Product> productList = productService.findAll();
        // gưi dữ liệu sang view : Model
        model.addAttribute("list",productList);
        return "home";
    }
    @RequestMapping("/product") // định nghĩa mapping đường dẫn
    public String product() {
        return "product";
    }
    @RequestMapping("/profile") // định nghĩa mapping đường dẫn
    public String profile() {
        return "profile";
    }
    @RequestMapping("/about") // định nghĩa mapping đường dẫn
    public String about() {
        return "about";
    }
    @RequestMapping(value = "/product/form",method = RequestMethod.POST)
    public String handleForm(@RequestParam("name") String name
            , @RequestParam("price") int price){
        // lấy dữ liệu ra
        return "about";
    }
    // chuyen trang sang form
    @RequestMapping("/input")
    public String input(){
        return "form";
    }
    // xu li nhap
    @RequestMapping(value = "/input", method = RequestMethod.POST)
    public String doInput(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam String address,
            Model model
    ){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("phone",phone);
        model.addAttribute("address",address);
        model.addAttribute("email",email);
        return "info";
    }
    // ứng dụng làm chức năng nhập thông tin cá nhân : tên , tuổi, số điên thoại, email, địa chỉ
    // và hiển thị thông tin vưa nhập ra màn hình
}
