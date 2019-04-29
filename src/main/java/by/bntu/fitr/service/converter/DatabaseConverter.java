package by.bntu.fitr.service.converter;

import by.bntu.fitr.repository.entity.Database;
import by.bntu.fitr.service.dto.DatabaseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class DatabaseConverter {

    public List<DatabaseDTO> fromDatabaseListToDatabaseDTOList(List<Database> databases){
        ModelMapper modelMapper = new ModelMapper();
        List<DatabaseDTO> databaseDTOS = new LinkedList<>();
        databases.forEach(
                database -> databaseDTOS.add(modelMapper.map(database, DatabaseDTO.class))
        );
        return databaseDTOS;
    }

    public List<Database> fromDatabaseDTOListToDatabaseList(List<DatabaseDTO> databaseDTOS){
        ModelMapper modelMapper = new ModelMapper();
        List<Database> databases = new LinkedList<>();
        databaseDTOS.forEach(
                databaseDTO -> databases.add(modelMapper.map(databaseDTO, Database.class))
        );
        return databases;
    }

    public DatabaseDTO fromDatabaseToDatabaseDTO(Database database){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(database, DatabaseDTO.class);
    }

    public Database fromDatabaseDTOToDatabase(DatabaseDTO databaseDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(databaseDTO, Database.class);
    }
}
