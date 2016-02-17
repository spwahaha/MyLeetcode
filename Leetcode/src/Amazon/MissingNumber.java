package Amazon;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        boolean[] contains = new boolean[nums.length + 1];
        for(int num : nums){
            contains[num] = true;
        }
        for(int i = 0; i < contains.length; i++){
            if(!contains[i]){
                return i;
            }
        }
        return nums.length;
    }
    
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        long result = (long)n * ((long)n + 1) / 2;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return (int)(result - sum);
    }
}
