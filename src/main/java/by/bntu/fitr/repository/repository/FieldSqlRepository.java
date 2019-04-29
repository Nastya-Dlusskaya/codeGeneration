package by.bntu.fitr.repository.repository;

import by.bntu.fitr.repository.entity.Field;
import by.bntu.fitr.repository.rowmapper.FieldRowMapper;
import by.bntu.fitr.repository.specification.Specification;
import by.bntu.fitr.repository.specification.SqlSpecification;
import by.bntu.fitr.repository.specification.SqlSpecificationForTwoEntities;
import by.bntu.fitr.repository.specification.SqlSpecificationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FieldSqlRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Field> getMetaData(SqlSpecificationForTwoEntities<String> specification, String database, String table) {
        SqlSpecificationResult sqlSpecificationResult = specification.toSqlQuery(database, table);
        return jdbcTemplate.query(
                sqlSpecificationResult.getSql(),
                sqlSpecificationResult.getParameters(),
                new FieldRowMapper());
    }
}
