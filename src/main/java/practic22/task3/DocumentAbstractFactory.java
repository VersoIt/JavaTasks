package practic22.task3;

public interface DocumentAbstractFactory {

    DocumentReader createReader();

    DocumentWriter createWriter();

    Document createNewDocument();

    Showman createShowman();
}
