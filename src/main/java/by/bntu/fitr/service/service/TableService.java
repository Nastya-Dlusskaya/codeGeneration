package by.bntu.fitr.service.service;

import by.bntu.fitr.service.dto.TableDTO;

import java.util.List;

public interface TableService {
    List<TableDTO> getTablesByDatabase(String name);

    boolean generateCode(String databaseName, String table);
}
