package by.bntu.fitr.repository.specification.tablespecification;

import by.bntu.fitr.repository.specification.SqlSpecificationForTwoEntities;
import by.bntu.fitr.repository.specification.SqlSpecificationResult;

public class TableByDatabaseNameAndTableNameSpecification implements SqlSpecificationForTwoEntities<String> {

    private static final String QUERY = "SELECT * FROM information_schema.tables WHERE TABLE_SCHEMA = ? AND TABLE_NAME=?";

    @Override
    public SqlSpecificationResult toSqlQuery(String item, String addition) {
        Object[] parameters = new Object[]{item, addition};
        return new SqlSpecificationResult(parameters, QUERY);
    }
}
