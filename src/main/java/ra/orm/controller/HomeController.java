package ra.orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private HttpSession session;
    @GetMapping
    public String count(@CookieValue(value = "count",defaultValue = "0") Integer count,
                        HttpServletResponse response, Model model){
        // B1 : lấy ra số lần truy cập trang chủ ở cookies của trình duyệt
        // B2 : tăng sô lần leen 1
        count++;
        // cập nhật count trong cookies
        Cookie cookie = new Cookie("count",count.toString());
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        model.addAttribute("count",count);
        return "home";
    }
    @GetMapping("/count")
    private String counter(Model model){
        // B1 lấy ra count hiện tại
        Object obj = session.getAttribute("count");
        Integer count = 0; // giá trị mặc định
        if (obj != null ){
            count = (Integer) obj;
        }
        count++;
        // lưu count lại trong session và ửi về phía giao dienj ng dùng
        session.setAttribute("count",count);
        model.addAttribute("count",count);
        return "count";
    }
}
