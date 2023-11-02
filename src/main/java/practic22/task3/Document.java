package practic22.task3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Document {

    String getPath();

    String content();

    void setPath(String path);

    void setContent(String content);
}
