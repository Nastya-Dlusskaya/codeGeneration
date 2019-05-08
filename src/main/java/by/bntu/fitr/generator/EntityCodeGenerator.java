package by.bntu.fitr.generator;

import by.bntu.fitr.service.dto.FieldDTO;
import by.bntu.fitr.service.dto.TableDTO;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

@Component
public class EntityCodeGenerator implements CodeGenerator {

    private static String SIGNATURE = "public class %s {\n";
    private static String FIELDS = "private %s %s;\n";
    private static String GETTER = "public %s get%s() {return %s;}\n";
    private static String SETTER = "public void set%s(%s %s) {this.%s = %s;}\n";
    public static String EQUALS = "";
    public static String HASH_CODE = "";
    public static String TO_STRING = "";
    private static String CLASS_END = "}";

    @Override
    public boolean generateCode(TableDTO tableDTO) {
        String stringClass = generateFile(tableDTO);
        Path path = Paths.get( "C:\\Users\\User\\Downloads\\" + tableDTO.getName() + ".txt");
        try {
            Files.write( path, stringClass.getBytes());
        } catch (IOException e) {
            e.printStackTrace( );
        }
        return false;
    }

    private String generateFile(TableDTO tableDTO) {

        return generateSignature(tableDTO) + "\n" +
                generateFields(tableDTO) + "\n" +
                generateGetterSetter(tableDTO) + "\n" +
                generateEquals(tableDTO) + "\n" +
                generateHashCode(tableDTO) + "\n" +
                generateToString(tableDTO) + "\n" +
                CLASS_END;
    }

    private String generateSignature(TableDTO tableDTO) {
        return String.format(SIGNATURE, tableDTO.getName( ).toLowerCase( ));
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
        builder.append(String.format(GETTER, field.getType( ), field.getName(), field.getName()))
                .append("\n")
                .append(String.format(SETTER, field.getName(), field.getType(), field.getName(), field.getName(), field.getName()))
                .append("\n");
    }

    private String generateEquals(TableDTO tableDTO) {
        return "";
    }

    private String generateHashCode(TableDTO tableDTO) {
        return "";
    }

    private String generateToString(TableDTO tableDTO) {
        return "";
    }
}
