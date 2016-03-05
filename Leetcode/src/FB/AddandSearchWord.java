package FB;

public class AddandSearchWord {
	class TrieNode{
        public char val;
        public boolean isWord;
        public TrieNode[] children;
        public TrieNode(){
            this.val = ' ';
            this.isWord = false;
            this.children = new TrieNode[26];
        }
        public TrieNode(char c){
            this.val = c;
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }
    
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    
    public void addWord(String word) {
        if(word == null || word.length() == 0){
            return;
        }
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
            if(i == word.length() - 1){
                node.isWord = true;
            }
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root);
    }
    
    public boolean search(String word, TrieNode root){
        if(root == null){
            return false;
        }
        if(word.length() == 0){
            return root.isWord;
        }
        char c = word.charAt(0);
        if(c == '.'){
            for(int i = 0; i < 26; i++){
                if(root.children[i] == null) continue;
                if(search(word.substring(1), root.children[i])){
                    return true;
                }
            }
            return false;
        }else{
            if(root.children[c - 'a'] == null){
                return false;
            }
            return search(word.substring(1), root.children[c - 'a']);
        }
        
    }
}
