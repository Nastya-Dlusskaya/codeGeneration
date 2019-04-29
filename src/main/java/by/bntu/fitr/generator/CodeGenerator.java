package by.bntu.fitr.generator;

import by.bntu.fitr.service.dto.TableDTO;

public interface CodeGenerator {
    boolean generateCode(TableDTO tableDTO);
}
