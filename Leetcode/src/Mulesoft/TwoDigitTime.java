package Mulesoft;

import java.util.HashSet;

public class TwoDigitTime {
	class Time{
		int hour;
		int minute;
		int second;
		public Time(String time){
			// hh:mm:ss
			this.hour = Integer.parseInt(time.substring(0,2));
			this.minute = Integer.parseInt(time.substring(3,5));
			this.second = Integer.parseInt(time.substring(6,8));
		}
		
		public boolean equals(Time time2){
			if(this.hour == time2.hour && this.minute == time2.minute 
						&& this.second == time2.second){
				return true;
			}
			return false;
		}
		
		public boolean lessThanTwoDigit(){
			HashSet<Integer> set = new HashSet<Integer>();
			set.add(this.hour / 10);
			set.add(this.hour % 10);
			set.add(this.minute / 10);
			set.add(this.minute % 10);
			set.add(this.second / 10);
			set.add(this.second % 10);
			return set.size() <= 2;
		}
		
		public void addOneSecond(){
			this.second++;
			if(this.second == 60){
				this.minute++;
			}
			if(this.minute == 60){
				this.hour++;
			}
		}
	}
	
	public static int numberOfTwoDigit(String time1, String time2){
//		String time1 = "11:12:09";
//		String time2 = "11:12:59";
		TwoDigitTime dt = new TwoDigitTime();
		Time t1 = dt.new Time(time1);
		Time t2 = dt.new Time(time2);
		t2.addOneSecond();
		int cnt = 0;
		while(!t1.equals(t2)){
			if(t1.lessThanTwoDigit()){
				cnt++;
			}
			t1.addOneSecond();
		}
		return cnt;
	}
	
	public static void main(String[] args){
		System.out.println(numberOfTwoDigit("11:12:09", "11:12:59"));
		
	}
	
	
}
