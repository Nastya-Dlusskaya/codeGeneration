package by.bntu.fitr.repository.specification;

public interface SqlSpecificationForTwoEntities<T> extends Specification {
    SqlSpecificationResult toSqlQuery(T item, T addition);
}
