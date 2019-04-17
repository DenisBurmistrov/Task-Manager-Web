package ru.burmistrov.taskManager.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "ru.burmistrov.taskManager")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("ru.evseenko.api.repository")
public class JpaConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("application.driver")));
        dataSource.setUrl(env.getProperty("application.url"));
        dataSource.setUsername(env.getProperty("application.user"));
        dataSource.setPassword(env.getProperty("application.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            final DataSource dataSource
    ) {
        final LocalContainerEntityManagerFactoryBean factoryBean;
        factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan("ru.evseenko");

        final Properties properties = new Properties();
        properties.put("hibernate.show_sql", Objects.requireNonNull(env.getProperty("application.show_sql")));
        properties.put("hibernate.hbm2ddl.auto", Objects.requireNonNull(env.getProperty("application.hbm2ddl.auto")));
        properties.put("hibernate.dialect", Objects.requireNonNull(env.getProperty("application.dialect")));
        factoryBean.setJpaProperties(properties);

        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(
            final LocalContainerEntityManagerFactoryBean emf
    ) {
        final JpaTransactionManager transactionManager =
                new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf.getObject());
        return transactionManager;
    }
}
