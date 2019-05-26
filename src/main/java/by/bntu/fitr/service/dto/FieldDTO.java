package by.bntu.fitr.service.dto;

import org.springframework.util.StringUtils;

import java.util.Objects;

public class FieldDTO {

    private String name;
    private String type;

    public FieldDTO() {
    }

    public FieldDTO(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClassName() {
        return StringUtils.capitalize(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        FieldDTO fieldDTO = (FieldDTO) o;
        return Objects.equals(name, fieldDTO.name) &&
                Objects.equals(type, fieldDTO.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return "FieldDTO{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
