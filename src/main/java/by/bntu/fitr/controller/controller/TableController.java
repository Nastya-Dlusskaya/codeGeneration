package by.bntu.fitr.controller.controller;

import by.bntu.fitr.service.dto.SettingFile;
import by.bntu.fitr.service.dto.TableDTO;
import by.bntu.fitr.service.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class TableController {

    @Autowired
    private TableService service;

    @GetMapping("/tables")
    public String getAllDatabases(
            @RequestParam(value = "database", required = false) String databaseName,
            Model model
    ){
        List<TableDTO> tablesByDatabase = service.getTablesByDatabase(databaseName);
        model.addAttribute("database", databaseName);
        model.addAttribute("list", tablesByDatabase);
        return "tables";
    }

    @PostMapping("/generations")
    public String generateCode(
            @Valid @ModelAttribute("settingFile") SettingFile settingFile,
            BindingResult result,
            ModelMap model
    ){
        Map<String, String> isGenerated = service.generateCode(settingFile);
        model.addAttribute("entity", isGenerated.get("entity"));
        model.addAttribute("repository", isGenerated.get("repository"));
        return "generation";
    }

    @GetMapping("/settings")
    public String getSettings(@RequestParam(value = "database", required = false) String databaseName,
                              @RequestParam(value = "table", required = false) String table,
                              Model model){
        SettingFile file = new SettingFile(databaseName, table);
        model.addAttribute(file);
        return "settings";
    }
}
