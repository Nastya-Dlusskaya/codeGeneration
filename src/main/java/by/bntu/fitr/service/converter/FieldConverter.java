package by.bntu.fitr.service.converter;

import by.bntu.fitr.repository.entity.Field;
import by.bntu.fitr.service.dto.FieldDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class FieldConverter {

    public List<FieldDTO> fromFieldListToFieldDTOList(List<Field> fields){
        ModelMapper modelMapper = new ModelMapper();
        List<FieldDTO> fieldDTOS = new LinkedList<>();
        fields.forEach(
                field -> fieldDTOS.add(modelMapper.map(field, FieldDTO.class))
        );
        return fieldDTOS;
    }

    public List<Field> fromFieldDTOListToFieldList(List<FieldDTO> fieldDTOS){
        ModelMapper modelMapper = new ModelMapper();
        List<Field> fields = new LinkedList<>();
        fieldDTOS.forEach(
                fieldDTO -> fields.add(modelMapper.map(fieldDTO, Field.class))
        );
        return fields;
    }

    public FieldDTO fromFieldToFieldDTO(Field field){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(field, FieldDTO.class);
    }

    public Field fromFieldDTOToField(FieldDTO fieldDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(fieldDTO, Field.class);
    }
}
