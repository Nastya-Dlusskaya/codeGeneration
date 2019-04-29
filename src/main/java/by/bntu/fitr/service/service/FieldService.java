package by.bntu.fitr.service.service;

import by.bntu.fitr.service.dto.FieldDTO;

import java.util.List;

public interface FieldService {

    List<FieldDTO> getFieldsByDatabaseNameTableName(String database, String table);
}
