package practic22.task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextDocumentWriter implements DocumentWriter {

    public void write(Document document) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(document.getPath()))) {
            writer.write(document.content());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
