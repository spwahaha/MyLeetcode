import java.util.ArrayList;
import java.util.Collections;

class MedianFinder1 {
	
	private int[] list = new int[2];
	private int pointer = 0;
//	private ArrayList<Integer> list = new ArrayList<Integer>();
    // Adds a number into the data structure.
    public void addNum(int num) {
//        list.add(num);
//        Collections.sort(list);
    	list[pointer++] = num;
    	if(pointer==list.length-1)
    		resize();
    	swim(pointer-1);
    }
    private void resize(){
    	int[] newList = new int[list.length * 2];
    	for(int i=0; i < list.length;i++){
    		newList[i] = list[i];
    	}
    	list = newList;
    }

    private void swim(int i){
    	if(i < 1) return ;
//    	int j = i -1;
    	while(i-1>=0&&list[i-1]>list[i]){
    		int temp = list[i-1];
    		list[i-1] = list[i];
    		list[i] = temp;
    		i--;
    	}

    }
    // Returns the median of current data stream
    public double findMedian() {
    	
    	if(pointer==0) return 0; 
    	double res = 0;
    	if(pointer%2==0){
    		//even
    		res = (list[pointer/2] + list[pointer/2-1])/2.0;
    	}else{
    		//odd
    		res = list[pointer/2];
    	}
		return res;

    }
    
    public static void main(String[] args){
    	MedianFinder1 mf = new MedianFinder1();
//    	System.out.println(mf.findMedian());
    	mf.addNum(-1);
    	System.out.println(mf.findMedian());
    	mf.addNum(-2);
    	System.out.println(mf.findMedian());
    	mf.addNum(-3);
    	System.out.println(mf.findMedian());
    	mf.addNum(-4);
    	System.out.println(mf.findMedian());
    	mf.addNum(-5);
    	System.out.println(mf.findMedian());
    }
    
}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();