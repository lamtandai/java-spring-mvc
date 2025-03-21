package vn.hoidanit.laptopshop.service;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import vn.hoidanit.laptopshop.domain.dto.loginDTO;


public class LoginValidator implements ConstraintValidator<LoginChecked, loginDTO> {
    final private UserService userService;

    public LoginValidator (UserService userService){
        this.userService=userService;
    }

    @Override
    public boolean isValid(loginDTO user, ConstraintValidatorContext context) {
        boolean valid = true;

        boolean userExists = this.userService.handleCheckExistByEmail(user.getEmail());
        if (!userExists){
            context.buildConstraintViolationWithTemplate("Email or Password is not correct") 
                    // trường thông tin báo lỗi -> lỗi ở đâu
                    .addPropertyNode("email") 

                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        if (!valid){
            return valid;
        }

        // Check if password fields match
    
        return valid;
    }
}
