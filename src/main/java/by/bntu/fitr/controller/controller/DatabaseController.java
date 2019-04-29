package by.bntu.fitr.controller.controller;

import by.bntu.fitr.service.dto.DatabaseDTO;
import by.bntu.fitr.service.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class DatabaseController {

    @Autowired
    private DatabaseService service;

    @GetMapping("/databases")
    public ResponseEntity<List<DatabaseDTO>> getAllDatabases(){
        List<DatabaseDTO> databaseDTOList = service.getDatabases();
        return new ResponseEntity<>(databaseDTOList, HttpStatus.OK);
    }
}
