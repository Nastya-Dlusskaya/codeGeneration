package by.bntu.fitr.repository.rowmapper;

import by.bntu.fitr.repository.entity.Field;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FieldRowMapper implements RowMapper<Field> {

    @Override
    public Field mapRow(ResultSet resultSet, int i) throws SQLException {
        Field field = new Field();
        field.setName(resultSet.getString("COLUMN_NAME"));
        field.setType(resultSet.getString("DATA_TYPE"));
        return field;
    }
}
