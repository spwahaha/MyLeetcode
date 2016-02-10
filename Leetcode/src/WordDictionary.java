public class WordDictionary {
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
    
    public TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            int index = letter - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode(letter);
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root);
    }
    
    private boolean search(String word, TrieNode root){
        if(word.length() == 1){
            char letter = word.charAt(0);
            int index = letter - 'a';
            if(letter == '.'){
                for(int i = 0; i < 26; i++){
                    if(root.children[i] != null 
                    && root.children[i].isWord){
                        return true;
                    }
                }
                return false;
            }else{
                if(root.children[index] != null && root.children[index].isWord){
                    return true;
                }else{
                    return false;
                }
            }
        }
        
        char letter = word.charAt(0);
        int index = letter - 'a';
        if(letter == '.'){
            for(int i = 0; i < 26; i++){
            	if(root.children[i] == null) continue;
                if(search(word.substring(1), root.children[i]))
                    return true;
            }
            return false;
        }else{
            if(root.children[index] == null) return false;
            return search(word.substring(1), root.children[index]);
        }
    }
    
    public static void main(String[] args){
    	WordDictionary wd = new WordDictionary();
    	wd.addWord("a");
    	wd.addWord("a");
    	wd.search(".");
    	wd.search("a");
    	wd.search("aa");
    	wd.search("a");
    	wd.search(".a");
    	wd.search("a.");

    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");