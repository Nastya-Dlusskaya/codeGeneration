package by.bntu.fitr.service.service;

import by.bntu.fitr.repository.entity.Database;
import by.bntu.fitr.repository.repository.DatabaseSqlRepository;
import by.bntu.fitr.repository.repository.TableSqlRepository;
import by.bntu.fitr.repository.specification.SqlSpecification;
import by.bntu.fitr.repository.specification.databasespecification.AllDatabasesSpecification;
import by.bntu.fitr.service.converter.DatabaseConverter;
import by.bntu.fitr.service.dto.DatabaseDTO;
import by.bntu.fitr.service.dto.TableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JDBCDatabaseService implements DatabaseService {

    @Autowired
    private DatabaseSqlRepository databaseRepository;

    @Autowired
    private TableService tableService;

    @Autowired
    private DatabaseConverter converter;

    public List<DatabaseDTO> getDatabases(){
        SqlSpecification allDatabasesSpecification = new AllDatabasesSpecification();
        List<Database> databases = databaseRepository.getMetaData(allDatabasesSpecification, new Database());
        List<DatabaseDTO> databaseDTOList = converter.fromDatabaseListToDatabaseDTOList(databases);
        for (DatabaseDTO databaseDTO : databaseDTOList) {
            List<TableDTO> tableDTOList = tableService.getTablesByDatabase(databaseDTO.getName());
            databaseDTO.setTables(tableDTOList);
        }
        return databaseDTOList;
    }
}
;