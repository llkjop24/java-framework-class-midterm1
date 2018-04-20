package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdataStatementStrategy implements StatementStrategy {
    private Product product;

    public UpdataStatementStrategy(Product product) {
        this.product = product;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update product set title= ?, price=? where id = ?");
        preparedStatement.setString(1, product.getTitle());
        preparedStatement.setInt(2, product.getPrice());
        preparedStatement.setLong(3, product.getId());
        return preparedStatement;    }
}
