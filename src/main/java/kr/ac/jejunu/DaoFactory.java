package kr.ac.jejunu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
public class DaoFactory {
    @Value("${db.classname}")
    private String classaname;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Bean
    public ProductDao productDao() throws ClassNotFoundException {
        return new ProductDao(jdbcTemplate());
    }

    private JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    private DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        try {
            dataSource.setDriverClass((Class<? extends Driver>) Class.forName(classaname));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


}
