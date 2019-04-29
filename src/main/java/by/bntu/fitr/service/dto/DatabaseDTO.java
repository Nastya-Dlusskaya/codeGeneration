package by.bntu.fitr.service.dto;

import java.util.List;
import java.util.Objects;

public class DatabaseDTO {

    private String name;
    private List<TableDTO> tables;

    public DatabaseDTO() {
    }

    public DatabaseDTO(String name, List<TableDTO> tables) {
        this.name = name;
        this.tables = tables;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TableDTO> getTables() {
        return tables;
    }

    public void setTables(List<TableDTO> tables) {
        this.tables = tables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        DatabaseDTO that = (DatabaseDTO) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(tables, that.tables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tables);
    }

    @Override
    public String toString() {
        return "DatabaseDTO{" +
                "name='" + name + '\'' +
                ", tables=" + tables +
                '}';
    }
}
