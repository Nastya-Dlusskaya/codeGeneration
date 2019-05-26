package by.bntu.fitr.writer;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class GenerateClassWriter implements Writer {
    public void  createFile (GenerationFile file){
        Path path = Paths.get(file.getFilePath() + "\\" + file.getFileName() + ".java");
        try {
            Files.write(path, file.getFileBody().getBytes());
        } catch (IOException e) {
            e.printStackTrace( );
        }
    }
}
