package Hash;

import java.util.LinkedList;

public class MyHashMap<K, V> {
    private final int i;
    private LinkedList<MyMapNode<K, V>>[] bucketArray;
    private int numBuckets;

    public MyHashMap(int i) throws IllegalArgumentException {
        this.i = i;
        throw new IllegalArgumentException("Number of buckets must be greater than zero");

    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % numBuckets;
    }

    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<MyMapNode<K, V>> bucket = bucketArray[bucketIndex];

        for (MyMapNode<K, V> node : bucket) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
        }

        bucket.add(new MyMapNode<>(key, value));
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<MyMapNode<K, V>> bucket = bucketArray[bucketIndex];

        for (MyMapNode<K, V> node : bucket) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }

        return null;
    }

    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<MyMapNode<K, V>> bucket = bucketArray[bucketIndex];

        for (MyMapNode<K, V> node : bucket) {
            if (node.getKey().equals(key)) {
                bucket.remove(node);
                return;
            }
        }
    }
}

