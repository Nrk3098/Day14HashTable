package Hash;
import java.util.LinkedList;



public class MyMapNode<K, V> {
    private K key;
    private V value;

    public MyMapNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}



