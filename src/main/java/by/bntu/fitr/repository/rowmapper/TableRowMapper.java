package by.bntu.fitr.repository.rowmapper;

import by.bntu.fitr.repository.entity.Table;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TableRowMapper implements RowMapper<Table> {
    @Nullable
    @Override
    public Table mapRow(ResultSet resultSet, int i) throws SQLException {
        Table table = new Table();
        table.setName(resultSet.getString("TABLE_NAME"));
        return table;
    }
}
