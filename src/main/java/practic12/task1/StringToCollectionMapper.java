package practic12.task1;

import java.util.Collection;

public interface StringToCollectionMapper <E, T extends Collection<E>> {

    T convert(String target);
}
