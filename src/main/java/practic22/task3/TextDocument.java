package practic22.task3;

import java.io.*;

public class TextDocument implements Document {

    private String path;

    private String text;

    public TextDocument(String path, String content) {
        this.path = path;
        this.text = content;
    }

    public String content() {
        return text;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void setContent(String content) {
        this.text = content;
    }

    public String getPath() {
        return path;
    }
}
