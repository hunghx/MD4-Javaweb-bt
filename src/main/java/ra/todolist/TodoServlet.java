package ra.todolist;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TodoServlet", value = "/TodoServlet")
public class TodoServlet extends HttpServlet {
    // tạo danh sách măc định
    private static List<Todo> todoList = new ArrayList<>();
    static {
        // khởi tạo giá trị cho danh sách
        todoList.add(new Todo(1,"ĐI học", true));
        todoList.add(new Todo(2,"ĐI ngủ", false));
        todoList.add(new Todo(3,"ĐI chơi", true));
    }
    // phân tích bài toán
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // dựa vào action  để phân chia chức năng
        // lấy 1 tham số theo name : getParameter
        String action = request.getParameter("action");

        if (action!=null){
            switch (action){
                case "GETALL":
                    // hiển thị đanh sách
                    displayTodoList(response);
                    break;
                case "DELETE":
                    // lây đc id của công vệc cần xóa
                    int id = Integer.parseInt(request.getParameter("id"));
                    // tiên hành xóa
                    deleteById(id);
                    // hiển thị lại giao diện
                    displayTodoList(response);
                    break;
            }
        }

    }
    // hàm xóa theo id
    protected void deleteById(int idDel){
        // lấy đối tượng todo cần xóa
        Todo todo = todoList.stream().filter(t-> t.getId() == idDel).findFirst().orElse(null);
        if (todo!=null){
            todoList.remove(todo); // xóa theo object
        }
    }
    // hàm hiển thị danh sách
    protected void displayTodoList(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // tiếng việt ở respone trả về
        response.setCharacterEncoding("UTF-8");
        // tạo biê lưu trữ chuô html cần hiển thị trong tbody
        String htmlBody = "";
        // duyệt danh sách
        for (Todo todo: todoList){
            htmlBody+=   "  <tr>\n" +
                    "    <td>"+todo.getId()+"</td>\n" +
                    "    <td>"+todo.getContent()+"</td>\n" +
                    "    <td>"+(todo.isStatus()?"XOng":"Chưa xong")+"</td>\n" +
                    "    <td><a href=\"TodoServlet?action=DELETE&id="+todo.getId()+"\">Xóa</a></td>\n" +
                    "    <td><a>Sửa</a></td>\n" +
                    "  </tr>\n";
        }
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<table border=\"10\" cellspacing=\"0\" cellpadding=\"15\">\n" +
                "  <thead>\n" +
                "  <tr>\n" +
                "    <th>STT</th>\n" +
                "    <th>Content</th>\n" +
                "    <th>Status</th>\n" +
                "    <th colspan=\"2\">Action</th>\n" +
                "  </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n" +
               htmlBody +
                "  </tbody>\n" +
                "</table>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}