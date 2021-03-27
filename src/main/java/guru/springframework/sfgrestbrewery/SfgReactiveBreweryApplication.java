package guru.springframework.sfgrestbrewery;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@SpringBootApplication
public class SfgReactiveBreweryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SfgReactiveBreweryApplication.class, args);
    }

    @Value("classpath:/schema.sql")
    Resource resource;

    @Bean
    ConnectionFactoryInitializer initializer (ConnectionFactory connectionFactory){
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(resource));

        return initializer;
    }
}
