package vn.hoidanit.laptopshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.DispatcherType;
import vn.hoidanit.laptopshop.service.CustomUserDetailsDervice;
import vn.hoidanit.laptopshop.service.UserService;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Bean
    public PasswordEncoder PasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    // ghi đè UserDetailsService bằng Custom của chúng ta
    public UserDetailsService userDetailsService(UserService userService) {
        return new CustomUserDetailsDervice(userService);
    }

    @Bean
    public DaoAuthenticationProvider authProvider(
            PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService) {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        authProvider.setHideUserNotFoundExceptions(false);

        return authProvider;
    }

    @Bean 
    public AuthenticationSuccessHandler customSuccessHandler(){
        return new CustomSuccessHandler();
    }
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http    
                .authorizeHttpRequests(authorize -> authorize
                //forward: cho phep forward tu url nay sang url khac cho moi request
                .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.INCLUDE) .permitAll()
                
                // tat ca dương link cho phep ngươi dung truy cap
                .requestMatchers("/","/login", "/client/**", "/css/**", "/js/**", "/images/**") .permitAll()
                .requestMatchers("/admin/**").hasRole("Admin")
                .anyRequest().authenticated()) // bat ki request deu duoc cho phep

                
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .failureUrl("/login?error")
                        .successHandler(customSuccessHandler())
                        .permitAll());

        return http.build();
    }
}
