package practic22.task3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextDocumentReader implements DocumentReader {

    @Override
    public Document read(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            StringBuilder result = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                result.append(line).append("\n");
            }

            return new TextDocument(path, result.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
