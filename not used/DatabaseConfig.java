package qinetic.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import javax.persistence.*;
import org.springframework.transaction.annotation.*;
import org.springframework.orm.jpa.vendor.*;
import org.hibernate.*;
import org.hibernate.ejb.*;
import org.springframework.boot.autoconfigure.*;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
        HibernateJpaSessionFactoryBean fact = new HibernateJpaSessionFactoryBean();
        fact.setEntityManagerFactory(emf);
        return fact;
    }
}