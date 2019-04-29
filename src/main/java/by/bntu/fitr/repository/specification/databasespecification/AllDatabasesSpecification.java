package by.bntu.fitr.repository.specification.databasespecification;

import by.bntu.fitr.repository.entity.Database;
import by.bntu.fitr.repository.specification.SqlSpecification;
import by.bntu.fitr.repository.specification.SqlSpecificationResult;

public class AllDatabasesSpecification implements SqlSpecification<Database> {

    private static final String QUERY = "SELECT * FROM information_schema.schemata;";

    @Override
    public SqlSpecificationResult toSqlQuery(Database item) {
        Object[] parameters = new Object[0];
        return new SqlSpecificationResult(parameters, QUERY);
    }
}
