package by.bntu.fitr.service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SettingFile {

    private String packageName;

    @NotBlank
    @Pattern(regexp = "(\\\\\\\\?([^\\\\/]*[\\\\/])*)([^\\\\/]+)$")
    private String location;
    private String databaseName;
    private String tableName;

    public SettingFile() {
    }

    public SettingFile(String databaseName, String tableName) {
        this.databaseName = databaseName;
        this.tableName = tableName;
    }

    public SettingFile(String packageName, String location, String databaseName, String tableName) {
        this.packageName = packageName;
        this.location = location;
        this.databaseName = databaseName;
        this.tableName = tableName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
