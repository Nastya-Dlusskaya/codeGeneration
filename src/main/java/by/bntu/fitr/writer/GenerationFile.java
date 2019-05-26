package by.bntu.fitr.writer;

public class GenerationFile {
    private String fileName;
    private String filePath;
    private String fileBody;

    public GenerationFile() {
    }

    public GenerationFile(String fileName, String filePath, String fileBody) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileBody = fileBody;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileBody() {
        return fileBody;
    }

    public void setFileBody(String fileBody) {
        this.fileBody = fileBody;
    }
}
