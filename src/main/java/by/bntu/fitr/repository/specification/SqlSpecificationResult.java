package by.bntu.fitr.repository.specification;

public class SqlSpecificationResult {
    private Object[] parameters;
    private String sql;

    public SqlSpecificationResult(Object[] parameters, String sql) {
        this.parameters = parameters;
        this.sql = sql;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public String getSql() {
        return sql;
    }
}
