package by.bntu.fitr.generator;

import by.bntu.fitr.service.dto.TableDTO;
import org.springframework.stereotype.Component;

@Component
public class RepositoryCodeGenerator implements CodeGenerator{

    private static final String PACKAGE_PATTERN = "package %s;\n\n";
    private static final String JPA_REPOSITORY_PATTERN = "public interface %sRepository extends JpaRepository<%s, Long> {}";

    @Override
    public String generateCode(TableDTO tableDTO, String packageName) {
        return  String.format(PACKAGE_PATTERN, packageName) +
                String.format(JPA_REPOSITORY_PATTERN, tableDTO.getClassName(), tableDTO.getClassName());
    }
}
