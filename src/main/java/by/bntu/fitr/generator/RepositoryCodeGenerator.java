package by.bntu.fitr.generator;

import by.bntu.fitr.service.dto.TableDTO;
import org.springframework.stereotype.Component;

@Component
public class RepositoryCodeGenerator implements CodeGenerator{

    @Override
    public boolean generateCode(TableDTO tableDTO) {
        return false;
    }
}
