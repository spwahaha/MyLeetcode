package RecursionAndDP;

import java.util.Arrays;
import java.util.Comparator;

public class StackOfBoxes {
	
	public static int createStack(Box[] boxes){
		Arrays.sort(boxes, new Comparator<Box>(){
			public int compare(Box b1, Box b2){
				Integer w1 = b1.width;
				Integer w2 = b2.width;
				return w2.compareTo(w1);
			}
		});
		int max = 0;
		int[] height = new int[boxes.length];
		for(int i = 0; i < boxes.length; i++){
			max = Math.max(max, create(boxes, 0, boxes[0], height));
		}
		return max;
	}
	
	private static int create(Box[] boxes, int start, Box bottom,int[] map){
		if(start >= boxes.length) return 0;
		if(map[start] > 0){
			return map[start];
		}
		int maxHeight = 0;
		for(int i = start; i < boxes.length; i++){
			Box box = boxes[i];
			// test all the possibility
			// 1->2 or 1->3, so 1 is bottom, 
			// we need to test 2, and 3 as bottom respectively
			// and get the maxHeight from them respectively
			if(box.canBeAbove(bottom)){
				int height = create(boxes, i + 1, box,map);
				maxHeight = Math.max(maxHeight, height);
			}
		}
		maxHeight += bottom.height;
		map[start] = maxHeight;
		return maxHeight;
	}
	
	
	public static void main(String[] args){
		Box[] boxes = {new Box(1,2,3), new Box(2,3,4), new Box(1,2,3)
						, new Box(1,2,3), new Box(1,2,3), new Box(1,2,3)
						, new Box(1,2,3), new Box(1,2,3), new Box(1,2,3)};
		System.out.println(createStack(boxes));
	}
	
	
}
