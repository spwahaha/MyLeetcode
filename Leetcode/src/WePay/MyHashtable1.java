package WePay;
import java.io.*;
import java.util.*;

public class MyHashtable1<K, V> {    
    public static void main(String args[]) throws Exception {
        new TestHarness(new MyHashtable1<String, String>()).run();
    }
    
    class Entry<K, V>{
        K key;
        V val;
        Entry<K,V> next;
        
        public Entry(K key, V val){
            this.key = key;
            this.val = val;
        }
    }
    
    Entry<K, V>[] list;
    int capacity;
    public MyHashtable1(){
        this.capacity = 23;
        this.list = new  Entry[this.capacity];
    }
   
    public void put(K key, V value) {
        // TODO implement
        if(key == null){
            return;
        }
        Entry<K, V> inserted = new Entry(key, value);
        int hash = Math.abs(key.hashCode()) % this.capacity;
        if(list[hash] == null){
            list[hash] = inserted;
        }else{
            Entry node = list[hash];
            while(node.next != null){
                if(node.key.equals(key)){
                    node.val = value;
                    return;
                }else{
                    node = node.next;
                }
            }
            
            if(node.key.equals(key)){
              node.val = value;  
            }else{
                node.next = inserted;
            }
        }
    }

    public V get(K key) {
        // TODO implement
        if(key == null){
            return null;
        }
        int hash = Math.abs(key.hashCode()) % this.capacity;
        if(list[hash] == null){
            return null;
        }else{
            Entry node = list[hash];
            while(node != null){
                if(node.key.equals(key)){
                    return (V)node.val;
                }else{
                    node = node.next;
                }
            }
        }
        return null;
    }

    /**
     * A helper class that tests MyHashtable by feeding it puts and gets from STDIN.
     */
    public static class TestHarness implements Runnable {
        final MyHashtable1<String, String> hashtable;

        public TestHarness(MyHashtable1<String, String> hashtable) {
            this.hashtable = hashtable;
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String k = scanner.next();
                String v = null;
                if (k.contains("=")) {
                    String[] split = k.split("\\=");
                    k = split[0];
                    v = split[1];
                }
                if (v == null) {
                    System.out.println(hashtable.get(k));
                } else {
                    hashtable.put(k, v);
                }
            }
        }
    }
}