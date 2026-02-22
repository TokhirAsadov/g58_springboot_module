package uz.pdp.springboot_module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import uz.pdp.springboot_module.security.UserSession;

import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootModuleApplication {

    private final UserSession userSession;

    public SpringbootModuleApplication(UserSession userSession) {
        this.userSession = userSession;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootModuleApplication.class, args);
    }

    @Bean
    public AuditorAware<Long> auditorAware() {
        return () -> Optional.ofNullable(userSession.getUserId());
    }


}
