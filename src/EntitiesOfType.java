import java.util.Iterator;
import java.util.List;

// A custom Iterator implementation (the Iterator design pattern) that lets
// calling code walk through only the entities of one specific type, without
// repeating instanceof checks and casts everywhere they're needed.
//
// This is a genuine, separate iterator, not just Java's built-in for-each:
// implementing Iterable<T> here means an EntitiesOfType<Human> can be used
// directly in a for-each loop and always hands back correctly-typed Human
// objects, no casting required by the caller.
public class EntitiesOfType<T extends Entity> implements Iterable<T> {

    private final List<Entity> source;
    private final Class<T> type;

    public EntitiesOfType(List<Entity> source, Class<T> type) {
        this.source = source;
        this.type = type;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            private T next = advance();

            private T advance() {
                while (index < source.size()) {
                    Entity candidate = source.get(index++);
                    if (type.isInstance(candidate)) {
                        return type.cast(candidate);
                    }
                }
                return null;
            }

            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public T next() {
                T current = next;
                next = advance();
                return current;
            }
        };
    }
}
