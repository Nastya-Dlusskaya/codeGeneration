package by.bntu.fitr.service.service;

import by.bntu.fitr.service.dto.SettingFile;
import by.bntu.fitr.service.dto.TableDTO;

import java.util.List;
import java.util.Map;

public interface TableService {
    List<TableDTO> getTablesByDatabase(String name);

    Map<String, String> generateCode(SettingFile settingFile);
}
