package by.bntu.fitr.controller.controller;

import by.bntu.fitr.service.dto.FieldDTO;
import by.bntu.fitr.service.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class FieldController {

    @Autowired
    private FieldService service;

    @GetMapping("/fields")
    public ResponseEntity<List<FieldDTO>> getAllFields(
            @RequestParam(value = "database", required = false) String databaseName,
            @RequestParam(value = "table", required = false) String table
    ){
        List<FieldDTO> fieldDTOS = service.getFieldsByDatabaseNameTableName(databaseName, table);
        return new ResponseEntity<>(fieldDTOS, HttpStatus.OK);
    }
}
