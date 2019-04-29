package by.bntu.fitr.repository.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Table {

    private String name;
    private List<Field> fields;

    public Table() {
    }

    public Table(String name, List<Field> fields) {
        this.name = name;
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Table table = (Table) o;
        return Objects.equals(name, table.name) &&
                Objects.equals(fields, table.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fields);
    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                ", fields=" + fields +
                '}';
    }
}
