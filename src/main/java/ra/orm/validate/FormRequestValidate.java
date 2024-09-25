package ra.orm.validate;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ra.orm.model.FormRequest;
@Component
public class FormRequestValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(FormRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        FormRequest formRequest  = (FormRequest) target;

        // kiểm tra check box
        if (formRequest.getCheckboxValue()==null){
            // ném ra lỗi
            errors.rejectValue("checkboxValue",null,"khong dươc null");
        }
        // kiemr tra select
        if (formRequest.getSelectedValues()==null || formRequest.getSelectedValues().isEmpty()){
            // ném ra lỗi
            errors.rejectValue("selectedValues",null,"khong dươc trống");
        }
        if (formRequest.getName().trim().isEmpty()){
            // ném ra lỗi
            errors.rejectValue("name",null,"khong dươc để trống");
        }
        if (!formRequest.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")){
            // ném ra lỗi
            errors.rejectValue("password",null,"mật khẩu ko đúng định dạng");
        }

    }
}
