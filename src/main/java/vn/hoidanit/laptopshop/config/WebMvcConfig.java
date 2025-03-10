package vn.hoidanit.laptopshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

  @Bean
  public ViewResolver viewResolver() {
    final InternalResourceViewResolver bean = new InternalResourceViewResolver();
    bean.setViewClass(JstlView.class);
    bean.setPrefix("/WEB-INF/view/");
    bean.setSuffix(".jsp");
    return bean;
  }

  @Override
  public void configureViewResolvers(@SuppressWarnings("null")   ViewResolverRegistry registry) {
    registry.viewResolver(viewResolver());
  }
   @Override
    public void addResourceHandlers(@SuppressWarnings("null") ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/css/**").addResourceLocations("/content/css/");
      registry.addResourceHandler("/js/**").addResourceLocations("/content/js/");
      registry.addResourceHandler("/assets/demo/**").addResourceLocations("/content/assets/demo/");
      registry.addResourceHandler("/images/**").addResourceLocations("/content/images/");
      // ** nested bao nhieu thu muc thi van lay cho coderaddResourceHandler
        // addresourceLocation: find the location
    }

}
