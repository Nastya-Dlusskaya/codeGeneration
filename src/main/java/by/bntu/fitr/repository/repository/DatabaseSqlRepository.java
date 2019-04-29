package by.bntu.fitr.repository.repository;

import by.bntu.fitr.repository.entity.Database;
import by.bntu.fitr.repository.rowmapper.DatabaseRowMapper;
import by.bntu.fitr.repository.specification.SqlSpecification;
import by.bntu.fitr.repository.specification.SqlSpecificationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class DatabaseSqlRepository implements SqlRepository<Database> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Database> getMetaData(SqlSpecification specification, Database item) {
        SqlSpecificationResult sqlSpecificationResult = specification.toSqlQuery(item);
        return jdbcTemplate.query(
                sqlSpecificationResult.getSql(),
                sqlSpecificationResult.getParameters(),
                new DatabaseRowMapper());
    }
}
