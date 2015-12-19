public class Solution {
    public static int compareVersion(String version1, String version2) {

        String[] vers1 = version1.split("[.]");
        String[] vers2 = version2.split("[.]");
        int[] ver1 = new int[Math.max(1, Math.max(vers1.length,vers2.length))];
        int[] ver2 = new int[ver1.length];
        if(version1.contains(".")){
            for(int i = 0; i < vers1.length;i++){
            	ver1[i] = Integer.parseInt(vers1[i]);
            }
        }else{
            ver1[0] = Integer.parseInt(version1);
        }        
        if(version2.contains(".")){
            for(int i = 0; i < vers2.length;i++){
            	ver2[i] = Integer.parseInt(vers2[i]);
            }
        }else{
        	ver2[0] = Integer.parseInt(version2);
        }
        for(int i = 0; i < ver1.length;i++){
            if(ver1[i]<ver2[i])
                return -1;
            if(ver1[i]>ver2[i])
                return 1;
        }
        return 0;
    }
    
    public static void main(String[] args){
    	System.out.println(compareVersion("2","1"));
    }
}