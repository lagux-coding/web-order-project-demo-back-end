package OrderFoodDrink.OrderFoodDrink.config;

import com.google.firebase.internal.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Bean
    public WebMvcConfigurer webMvc() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://192.168.100.2:5173/") // Specifies the allowed origin
                        .allowedMethods("GET", "POST", "PUT", "PATCH","DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT")
                        .allowedHeaders("*")
                        .allowCredentials(true);// Specifies allowed HTTP methods

            }
        };
    }

}
