package by.bntu.fitr.service.service;

import by.bntu.fitr.repository.entity.Field;
import by.bntu.fitr.repository.entity.Table;
import by.bntu.fitr.repository.repository.FieldSqlRepository;
import by.bntu.fitr.repository.repository.TableSqlRepository;
import by.bntu.fitr.repository.specification.SqlSpecification;
import by.bntu.fitr.repository.specification.SqlSpecificationForTwoEntities;
import by.bntu.fitr.repository.specification.fieldspecification.AllFieldByDatabaseAndTable;
import by.bntu.fitr.repository.specification.tablespecification.AllTablesByDatabaseSpecification;
import by.bntu.fitr.repository.specification.tablespecification.TableByDatabaseNameAndTableNameSpecification;
import by.bntu.fitr.service.converter.TableConverter;
import by.bntu.fitr.service.dto.FieldDTO;
import by.bntu.fitr.service.dto.TableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JDBCTableService implements TableService {

    @Autowired
    private TableConverter converter;

    @Autowired
    private TableSqlRepository tableRepository;

    @Autowired
    private FieldService fieldService;

    public List<TableDTO> getTablesByDatabase(String name){
        SqlSpecification allTablesByDatabaseSpecification = new AllTablesByDatabaseSpecification();
        List<Table> tables = tableRepository.getMetaData(allTablesByDatabaseSpecification, name);
        return converter.fromTableListToTableDTOList(tables);
    }

    @Override
    public boolean generateCode(String databaseName, String tableName) {
        List<FieldDTO> fields = fieldService.getFieldsByDatabaseNameTableName(databaseName, tableName);
        TableDTO tableDTO = new TableDTO(tableName, fields);
        return false;
    }
}
