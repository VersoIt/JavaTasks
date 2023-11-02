package practic22.task3;

public class TextDocumentFactory implements DocumentAbstractFactory {

    @Override
    public DocumentReader createReader() {
        return new TextDocumentReader();
    }

    @Override
    public DocumentWriter createWriter() {
        return new TextDocumentWriter();
    }

    @Override
    public Document createNewDocument() {
        return new TextDocument("", "");
    }

    @Override
    public Showman createShowman() {
        return new TextShowman();
    }
}
