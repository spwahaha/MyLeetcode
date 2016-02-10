import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Word_Ladder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        return helper(map, beginWord, endWord, wordList) + 2;

    }
    
    private int helper(HashMap<String,Integer> map, String beginWord, String endWord, Set<String> wordList){
        if(map.containsKey(beginWord)){
            return map.get(beginWord);
        }
        
        if(reachable(beginWord, endWord)){
            return 0;
        }
        HashSet<String> interSet = new HashSet<String>();
        findInter(interSet, beginWord, wordList);
        int min = Integer.MAX_VALUE;
        for(String inter : interSet){
            wordList.remove(inter);
            min = Math.min(min, helper(map, inter, endWord, wordList));
            wordList.add(inter);
        }
        map.put(beginWord, min + 1);
        return min + 1;
        
    }
    
    private boolean reachable(String begin, String end){
        char[] ch = begin.toCharArray();
        for(int i = 0; i < ch.length; i++){
            char letter = ch[i];
            for(int j = 0; j < 26; j++){
                ch[i] = (char)('a' + j);
                if(end.equals(new String(ch))) return true;
            }
            ch[i] = letter;
        }
        return false;
    }
    
    private void findInter(HashSet<String> set, String beginWord, Set<String> wordList){
        char[] ch = beginWord.toCharArray();
        for(int i = 0; i < ch.length; i++){
            char letter = ch[i];
            for(int j = 0; j < 26; j++){
                ch[i] = (char)('a' + j);
                String transformed = new String(ch);
                if(wordList.contains(transformed)){
                    set.add(transformed);
                }
            }
            ch[i] = letter;
        }
    }
    
    public static void main(String[] args){
    	HashSet<String> set = new HashSet<String>();
    	String[] strs = {"dose","ends","dine","jars","prow","soap","guns","hops"
    				,"cray","hove","ella","hour","lens","jive","wiry","earl","mara",
    				"part","flue","putt","rory","bull","york","ruts","lily","vamp",
    				"bask","peer","boat","dens","lyre","jets","wide","rile","boos",
    				"down","path","onyx","mows","toke","soto","dork","nape","mans",
    				"loin","jots","male","sits","minn","sale","pets","hugo","woke",
    				"suds","rugs","vole","warp","mite","pews","lips","pals","nigh",
    				"sulk","vice","clod","iowa","gibe","shad","carl","huns","coot",
    				"sera","mils","rose","orly","ford","void","time","eloy","risk",
    				"veep","reps","dolt","hens","tray","melt","rung","rich","saga",
    				"lust","yews","rode","many","cods","rape","last","tile","nosy",
    				"take","nope","toni","bank","jock","jody","diss","nips","bake",
    				"lima","wore","kins","cult","hart","wuss","tale","sing","lake",
    				"bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope",
    				"hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"};
    	
    	for(String str : strs){
    		set.add(str);
    	}
    	Word_Ladder wl = new Word_Ladder();
    	System.out.println(wl.ladderLength("nape", "mild", set));
    }
}
