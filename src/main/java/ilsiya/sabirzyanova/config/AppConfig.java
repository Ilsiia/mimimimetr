package ilsiya.sabirzyanova.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"ilsiya.sabirzyanova"})
@Import({DaoConfig.class})
public class AppConfig {

}
