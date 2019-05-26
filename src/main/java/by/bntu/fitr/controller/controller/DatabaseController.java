package by.bntu.fitr.controller.controller;

import by.bntu.fitr.service.dto.DatabaseDTO;
import by.bntu.fitr.service.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Controller
public class DatabaseController {

    @Autowired
    private DatabaseService service;

    @GetMapping("/databases")
    public String getAllDatabases(Model model){
        List<DatabaseDTO> databaseDTOList = service.getDatabases();
        model.addAttribute("list", databaseDTOList);
        return "databases";
    }
}
