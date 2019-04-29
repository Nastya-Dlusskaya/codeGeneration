package by.bntu.fitr.repository.specification;

public interface SqlSpecification<T> extends Specification{
    SqlSpecificationResult toSqlQuery(T item);
}
