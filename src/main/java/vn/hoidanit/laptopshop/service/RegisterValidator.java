package vn.hoidanit.laptopshop.service;

import org.springframework.stereotype.Service;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import vn.hoidanit.laptopshop.domain.dto.registerDTO;

@Service
public class RegisterValidator implements ConstraintValidator<RegisterChecked, registerDTO> {

    final private UserService userService;

    public RegisterValidator (UserService userService){
        this.userService=userService;
    }

    @Override
    public boolean isValid(registerDTO user, ConstraintValidatorContext context) {
        boolean valid = true;

        // Check if password fields match
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            // thông báo lỗi là gì
            context.buildConstraintViolationWithTemplate("Passwords must match") 
                    // trường thông tin báo lỗi -> lỗi ở đâu
                    .addPropertyNode("confirmPassword") 

                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        if (this.userService.handleCheckExistByEmail(user.getEmail())){
            context.buildConstraintViolationWithTemplate("This Email is invalid") 
                    // trường thông tin báo lỗi -> lỗi ở đâu
                    .addPropertyNode("email") 
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        // Additional validations can be added here

        return valid;
    }
}
