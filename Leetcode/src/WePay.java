
public class WePay {
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
	
	Entry[] list = new Entry[11];
	
}
