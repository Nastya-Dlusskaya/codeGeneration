package by.bntu.fitr.repository.specification.tablespecification;

import by.bntu.fitr.repository.specification.SqlSpecification;
import by.bntu.fitr.repository.specification.SqlSpecificationResult;

public class AllTablesByDatabaseSpecification implements SqlSpecification<String> {

    private static final String QUERY = "SELECT * FROM information_schema.tables where TABLE_SCHEMA = ?";

    @Override
    public SqlSpecificationResult toSqlQuery(String item) {
        Object[] parameters = new Object[]{item};
        return new SqlSpecificationResult(parameters, QUERY);
    }
}
