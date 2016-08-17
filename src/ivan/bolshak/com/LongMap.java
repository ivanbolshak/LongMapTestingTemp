package ivan.bolshak.com;

/**
 * Created by Ivan on 17.08.2016.
 */
public interface LongMap<V> {
    V put(long key, V value);
    V get(long key);
    V remove(long key);

    boolean isEmpty();
    boolean containsKey(long key);
    boolean containsValue(V value);

    long[] keys();
    V[] values();

    long size();
    void clear();


}
