package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStatementStrategy implements StatementStrategy {
    private Long id1;
    public DeleteStatementStrategy(Long id) {
        this.id1 = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id=?");
        preparedStatement.setLong(1, id1);
        return preparedStatement;
    }
}
