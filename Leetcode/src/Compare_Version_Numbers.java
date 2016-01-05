
public class Compare_Version_Numbers {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("[.]");
        String[] v2 = version2.split("[.]");
        String[] longer = v1.length>v2.length?v1:v2;
        String[] shorter = v1.length>v2.length?v2:v1;
        for(int i = 0; i < shorter.length; i++){
            int ver1 = Integer.parseInt(v1[i]);
            int ver2 = Integer.parseInt(v2[i]);
            if(ver1>ver2) return 1;
            if(ver1<ver2) return -1;
        }
        if(v1.length>v2.length) return 1;
        if(v2.length<v2.length) return -1;
        return 0;
    }
    public static void main(String[] args){
    	System.out.println(compareVersion("1","1.1"));
    }
}
