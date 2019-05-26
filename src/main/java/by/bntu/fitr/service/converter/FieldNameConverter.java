package by.bntu.fitr.service.converter;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class FieldNameConverter {

    public String convertToJavaName(String mysqlName){
        while(mysqlName.contains("_")){
            int index = mysqlName.indexOf("_");
            mysqlName = mysqlName.substring(0, index) + StringUtils.capitalize(mysqlName.substring(index+1));
        }
        return mysqlName;
    }
}
