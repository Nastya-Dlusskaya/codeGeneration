package by.bntu.fitr.repository.repository;

import by.bntu.fitr.repository.specification.SqlSpecification;

import java.util.List;

public interface SqlRepository<T> {

    List<T> getMetaData(SqlSpecification<T> specification, T item);
}
