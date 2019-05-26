package by.bntu.fitr.service.service;

import by.bntu.fitr.generator.EntityCodeGenerator;
import by.bntu.fitr.generator.RepositoryCodeGenerator;
import by.bntu.fitr.repository.repository.TableSqlRepository;
import by.bntu.fitr.repository.specification.SqlSpecification;
import by.bntu.fitr.repository.specification.tablespecification.AllTablesByDatabaseSpecification;
import by.bntu.fitr.service.converter.TableConverter;
import by.bntu.fitr.service.dto.FieldDTO;
import by.bntu.fitr.service.dto.SettingFile;
import by.bntu.fitr.service.dto.TableDTO;
import by.bntu.fitr.writer.Writer;
import by.bntu.fitr.writer.GenerationFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JDBCTableService implements TableService {

    @Autowired
    private TableConverter converter;

    @Autowired
    private TableSqlRepository tableRepository;

    @Autowired
    private FieldService fieldService;

    @Autowired
    private EntityCodeGenerator entityCodeGenerator;

    @Autowired
    private RepositoryCodeGenerator repositoryCodeGenerator;

    @Autowired
    private Writer writer;

    public List<TableDTO> getTablesByDatabase(String databaseName){
        SqlSpecification allTablesByDatabaseSpecification = new AllTablesByDatabaseSpecification();
        List<TableDTO> tables = converter.fromTableListToTableDTOList(tableRepository.getMetaData(allTablesByDatabaseSpecification, databaseName));
        for (TableDTO table : tables) {
            table.setFields(fieldService.getFieldsByDatabaseNameTableName(databaseName, table.getName()));
        }
        return tables;
    }

    @Override
    public Map<String,String> generateCode(SettingFile file) {
        List<FieldDTO> fields = fieldService.getFieldsByDatabaseNameTableName(file.getDatabaseName(), file.getTableName());
        TableDTO tableDTO = new TableDTO(file.getTableName(), fields);
        String entity = entityCodeGenerator.generateCode(tableDTO, file.getPackageName());
        String repository = repositoryCodeGenerator.generateCode(tableDTO, file.getPackageName());
        GenerationFile entityFile = new GenerationFile(file.getTableName(), file.getLocation(), entity);
        GenerationFile repositoryFile = new GenerationFile(file.getTableName() + "Repository", file.getLocation(), repository);
        writer.createFile(entityFile);
        writer.createFile(repositoryFile);
        Map<String, String> codes = new HashMap<>();
        codes.put("entity", entity);
        codes.put("repository", repository);
        return codes;
    }
}
