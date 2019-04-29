package by.bntu.fitr.repository.entity;

import java.util.List;
import java.util.Objects;

public class Database {
    private String name;

    public Database() {
    }

    public Database(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Database database = (Database) o;
        return Objects.equals(name, database.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Database{" +
                "name='" + name + "'}";
    }
}
