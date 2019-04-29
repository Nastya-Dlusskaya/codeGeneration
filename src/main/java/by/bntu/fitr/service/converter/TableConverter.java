package by.bntu.fitr.service.converter;

import by.bntu.fitr.repository.entity.Table;
import by.bntu.fitr.service.dto.TableDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class TableConverter {

    public List<TableDTO> fromTableListToTableDTOList(List<Table> tables){
        ModelMapper modelMapper = new ModelMapper();
        List<TableDTO> tablesDTO = new LinkedList<>();
        tables.forEach(
                table -> tablesDTO.add(modelMapper.map(table, TableDTO.class))
        );
        return tablesDTO;
    }

    public List<Table> fromTableDTOListToTableList(List<TableDTO> tablesDTO){
        ModelMapper modelMapper = new ModelMapper();
        List<Table> tables = new LinkedList<>();
        tablesDTO.forEach(
                tableDTO -> tables.add(modelMapper.map(tableDTO, Table.class))
        );
        return tables;
    }

    public TableDTO fromTableToTableDTO(Table table){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(table, TableDTO.class);
    }

    public Table fromTableDTOToTable(TableDTO tableDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tableDTO, Table.class);
    }
}
