package chenrujun.azure.spring.boot.starter.active.directory.sample;

import com.azure.spring.aad.implementation.AzureActiveDirectoryAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AzureActiveDirectoryAutoConfiguration.class)
public class AzureSpringBootStarterActiveDirectorySampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AzureSpringBootStarterActiveDirectorySampleApplication.class, args);
    }

}
