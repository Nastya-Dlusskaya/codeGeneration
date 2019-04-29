package by.bntu.fitr.repository.repository;

import by.bntu.fitr.repository.entity.Table;
import by.bntu.fitr.repository.rowmapper.TableRowMapper;
import by.bntu.fitr.repository.specification.Specification;
import by.bntu.fitr.repository.specification.SqlSpecification;
import by.bntu.fitr.repository.specification.SqlSpecificationForTwoEntities;
import by.bntu.fitr.repository.specification.SqlSpecificationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TableSqlRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Table getMetaData(SqlSpecificationForTwoEntities specification, String item, String additional) {
        SqlSpecificationResult sqlSpecificationResult = specification.toSqlQuery(item, additional);
        return jdbcTemplate.queryForObject(
                sqlSpecificationResult.getSql(),
                sqlSpecificationResult.getParameters(),
                new TableRowMapper());
    }

    public List<Table> getMetaData(SqlSpecification specification, String item) {
        SqlSpecificationResult sqlSpecificationResult = specification.toSqlQuery(item);
        return jdbcTemplate.query(
                sqlSpecificationResult.getSql(),
                sqlSpecificationResult.getParameters(),
                new TableRowMapper());
    }
}
