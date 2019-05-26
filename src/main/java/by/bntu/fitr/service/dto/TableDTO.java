package by.bntu.fitr.service.dto;

import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

public class TableDTO {

    private String name;
    private List<FieldDTO> fields;

    public TableDTO() {
    }

    public TableDTO(String name, List<FieldDTO> fields) {
        this.name = name;
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FieldDTO> getFields() {
        return fields;
    }

    public void setFields(List<FieldDTO> fields) {
        this.fields = fields;
    }

    public String getClassName() {
        return StringUtils.capitalize(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        TableDTO tableDTO = (TableDTO) o;
        return Objects.equals(name, tableDTO.name) &&
                Objects.equals(fields, tableDTO.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fields);
    }

    @Override
    public String toString() {
        return "TableDTO{" +
                "name='" + name + '\'' +
                ", fields=" + fields +
                '}';
    }
}
