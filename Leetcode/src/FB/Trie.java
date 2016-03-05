package FB;

public class Trie {
	
	class TrieNode {
	    // Initialize your data structure here.
	    char c;
	    TrieNode[] children;
	    boolean isWord;
	    public TrieNode() {
	        c = '.';
	        children = new TrieNode[26];
	    }
	    
	    public TrieNode(char c){
	        this.c = c;
	        children = new TrieNode[26];
	    }
	}
	
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null || word.length() == 0){
            return;
        }
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode(c);
                node = node.children[c - 'a'];
            }else{
                node = node.children[c - 'a'];
            }
            if(i == word.length() - 1){
                node.isWord = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word == null || word.length() == 0){
            return true;
        }
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                return false;
            }else{
                node = node.children[c - 'a'];
            }
            if(i == word.length() - 1){
                return node.isWord;
            }
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0){
            return false;
        }
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(node.children[c - 'a'] == null){
                return false;
            }else{
                node = node.children[c - 'a'];
            }
        }
        return true;
    }
}
