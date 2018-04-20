package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertStatementStrategy implements StatementStrategy {
    private Product product;

    public InsertStatementStrategy(Product product) {
        this.product = product;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into product (title, price) values(?,?)");
        preparedStatement.setString(1, product.getTitle());
        preparedStatement.setInt(2, product.getPrice());

        return preparedStatement;
    }
}