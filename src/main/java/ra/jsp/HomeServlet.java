package ra.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(Objects.equals(action, "abc")){
            // gửi thông tin sang file home.jsp và hiên thị thông tin ở đó
            String name = "hunghx";
            int age = 20;
            String phone = "0929478674";

            request.setAttribute("name", name);
            request.setAttribute("age", age);
            request.setAttribute("phone", phone);

           RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
           requestDispatcher.forward(request,response);
        }else if(action.equals("bca")){
            // chuyên trang tự động
            response.sendRedirect("/profile.jsp");
        }else if(action.equals("xxx")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/cart.jsp");
            requestDispatcher.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}