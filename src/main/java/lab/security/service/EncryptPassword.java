package lab.security.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author lucas
 */
@Component
public class EncryptPassword {
    
    @Bean
    public BCryptPasswordEncoder encript(){
        return new BCryptPasswordEncoder();
    }
}
