package ra.orm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import ra.orm.validate.Password;

import javax.validation.constraints.NotNull;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FormRequest {
    @NotNull(message = "Bắt buộc chọn")
    private String checkboxValue;
    @NotEmpty(message = "Phải chọn ít nhất 1 option")
    private List<String> selectedValues;
    @NotBlank(message = "Tên không đưc để trồng")
    private String name;
    @Password(message = "mật khẩu ko hợp lệ")
    private String password;
}
