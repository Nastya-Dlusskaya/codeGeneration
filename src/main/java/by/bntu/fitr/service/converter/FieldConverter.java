package by.bntu.fitr.service.converter;

import by.bntu.fitr.repository.entity.Field;
import by.bntu.fitr.service.dto.FieldDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class FieldConverter {

    @Autowired
    private TypeConverter typeConverter;

    @Autowired
    private FieldNameConverter nameConverter;

    public List<FieldDTO> fromFieldListToFieldDTOList(List<Field> fields){
        List<FieldDTO> fieldDTOS = new LinkedList<>();
        fields.forEach(
                field -> fieldDTOS.add(convertToFieldDTO(field))
        );
        return fieldDTOS;
    }

    public List<Field> fromFieldDTOListToFieldList(List<FieldDTO> fieldDTOS){
        List<Field> fields = new LinkedList<>();
        fieldDTOS.forEach(
                fieldDTO -> fields.add(convertToField(fieldDTO))
        );
        return fields;
    }

    public FieldDTO fromFieldToFieldDTO(Field field){
        return convertToFieldDTO(field);
    }

    public Field fromFieldDTOToField(FieldDTO fieldDTO){
        return convertToField(fieldDTO);
    }

    private FieldDTO convertToFieldDTO(Field field){
        ModelMapper modelMapper = new ModelMapper();
        field.setType(typeConverter.convertToJavaType(field.getType()));
        field.setName(nameConverter.convertToJavaName(field.getName().toLowerCase()));
        return modelMapper.map(field, FieldDTO.class);
    }

    private Field convertToField(FieldDTO field){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(field, Field.class);
    }
}
