package ra.orm.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordValidator.class})
public @interface Password {
    String message() default "Mât khẩu không hợp lệ (pattern: ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=+$).{8,}$)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
