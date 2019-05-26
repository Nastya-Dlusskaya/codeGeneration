package by.bntu.fitr.service.converter;

import org.springframework.stereotype.Component;

@Component
public class TypeConverter {

    public String convertToJavaType(String mysqlType){
        mysqlType = mysqlType.toLowerCase();
        switch (mysqlType){
            case "tinyint": return "Byte";
            case "smallint": return "Short";
            case "mediumint": return "Integer";
            case "int": return "Integer";
            case "integer": return "Integer";
            case "bigint": return "Long";
            case "float": return "Float";
            case "double": return "Double";
            case "double precision": return "Double";
            case "real": return "Double";
            case "decimal": return "Double";
            case "numeric": return "Double";
            case "datetime": return "Timestamp";
            case "timestamp": return "Timestamp";
            case "char": return "String";
            case "nvarchar": return "String";
            case "varchar": return "String";
            case "text": return "String";
            default: return "?";
        }
    }
}
