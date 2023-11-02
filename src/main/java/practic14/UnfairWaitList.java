package practic14;

public class UnfairWaitList<E> extends WaitList<E> {

    public void moveToBack(E element) {
        content.remove(element);
        content.add(element);
    }
}
