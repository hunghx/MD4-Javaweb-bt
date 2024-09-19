package ra.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import ra.mvc.model.Person;
import ra.mvc.model.UploadModel;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    // tiêm servlet context vào
    @Autowired
    private ServletContext servletContext;
    @RequestMapping
    public String home(Model model) {
        // gửi 1 model sang view
        model.addAttribute("listcheck", Arrays.asList("apple","orange","banana"));
        model.addAttribute("person",new Person());
        return "home";
    }

    @PostMapping("/doAdd")
    public String handleAdd(@ModelAttribute("person") Person person, Model model){
        // xử lí thêm mới
        // gửi kết quả ra giao diện
        model.addAttribute("obj",person);
        return "result";
    }
    @GetMapping("/upload")
    private String upload(Model model){
        model.addAttribute("uploadModel",new UploadModel());
        return "upload";
    }
    @PostMapping("/upload")
    public String doUpload(@ModelAttribute("uploadModel") UploadModel uploadModel, Model model){
        String single = "";
        List<String> multiple = new ArrayList<>();
        // xử li upload 1 file
        String path = servletContext.getRealPath("/uploads");// lấy ra đường đẫn thư mục upload trên server
        File file  = new File(path);
        if (!file.exists()){
            file.mkdirs(); // tạo mới thư mục
        }

        single = uploadFile(uploadModel.getSingle(), path); // upload 1
        for (MultipartFile f : uploadModel.getMultiple()){ // upload nhiều
            String uploadPath = uploadFile(f,path);
            multiple.add(uploadPath);
        }
        model.addAttribute("one",single);
        model.addAttribute("many",multiple);
        return "image";
    }

    private String uploadFile(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();// lấy ra tên file upload
        try {
            FileCopyUtils.copy(file.getBytes(),new File(path +File.separator+ fileName));
            return "/uploads/"+ fileName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
