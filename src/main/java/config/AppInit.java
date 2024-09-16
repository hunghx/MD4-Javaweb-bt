package config;

// cấu hình dispatcherServlet

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // đọc các cấu hình gốc : ko liên quan tới mvc
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // cấu hình servlet , liên quan tới mvc
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    // hỗ trợ utf-8

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter("utf-8",true);
        return new Filter[]{filter};
    }
}
