package ra.todolist;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
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
                case "ADD":
                    // hiển thị form thêm mới
                    showFormAdd(response);
                    break;
            }
        }

    }
    // hiển thị form thêm mới
    protected void showFormAdd(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // tiếng việt ở respone trả về
        response.setCharacterEncoding("UTF-8");
        // tạo biê lưu trữ chuô html cần hiển thị trong tbody
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Them moi cong viec</h1>");

        out.println("<form action=\"TodoServlet\" method=\"post\">\n" +
                "  <label for=\"content\">Nội dung công việc</label>\n" +
                "  <input type=\"text\" name=\"content\" id=\"content\"> <br>\n" +
                "  <input type=\"submit\" name=\"action\" value=\"ADD\">\n" +
                "</form>");
        out.println("</body></html>");
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
                    "    <td>"+(todo.isStatus()?"Xong":"Chưa xong")+"</td>\n" +
                    "    <td><a href=\"TodoServlet?action=DELETE&id="+todo.getId()+"\">Xóa</a></td>\n" +
                    "    <td><a>Sửa</a></td>\n" +
                    "  </tr>\n";
        }
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Danh sach cong viec</h1>");
        out.println("<a href=\"TodoServlet?action=ADD\">+ Thêm mơi công việc</a>");
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
       request.setCharacterEncoding("UTF-8");
        // nhận thông tin gửi theo post
        // dựa vào action  để phân chia chức năng
        // lấy 1 tham số theo name : getParameter
        String action = request.getParameter("action");

        if (action!=null) {
            switch (action) {

                case "ADD":
                    // hiển thị form thêm mới
                    // lấy nội dung trong  input và tạo mới todo
                    doAddTodo(request);
                    // hien thi lai danh sach
                    displayTodoList(response);
                    break;
            }
        }
    }
    // xử lí thêm mới
    protected void doAddTodo(HttpServletRequest request) throws ServletException, IOException {
        // lấy ra content
        String content = request.getParameter("content");
        // tạo todo
        Todo newTodo = new Todo(getNewId(),content,false);
        // them vao danh sach
        todoList.add(newTodo);
    }
    // id tự tăng
    protected int getNewId(){
        int idMax = todoList.stream()
                .max(Comparator.comparingInt(Todo::getId))
                .orElse(new Todo())
                .getId();
        return idMax+1;
    }
}