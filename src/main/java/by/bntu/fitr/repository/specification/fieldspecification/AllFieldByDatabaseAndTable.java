package by.bntu.fitr.repository.specification.fieldspecification;

import by.bntu.fitr.repository.specification.SqlSpecificationForTwoEntities;
import by.bntu.fitr.repository.specification.SqlSpecificationResult;

public class AllFieldByDatabaseAndTable implements SqlSpecificationForTwoEntities<String> {

    private static final String QUERY = "SELECT * FROM information_schema.columns where TABLE_SCHEMA = ? AND TABLE_NAME = ?";

    @Override
    public SqlSpecificationResult toSqlQuery(String database, String table) {
        Object[] parameters = new Object[] {database, table};
        return new SqlSpecificationResult(parameters, QUERY);
    }
}
