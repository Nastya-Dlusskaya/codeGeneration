package by.bntu.fitr.repository.entity;

import java.util.Objects;

public class Field {

    private String name;
    private String type;

    public Field() {
    }

    public Field(String name, String type) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Field field = (Field) o;
        return Objects.equals(name, field.name) &&
                Objects.equals(type, field.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return "Field{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
