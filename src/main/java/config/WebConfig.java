package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// cấu hình mvc
@Configuration // chú thích đây là lớp câu hình
@EnableWebMvc // sử dụng câ hình mvc
@ComponentScan(basePackages = {"controller","service"}) // quét pakage để tự động phat hiện bean (@Component,@Controller, @Service,@Repository)
public class WebConfig {
    // cấu hình view
    // định nghĩa Bean
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
