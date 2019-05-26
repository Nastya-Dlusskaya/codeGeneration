package by.bntu.fitr.service.service;

import by.bntu.fitr.repository.entity.Field;
import by.bntu.fitr.repository.repository.FieldSqlRepository;
import by.bntu.fitr.repository.specification.SqlSpecificationForTwoEntities;
import by.bntu.fitr.repository.specification.fieldspecification.AllFieldByDatabaseAndTable;
import by.bntu.fitr.service.converter.FieldConverter;
import by.bntu.fitr.service.dto.FieldDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JDBCFieldService implements FieldService {

    @Autowired
    private FieldSqlRepository fieldRepository;

    @Autowired
    private FieldConverter converter;

    @Override
    public List<FieldDTO> getFieldsByDatabaseNameTableName(String database, String table) {
        SqlSpecificationForTwoEntities allTablesByDatabaseSpecification = new AllFieldByDatabaseAndTable();
        List<Field> fields = fieldRepository.getMetaData(allTablesByDatabaseSpecification, database, table);
        return converter.fromFieldListToFieldDTOList(fields);
    }
}
