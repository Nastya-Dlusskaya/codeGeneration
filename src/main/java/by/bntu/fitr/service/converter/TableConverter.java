package by.bntu.fitr.service.converter;

import by.bntu.fitr.repository.entity.Table;
import by.bntu.fitr.service.dto.TableDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.LinkedList;
import java.util.List;

@Component
public class TableConverter {

    public List<TableDTO> fromTableListToTableDTOList(List<Table> tables){
        List<TableDTO> tablesDTO = new LinkedList<>();
        tables.forEach(
                table -> tablesDTO.add(fromTableToTableDTO(table))
        );
        return tablesDTO;
    }

    public List<Table> fromTableDTOListToTableList(List<TableDTO> tablesDTO){
        List<Table> tables = new LinkedList<>();
        tablesDTO.forEach(
                tableDTO -> tables.add(fromTableDTOToTable(tableDTO))
        );
        return tables;
    }

    public TableDTO fromTableToTableDTO(Table table){
        ModelMapper modelMapper = new ModelMapper();
        table.setName(StringUtils.capitalize(table.getName()));
        return modelMapper.map(table, TableDTO.class);
    }

    public Table fromTableDTOToTable(TableDTO tableDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tableDTO, Table.class);
    }
}
