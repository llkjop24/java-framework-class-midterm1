package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class ProductDao{
    private final JdbcContext jdbcContext = new JdbcContext();
    private DaoFactory daoFactory;

    public  ProductDao(DataSource dataSource) {
        this.jdbcContext.dataSource = dataSource;
    }

    public Product get(Long id) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");
            preparedStatement.setLong(1, id);
            return preparedStatement;
        };
        return jdbcContext.JdbcContextForGet(statementStrategy);
    }


    public Long insert(Product product) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into product (title, price) values(?,?)");
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setInt(2, product.getPrice());

            return preparedStatement;
        };
        return jdbcContext.JdbcContextforInsert(statementStrategy);
    }


    public void update(Product product) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("update product set title= ?, price=? where id = ?");
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setLong(3, product.getId());
            return preparedStatement;
        }; 
        jdbcContext.JdbcContxtForUpdate(statementStrategy);
    }


    public void delete(Long id) throws SQLException {
        StatementStrategy statementStrategy =connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id=?");
            preparedStatement.setLong(1, id);
            return preparedStatement;
        };
        jdbcContext.JdbcContxtForUpdate(statementStrategy);
    }
}
