package ra.mvc.controller;

import ra.mvc.service.customer.CustomerService;
import ra.mvc.service.customer.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/customers")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action!=null){
            switch (action){
                case "GETALL":
                    // laays danh sachs khachs hang
                    request.setAttribute("customers",customerService.findAll());
                    request.getRequestDispatcher("/views/list-customer.jsp").forward(request,response);
                    break;
                case "DELETE":
                    // laay id
                    Integer id = Integer.valueOf(request.getParameter("id"));
                    customerService.delete(id);
                    response.sendRedirect("/customers?action=GETALL");
                    break;
        }
        }
    }
}
