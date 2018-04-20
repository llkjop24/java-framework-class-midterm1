package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class ProductDao{
    private final JdbcContext jdbcContext = new JdbcContext();
    private DaoFactory daoFactory;

    public  ProductDao(DataSource dataSource) {
        this.jdbcContext.dataSource = dataSource;
    }


    public Product get(Long id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new GetStatementStrategy(id);
        return jdbcContext.JdbcContextForGet(statementStrategy);
    }


    public Long insert(Product product) throws SQLException, ClassNotFoundException {
        StatementStrategy statementStrategy = new InsertStatementStrategy(product);
        return jdbcContext.JdbcContextforInsert(statementStrategy);
    }


    public void update(Product product) throws SQLException {
        StatementStrategy statementStrategy = new UpdataStatementStrategy(product);
        jdbcContext.JdbcContxtForUpdate(statementStrategy);
    }


    public void delete(Long id) throws SQLException {
        StatementStrategy statementStrategy = new DeleteStatementStrategy(id);
        jdbcContext.JdbcContxtForUpdate(statementStrategy);
    }
}
