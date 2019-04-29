package by.bntu.fitr.repository.rowmapper;

import by.bntu.fitr.repository.entity.Database;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseRowMapper implements RowMapper<Database> {

    @Override
    public Database mapRow(ResultSet resultSet, int i) throws SQLException {
        Database database = new Database();
        database.setName(resultSet.getString("SCHEMA_NAME"));
        return database;
    }
}
