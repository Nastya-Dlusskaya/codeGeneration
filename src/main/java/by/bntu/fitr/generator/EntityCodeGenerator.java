package by.bntu.fitr.generator;

import by.bntu.fitr.service.dto.FieldDTO;
import by.bntu.fitr.service.dto.TableDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityCodeGenerator implements CodeGenerator {

    private static String PACKAGE = "package %s;\n";
    private static String SIGNATURE = "public class %s {\n";
    private static String FIELDS = "private %s %s;\n";
    private static String CONSTRUCTOR = "private %s(){};\n";
    private static String GETTER = "public %s get%s() {return %s;}\n";
    private static String SETTER = "public void set%s(%s %s) {this.%s = %s;}\n";
    private static String EQUALS_HEAD = "@Override\n public boolean equals(Object object) {\n" +
            "if (this == object) return true;\n" +
            "if (object == null || getClass() != object.getClass()) return false;\n" +
            "%s %s = (%s) object;\n";
    private static String EQUALS_FIELDS = "Objects.equals(%s, %s.%s)";
    private static String HASH_CODE_HEAD = "@Override\n public int hashCode(){\n return Objects.hash(%s);\n}\n";
    private static String TO_STRING_HEAD = "@Override\n public String toString(){ return %s}\n";
    private static String TO_STRING = "\"%s='\" + %s + \"\' \"";
    private static String CLASS_END = "}";

    @Override
    public String generateCode(TableDTO tableDTO, String location) {
        StringBuilder builder = new StringBuilder();
        if(!location.isEmpty()){
            builder.append(generatePackage(location))
                    .append("\n");
        }

        if(tableDTO != null) {
            builder.append(generateSignature(tableDTO))
                    .append("\n")
                    .append(generateConstructor(tableDTO))
                    .append("\n")
                    .append(generateFields(tableDTO))
                    .append("\n")
                    .append(generateGetterSetter(tableDTO))
                    .append("\n")
                    .append(generateEquals(tableDTO))
                    .append("\n")
                    .append(generateHashCode(tableDTO))
                    .append("\n")
                    .append(generateToString(tableDTO))
                    .append("\n")
                    .append(CLASS_END);
        }
        return builder.toString();
    }

    private String generatePackage(String location){
        return String.format(PACKAGE, location);
    }

    private String generateSignature(TableDTO tableDTO) {
        return String.format(SIGNATURE, tableDTO.getClassName());
    }

    private String generateConstructor(TableDTO tableDTO) {
        return String.format(CONSTRUCTOR, tableDTO.getClassName());
    }

    private String generateFields(TableDTO tableDTO) {
        StringBuilder builder = new StringBuilder( );

        tableDTO.getFields( ).forEach(
                field -> builder.append(String.format
                        (FIELDS, field.getType( ), field.getName( ))));

        return builder.toString();
    }

    private String generateGetterSetter(TableDTO tableDTO) {
        StringBuilder builder = new StringBuilder();

        tableDTO.getFields().forEach(field -> createMethods(builder, field));
        return builder.toString();
    }

    private void createMethods(StringBuilder builder, FieldDTO field) {
        builder.append(String.format(GETTER, field.getType( ), field.getClassName(), field.getName()))
                .append("\n")
                .append(String.format(SETTER, field.getClassName(), field.getType(), field.getName(), field.getName(), field.getName()));
    }

    private String generateEquals(TableDTO tableDTO) {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format(EQUALS_HEAD, tableDTO.getName(), tableDTO.getName(), tableDTO.getName()))
                .append("return ")
                .append(getEqualsFields(tableDTO))
                .append(";")
                .append(CLASS_END)
                .append("\n");

        return builder.toString();
    }

    private String getEqualsFields(TableDTO table) {
        StringBuilder builder = new StringBuilder();
        List<String> equalsList = new LinkedList<>();

        table.getFields().forEach(fieldDTO -> equalsList.add(String.format(EQUALS_FIELDS, fieldDTO.getClassName(), table.getName(), fieldDTO.getClassName())));

        return builder.append(String.join("&&\n", equalsList))
                .toString();
    }

    private String generateHashCode(TableDTO tableDTO) {
        String fields = tableDTO.getFields().stream()
                .map(FieldDTO::getName)
                .collect(Collectors.joining(", "));
        return String.format(HASH_CODE_HEAD, fields);
    }

    private String generateToString(TableDTO tableDTO) {
        return String.format(TO_STRING_HEAD, getToStringFields(tableDTO));
    }

    private String getToStringFields(TableDTO table) {
        StringBuilder builder = new StringBuilder();
        List<String> equalsList = new LinkedList<>();

        table.getFields().forEach(fieldDTO -> equalsList.add(String.format(TO_STRING, fieldDTO.getName(), fieldDTO.getName())));

        return builder.append("\"" + table.getClassName() + "{\"+\n")
                .append(String.join("+\n", equalsList))
                .append("\n+\"}\"")
                .toString();
    }
}
