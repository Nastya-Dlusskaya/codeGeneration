package by.bntu.fitr.controller.controller;

import by.bntu.fitr.service.dto.TableDTO;
import by.bntu.fitr.service.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TableController {

    @Autowired
    private TableService service;

    @GetMapping("/tables")
    public ResponseEntity<List<TableDTO>> getAllDatabases(
            @RequestParam(value = "databaseName", required = false) String databaseName
    ){
        List<TableDTO> tablesByDatabase = service.getTablesByDatabase(databaseName);
        return new ResponseEntity<>(tablesByDatabase, HttpStatus.OK);
    }

    @GetMapping("/generate")
    public boolean generateCode(
            @RequestParam(value = "database", required = false) String databaseName,
            @RequestParam(value = "table", required = false) String table
    ){
        boolean isGenerated = service.generateCode(databaseName, table);
        return isGenerated;
    }
}
