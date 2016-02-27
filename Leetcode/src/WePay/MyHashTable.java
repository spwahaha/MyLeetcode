package WePay;

public class MyHashTable {
	class Entry<K,V>{
		K key;
		V value;
		Entry<K,V> next;
		public Entry(K key, V val){
			this.key = key;
			this.value = val;
			this.next = null;
		}
	}
	
	Entry[] list;
	int capacity;
	public MyHashTable(int capacity){
		this.capacity = capacity;
		list = new Entry[this.capacity];
	}
	
	public <V, K> void put(K key, V value){
		Entry entry = new Entry(key, value);
		int hash = entry.key.hashCode()%this.capacity;
		if(list[hash] == null){
			list[hash] = entry;
		}else{
			Entry node = list[hash];
			while(node.next != null){
				if(node.key.equals(entry.key)){
					node.value = entry.value;
					break;
				}else{
					node = node.next;
				}
			}
			if(!node.key.equals(entry.key)){
				node.next = entry;
			}
		}
	}
	
	public <K, V> V get(K key){
		int hash = key.hashCode() % this.capacity;
		if(list[hash] == null){
			return null;
		}else{
			Entry<K,V> node = list[hash];
			while(node != null){
				if(node.key.equals(key)){
					return node.value;
				}else{
					node = node.next;
				}
			}
			return null;
		}
	}
	
	public static void main(String[] args){
		MyHashTable table = new MyHashTable(12);
		int[] keys = {1,2,3,4,5,6,7};
		int[] vals = {7,6,5,4,3,2,1};
		for(int i = 0; i < keys.length; i++){
			table.put(keys[i], vals[i]);
		}
		for(int i = 0; i < keys.length; i++){
			Integer val = table.get(keys[i]);
			System.out.println(val);
		}
	}
}
