package ra.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TodoServlet", value = "/TodoServlet")
public class TodoServlet extends HttpServlet {
    private static List<Todo> list = new ArrayList<>();
    static {
        list.add(new Todo(1,"ĐI học", true));
        list.add(new Todo(2,"ĐI cho", true));
        list.add(new Todo(3,"ĐI ngu", false));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action!=null){
            switch (action){
                case "GETALL":
                    // gửi danh sách sang giao diện
                    request.setAttribute("todos",list);
                    request.getRequestDispatcher("/pages/list.jsp").forward(request,response);
                    break;
                case "DELETE":
                    int idDel = Integer.parseInt(request.getParameter("id"));
                    Todo todoDel = list.stream().filter(t->t.getId()==idDel).findFirst().orElse(null);
                    if (todoDel!=null){
                        list.remove(todoDel);
                    }
                    response.sendRedirect("/");
                    break;
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}