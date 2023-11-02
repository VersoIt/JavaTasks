package practic1.task3;

public class Book {

    private int amountOfPages;

    private String name;

    public Book(int amountOfPages, String name) {
        this.amountOfPages = amountOfPages;
        this.name = name;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "amountOfPages=" + amountOfPages +
                ", name='" + name + '\'' +
                '}';
    }

    public void setAmountOfPages(int amountOfPages) {
        this.amountOfPages = amountOfPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
