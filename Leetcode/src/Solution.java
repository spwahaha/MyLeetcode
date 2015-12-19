import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.swing.event.ListSelectionEvent;
import javax.xml.transform.Templates;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = head;
        ListNode cur;
        ListNode post;
        ListNode ppre = new ListNode(0);
        if(pre==null||pre.next==null){
            return head;
        }
        head = pre.next;
        while(pre!=null&&pre.next!=null){
            cur = pre.next;
            post = cur.next;
            
            pre.next = post;
            cur.next = pre;
            ppre.next = cur;
            
            ppre = pre;
            pre = post;
            
        }
        return head;
    }
    
    public ListNode detectCycle(ListNode head){
    	ListNode fast = head;
    	ListNode slow = head;
    	
    	while(fast!=null&&slow!=null&&fast.next!=null){
    		fast = fast.next.next;
    		slow = slow.next;
    		if(fast == slow){
    			fast = head;
    			while(fast!=slow){
    				fast = fast.next;
    				slow = slow.next;
    			}
    			return fast;
    		} 

    	}
    	return null;
    }
    
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
    	ListNode nodeA = headA;
    	ListNode nodeB = headB;
    	int countA = 1;
    	int countB = 1;
    	if(nodeA==null||nodeB==null){
    		return null;
    	}
    	while(nodeA.next!=null){
    		countA++;
    		nodeA = nodeA.next;
    	}
    	while(nodeB.next!=null){
    		countB++;
    		nodeB = nodeB.next;
    	}
    	nodeA = headA;
    	nodeB = headB;
    	if(countA-countB>0){
    		for(int i =0;i< countA-countB;i++){
    			nodeA = nodeA.next;
    		}
    	}else{
    		for(int i = 0;i<countB-countA;i++){
    			nodeB = nodeB.next;
    		}
    	}
    	while(nodeA!=null&&nodeB!=null){
    		if(nodeA==nodeB) return nodeA;
    		nodeA = nodeA.next;
    		nodeB = nodeB.next;
    	}
    	return null;
    }
    
    public ListNode partition(ListNode head, int x){
    	if(head == null) return head;
    	
    	ListNode less = new ListNode(-1);
    	ListNode greater = new ListNode(-1);
    	
    	ListNode p = less;
    	ListNode q = greater;
    	
    	while(head!=null){
    		if(head.val<x){
    			p.next = head;
    			head = head.next;
    			p = p.next;
    			p.next = null;
    		}else{
    			q.next = head;
    			head = head.next;
    			q = q.next;
    			q.next = null;
    		}
    	}
    	
    	p.next = greater.next;
    	return less.next;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n){
//    	if(head==null||head.next==null) return null;
    	int count = 0;
    	ListNode node = head;
    	while(node!=null){
    		count++;
    		node = node.next;
    	}
    	int m = count-n;
    	ListNode pre = new ListNode(-1);
    	pre.next = head;
    	node = pre;
    	for(int i=0;i<m;i++){
    		node = node.next;
    	}
    	node.next = node.next.next;
    	
    	return pre.next;
    }
    
    
    public ListNode removeNthFromEnd2(ListNode head, int n){
    	ListNode pre = new ListNode(-1);
    	pre.next = head;
    	ListNode p = pre;
    	ListNode q = pre;
    	for(int i=0;i<n;i++){ 
    		p = p.next;
    	}
    	while(p.next!=null){
    		p = p.next;
    		q = q.next;
    	}
    	q.next = q.next.next;
    	
    	return pre.next;
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n){
    	ListNode pre = new ListNode(-1);
    	pre.next = head;
    	ListNode node = pre;
    	int count = 0;
    	for(count = 0; count<m-1;count++){
    		node = node.next;
    		System.out.println("m"+node.val);
    	}
    	
    	ListNode preFakeHead = node;
    	ListNode fakeHead = node.next;
    	
    	for(;count<n;count++){
    		node = node.next;
    		System.out.println("n"+node.val);
    	}
    	ListNode nextHead = node.next;
    	preFakeHead.next = reverseList2(fakeHead,m-n,nextHead);
//    	System.out.println("nexHead"+nextHead.val);
    	return pre.next;
    	
    }
    
    
    public ListNode reverseList2(ListNode head, int n,ListNode nextHead){
		if(head.next==nextHead){
			return head;
		}
		
		ListNode p = head.next;
		n--;
		
		ListNode node = reverseList2(p,n,nextHead);
		
		head.next = nextHead;
		p.next = head;

		
	    return node;
	}

    
    public ListNode reverseBetween2(ListNode head, int m, int n){
    	ListNode fakeHead = new ListNode(-1);
    	fakeHead.next = head;
    	ListNode node = fakeHead;
    	int count = 0;
    	for(count = 0; count<m-1;count++){
    		node = node.next;
    		System.out.println("m"+node.val);
    	}
    	ListNode pre = node;
    	ListNode ppre = node;
    	ListNode startNode = node.next;
    	ListNode p = pre.next;
		ListNode post = p.next;
		
    	for(;count<n;count++){
    		System.out.println(p.val);
    		p.next = pre;
    		pre = p;
    		p = post;
    		if(post!=null){
        		post = post.next;
    		}

    	}
    	
    	ppre.next = pre;
    	startNode.next = p;
    	
//    	ppre.next
    	return fakeHead.next;
    	
    
    }
    
    public ListNode removeElements(ListNode head, int val){
    	ListNode fakeHead = new ListNode(-1);
    	fakeHead.next = head;
    	ListNode node = fakeHead;
    	while(node.next!=null){
    		if(node.next.val == val){
    			node.next = node.next.next;
    		}else{
    			node = node.next;
    		}
    	}
    	return fakeHead.next;
    }
    
    public boolean isPalindrome(ListNode head){
    	ArrayList<Integer> ar = new ArrayList<Integer>();
    	ListNode node = head;
    	while(node!=null){
    		ar.add(node.val);
    		node = node.next;
    	}
    	for(int i=0, j=ar.size()-1;i<j;i++,j--){
    		System.out.println("i"+ar.get(i)+"j"+ar.get(j));
    		System.out.println("?"+(ar.get(i)==ar.get(j)));
    		if(ar.get(i)!=ar.get(j)){
    			return false;
    		}
    	}
    	return true;
    	
    }
    
    public RandomListNode copyRandomList(RandomListNode head){
    	
    	if(head == null) return null;

    	RandomListNode node = head;

    	while(node!=null){//new line but without new random
    		RandomListNode addNew = new RandomListNode(node.label);
    		addNew.next = node.next;
    		node.next = addNew;
    		node = node.next.next;
    	}
    	
    	node = head;
    	while(node!=null){// add random to new
    		if(node.random!=null){
        		node.next.random = node.random.next;
    		}else{
    			node.random = null;
    		}
    		node = node.next.next;	
    	}
    	
    	node = head; 
    	RandomListNode newNode = head.next;
    	RandomListNode newHead = head.next;
    	while(node!=null){
    		
    		node.next = newNode.next;
    		node = node.next;
    		if(node!=null){
        		newNode.next = node.next;
        		newNode = newNode.next;
    		}
    	}

    	return newHead;
    }
    
    public ListNode deleteDuplicates(ListNode head){
    	ListNode fakeHead = new ListNode(-1);
    	ListNode pre = fakeHead;
    	pre.next = head;
    	ListNode p = head;
    	int dupval = -255;
    	while(p!=null&&p.next!=null){
    		if(p.val == p.next.val){
    			dupval = p.val;
    		}
    		
    		if(p.val == dupval){
    			while(p!=null&&p.val == dupval){
        			pre.next = p.next;
        			p = p.next;
        		}
    		}else{
    			p = p.next;
    			pre = pre.next;
    		}
    		
    	}
    	return fakeHead.next;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
    	int carry = 0;
    	int temp = 0;
    	int p1v = 0;
    	int p2v = 0;
    	ListNode fakeHead = new ListNode(-1);
    	ListNode node = fakeHead;
    	ListNode p1 = l1;
    	ListNode p2 = l2;
    	while(p1!=null||p2!=null){
    		node.next = new ListNode(-1);
    		node = node.next;
    		if(p1==null){
    			p1v = 0;
    		}else{
    			p1v = p1.val;
    		}
    		p1v = p1==null?0:p1.val;
    		if(p2==null){
    			p2v = 0;
    		}else{
    			p2v = p2.val;
    		}
    		
    		temp = p1v+p2v+carry;
    		carry = temp/10;
    		node.val = temp%10;
    		
    		if(p1!=null){
    			p1 = p1.next;
    		}
    		if(p2!=null){
    			p2 = p2.next;
    		}
    	}
    	

    	if(carry==1){
    		node.next = new ListNode(carry);
    	}
    	
    	return fakeHead.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    	int carry = 0;
    	int temp = 0;
    	ListNode fakeHead = new ListNode(-1);
    	ListNode node = fakeHead;
    	ListNode p1 = l1;
    	ListNode p2 = l2;
    	while(p1!=null&&p2!=null){
    		node.next = new ListNode(-1);
    		node = node.next;
    		
    		temp = p1.val+p2.val+carry;
    		carry = temp/10;
    		node.val = temp%10;
    		
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	
    	if(p1==null&&p2==null){
    		if(carry==1){
        		node.next= new ListNode(carry);
    		}
    		return fakeHead.next;
    	}
    	
    	while(p1!=null){
    		node.next = new ListNode(-1);
    		node = node.next;
    		
    		temp = p1.val+carry;
    		carry = temp/10;
    		node.val = temp%10;
    		p1 = p1.next;
    	}
    	
    	while(p2!=null){
    		node.next = new ListNode(-1);
    		node = node.next;
    		
    		temp = p2.val+carry;
    		carry = temp/10;
    		node.val = temp%10;
    		p2 = p2.next;

    	}
    	if(carry==1){
    		node.next = new ListNode(carry);
    	}
    	
    	return fakeHead.next;
    }
    
    
    public ListNode retateRight(ListNode head, int k){
    	ListNode fakeHead = new ListNode(-1);
    	fakeHead.next = head;
    	ListNode p = fakeHead;
    	int length = 0;
    	int realK = k;
    	if(head ==null||head.next==null){
    		return head;
    	}
    	while(p.next!=null){
    		length++;
    		p = p.next;
    	}
    	realK = k%length;
    	if(realK==0){
    		return head;
    	}
    	ListNode node  = fakeHead;
    	for(int i=0;i<length-realK;i++){
    		node = node.next;
    	}
    	
    	fakeHead.next = node.next;
    	node.next = null;
    	p.next = head;
    	
    	return fakeHead.next;
    }
    
    
    public void reorderList(ListNode head){//Time Limit Exceed
    	if(head==null||
    			head.next==null||
    			head.next.next==null){
    	}else{
    		ListNode p = head;
    		ListNode node = head;
    		
    		while(p.next.next!=null){
    			if(node.next==null){
    				break;
    			}
    			while(node.next.next!=null){
    				node = node.next;
    			}
    			node.next.next = p.next;
    			p.next = node.next;
    			
    			node.next = null;
        		p = p.next.next;
        		if(p.next==null){
        			break;
        		}
        		node = p;
    		}
    	}
    }
    
    public void reorderList2(ListNode head){
    	if(head!=null&&
    			head.next!=null&&
    			head.next.next !=null){
    		ListNode fast = head;
    		ListNode slow = head;
    		while(fast!=null&&fast.next!=null&&fast.next.next!=null){
    			slow = slow.next;
    			fast = fast.next.next;
    		}
    		
    		ListNode l1 = head;  //long
    		ListNode l2 = slow.next; //short
    		slow.next = null;
    		l2 = reverseList(l2);
    		while(l2!=null){
    			ListNode l2p = l2.next;
    			l2.next = l1.next;
    			l1.next = l2;
    			
    			l1 = l1.next.next;
    			l2 = l2p;

    		}
    		
    	}

    }
    
    public ListNode reverseList(ListNode head){
    	if(head.next == null||head==null){
    		return head;
    	}
    	ListNode p = head.next;
    	
    	ListNode n = reverseList(p);
    	
    		p.next = head;
    		head.next = null;
    		
    		return n;
    }
    
    public ListNode reverseList2(ListNode head){
    	if(head==null||head.next==null){
    		return head;
    	}
    	ListNode pre = head;
    	ListNode p = head.next;
    	ListNode post = p.next;
    	pre.next = null;
    	while(p !=null){
//    		pre.next = null;
    		p.next = pre;
    		
    		pre = p;
    		p = post;
    		if(post!=null)
    		post = post.next;
    	}
    	
    	return pre;
    }
    
    public boolean containsDuplicate(int[] nums){
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length-1;i++){
    		if(nums[i]==nums[i+1]){
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean containsDuplicate2(int[] nums){
    	if(nums.length<2) return false;
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i=0;i<nums.length;i++){
    		if(map.containsKey(nums[i])){
    			return true;
    		}else{
    			map.put(nums[i], 1);
    		}
    	}
    	return false;
    	
    }
    
    public int[] plusOne(int[] digits){
    	int carry=0;
    	int temp = 0;
    	for(int i=digits.length-1;i>=0;i--){
    		temp = digits[i]+carry;
    		if(i==digits.length-1){
    			temp +=1;
    		}
    		carry = temp/10;
    		digits[i] = temp%10;
    	}
    	if(carry ==0){
    		return digits;
    	}else{
    		int[] newDigits = new int[digits.length+1];
    		newDigits[0] = 1;
    		for(int i=0;i<digits.length;i++){
    			newDigits[i+1] = digits[i];
    		}
    		return newDigits;
    	}
    	
    }
    
    public int removeElement(int[] nums, int val){
//    	int length = nums.length;
    	int startPosi = 0;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i] != val){	
    			nums[startPosi] = nums[i];
    			startPosi++;
    		}
    	}
    	return startPosi;
    }
    
    public void rotate(int[] nums,int k){
    	if(nums.length>1){
        	k = k%nums.length;
        	int[] temp = new int[nums.length-k];
        	for(int i=0;i<temp.length;i++){
        		temp[i] = nums[i];
        	}
        	
        	for(int i=0;i<k;i++){
        		nums[i] = nums[i+nums.length-k];
        	}
        	
        	for(int i=0;i<temp.length;i++){
        		nums[k+i] = temp[i];
        	}
    	}
    }
    
    public void rotate2(int[] nums,int k){
    	int length = nums.length;
    	if(nums.length>1){
    		k = k%nums.length;
    		int temp = 0;
    		for(int i=0;i<k;i++){
    			temp = nums[length-1];
    			for(int j=length-1;j>0;j--){
    				nums[j] = nums[j-1];
    			}
    			nums[0] = temp;
    		}
    	}
    }
    
    public void rotate3(int[] nums, int k){
    	int length = nums.length;
    	if(length>1){
    		k = k%length;
    		int[] temp = new int[k];
    		for(int i = length-k,j=0;i<length;i++,j++){
    			temp[j] = nums[i];
    		}
    		for(int i=0;i<length-k;i++){
    			nums[length-1-i] = nums[length-1-i-k];
    		}
    		for(int i = 0;i<k;i++){
    			nums[i] = temp[i];
    		}
    	}	
    }
    public void rotate4(int[] nums, int k){
    	k = k%nums.length;
    	reverseArray(nums,0,nums.length-k-1);
    	reverseArray(nums,nums.length-k-1,nums.length-1);
    	reverseArray(nums,0,nums.length-1);
    }
    
    public void reverseArray(int[] nums,int m,int n){
    	for(int i = m,j=n;i<=(m+n)/2;i++,j--){
    		int temp = nums[i];
    		nums[i] = nums[j];
    		nums[j] = temp;
    	}
    }
    
    public int removeDuplicates(int[] nums){
    	int length = nums.length;
    	int startp = 0;
    	if(length>1){
    		for(int i=0;i<length-1;i++){
    			if(nums[i]!=nums[i+1]){
    				nums[startp] = nums[i];
    				startp++;
    			}
    		}
    		nums[startp] = nums[length-1];
    		return startp+1;
    	}
    	return length;
    }
    
    public int removeDuplicates2(int[] nums){
    	int length = nums.length;
    	int index = 1;
    	if(length>1){
    		for(int i=1;i<length;i++){
    			if(nums[i]!=nums[i-1]){
    				nums[index] = nums[i];
    				index++;
    			}
    		}
    		return index;
    	}
    	return length;
    }
    
    public List<String> summaryRanges(int[] nums){
    	if(nums.length==0) return new ArrayList<String>();
    	List<String> result= new ArrayList<String>();
    	if(nums.length==1){
    		result.add(nums[0]+"");
    		return result;
    	}
    	int start = nums[0];
    	int end = 0;
    	for(int i=0;i<nums.length-1;i++){
    		if(nums[i+1]!=nums[i]+1){
    			end = nums[i];
    			if(end-start>0){
        			result.add(start+"->"+end);
        		}else{
        			result.add(""+start);
        		}
    			start = nums[i+1];
    		}
    	}
    	end = nums[nums.length-1];
    	if(start == end){
    		result.add(""+start);
    	}else{
    		result.add(start+"->"+end);
    	}
    	return result;
    }
    
    public List<String> summaryRanges2(int[] nums){
    	int length = nums.length;
    	List<String> result = new ArrayList<String>();
    	for(int i=0;i<length;i++){
    		int num = nums[i];
    		
    		while(i<length-1&&nums[i]+1==nums[i+1]){
    			i++;
    		}
    		if(num==nums[i]){
    			result.add(""+num);
    		}else{
    			result.add(num+""+nums[i]);
    		}
    	}
    	return result;
    }
        
    public boolean isUgly(int num){
    	if(num<=0){
    		return false;
    	}
    	while(num%2==0){
    		num = num/2;
    	}
    	while(num%3==0){
    		num = num/3;
    	}
    	while(num%5==0){
    		num = num/5;
    	}
    	return num==1;
    }
    
    public List<List<Integer>> generate(int numRows){
    	if(numRows==0) return new ArrayList<>();
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> first = new ArrayList<Integer>();
    	first.add(1);
    	result.add(first);
    	for(int i=1;i<numRows;i++){
    		List<Integer> last = new ArrayList<Integer>();
    		last = result.get(i-1);
    		List<Integer> cur = new ArrayList<Integer>();
    		cur.add(1);
    		for(int j=1;j<last.size();j++){
    			cur.add(last.get(j-1)+last.get(j));
    		}
    		cur.add(1);
    		result.add(cur);
    	}
    	return result;
    	
    }
    
    public List<Integer> getRow(int rowIndex){
//    	if(rowIndex == 0) return new ArrayList<Integer>();
    	ArrayList<Integer> last = new ArrayList<Integer>();
    	last.add(1);
    	ArrayList<Integer> cur = new ArrayList<Integer>();
    	for(int i=1;i<rowIndex+1;i++){
    		cur.add(1);
    		for(int j=1;j<last.size();j++){
    			cur.add(last.get(j-1)+last.get(j));
    		}
    		cur.add(1);
    		last = cur;
    		cur= new ArrayList<Integer>();
    	}
    	return last;
    }
    
    public List<Integer> getRow2(int rowIndex){
    	Integer[] arr = new Integer[rowIndex+1];
    	Arrays.fill(arr, 0);
    	arr[0] = 1;
    	for(int i=1;i<=rowIndex;i++){
			System.out.println(Arrays.toString(arr));
    		for(int j=i;j>0;j--){

    			arr[j] = arr[j]+arr[j-1];

    		}
    	}
    	System.out.println(Arrays.toString(arr));
    	return Arrays.asList(arr);
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n){
    	 for(int i=0;i<n;i++){
    		 nums1[i+m] = nums2[i];
    	 }
    	 Arrays.sort(nums1);
    	 for(int i=0;i<m+n;i++){
    		 nums1[i] = nums1[nums1.length-(m+n)+i];
    	 }
    	 for(int i=m+n;i<nums1.length;i++){
    		 nums1[i] = 0;
    	 }
    }
    
    public void merge2(int[] nums1,int m, int[] nums2, int n){
    	int i = m-1;
    	int j = n-1;
    	int k = nums1.length-1;
    	while(i>=0&&j>=0){
    		if(nums1[i]>nums2[j]){
    			nums1[k--] = nums1[i--];
    		}else{
    			nums1[k--] = nums2[j--];
    		}
    	}
    	while(i>=0){
    		nums1[k--] = nums1[i--];
    	}
    	while(j>=0){
    		nums1[k--] = nums2[j--];
    	}
    	for(i=0;i<m+n;i++){
		 nums1[i] = nums1[nums1.length-(m+n)+i];
    	}
    	for(i=m+n;i<nums1.length;i++){
		 nums1[i] = 0;
    	}	
    }
    
    public int majorityElement(int[] nums){
    	String numsst="";
    	for(int i =0;i<nums.length;i++)
    		numsst+=nums[i];
    	System.out.println(numsst);
    	int n = 0;
    	int start = 0;
    	int major = 0;
    	char temp;
    	for(int i=0;i<numsst.length();i++){
    		temp = numsst.charAt(i);
    		while(numsst.indexOf(temp,start)!=-1){
    			start = numsst.indexOf(temp, start)+1;
    			n++;
    		}
    		if(n>numsst.length()/2){
    			major = Integer.parseInt(String.valueOf(temp));
    			break;
    		}
    		start =0;
    		n=0;
    	}
    	return major;
    }
    
    public int majorityElement2(int[] nums){
    	Arrays.sort(nums);
    	return nums[nums.length/2];
    }
    
    public int majorityElement3(int[] nums){
    	if(nums.length<2) return nums[0];
    	HashMap<Integer, Integer> map= new HashMap<Integer,Integer>();
    	for(int i=0;i<nums.length;i++){
    		if(map.containsKey(nums[i])){
    			map.put(nums[i], map.get(nums[i])+1);
    			if(map.get(nums[i])>nums.length/2){
    				return nums[i];
    			}
    		}else{
    			map.put(nums[i], 1);
    		}
    	}
    	
    	return 0;
    }
    
    public boolean containsNearbyDuplicate(int[] nums,int k){
    	if(nums.length<2) return false;
    	HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
    	
    	for(int i=0;i<nums.length;i++){
    		if(map.containsKey(nums[i])){
//    			Integer temp = map.get(nums[i]);
    			if(i-map.get(nums[i])<=k){
    				return true;
    			}else{
    				map.put(nums[i], i);
    			}
    		}else{
    			map.put(nums[i], i);
    		}
    	}
    	return false;
    }
    
    public int[] twoSum(int[] nums, int target){
    	HashMap<Integer,Integer> table = new HashMap<Integer,Integer>();
    	int[] index = new int[2];
    	for(int i=0;i<nums.length;i++){
    		if(table.containsKey(target-nums[i])){
    			index[0] = table.get(target-nums[i])+1;
    			index[1] = i+1;
    			break;
    		}else{
    			table.put(nums[i],i);
    		}
    	}
    	System.out.println(index[0]);
    	System.out.println(index[1]);
    	return index;
    }
    
    public int minSubArrayLen(int s,int[] nums){
    	
    	int sum = 0;
    	int min = Integer.MAX_VALUE;
    	int i=0;
    	int j=0;
    	while(i<nums.length){
        	while(sum<s&&i<nums.length){
        		sum+=nums[i++];
        		System.out.println(sum+"?"+s);
        	}
    		while(sum>=s){
    			sum-=nums[j++];
    			System.out.println(sum+"??"+s);
    		}
    		min = Math.min(min, i-j+1);
    		System.out.println(min+"???"+i);
    	}

    	System.out.println( min==Integer.MAX_VALUE?0:min);
    	return min==Integer.MAX_VALUE?0:min;
    }
    
    public int threeSumClosest(int[] nums, int target){
    	if(nums.length<3) return 0;
    	int closest = nums[0]+nums[1]+nums[2];
    	int newSum = 0;
    	Arrays.sort(nums);
    	for(int i1=0;i1<nums.length;i1++){
    		int i2 = i1+1;
    		int i3 = nums.length-1;
    		while(i2<i3){
    			newSum = nums[i1]+nums[i2]+nums[i3];
    			closest = Math.abs(closest-target)<=Math.abs(newSum-target)?closest:newSum;
    			if(newSum>target){
    				i3--;
    			}else{
    				i2++;
    			}
    		}
    	}
    	System.out.println(closest);
    	return closest;
    }
    
    public List<List<Integer>> threeSum(int[] nums){
    	List<List<Integer>> result = new ArrayList<>();
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length-2;i++){
    		if(i==0||(i>0&&nums[i]!=nums[i-1])){
    			int lo = i+1,hi = nums.length-1,sum = 0-nums[i];
    			while(lo<hi){
    				if(nums[lo]+nums[hi]==sum){
    					result.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
    					while(lo<hi&&nums[lo]==nums[lo+1]) lo++;
    					while(lo<hi&&nums[hi]==nums[hi-1]) hi--;
    					lo++;
    					hi--;
    				}else if(nums[lo]+nums[hi]<sum) lo++;
    				else hi--;
    			}
    		}
    	}
    	return result;
    }
    
    public void setZeros(int[][] matrix){
    	int m = matrix.length;
    	int n = matrix[0].length;
    	System.out.println(m+"?"+n);
    	boolean lastRowHas0=false;
    	boolean lastCluHas0 = false;
    	
    	for(int i=0;i<n;i++){
    		if(matrix[m-1][i]==0){
    			lastRowHas0=true;
    			break;
    		}
    	}
    	
    	for(int i=0;i<m;i++){
    		if(matrix[i][n-1]==0){
    			lastCluHas0=true;
    			break;
    		}
    	}
    	
    	
    	for(int i=0;i<m-1;i++){
    		for(int j=0;j<n-1;j++){
    			if(matrix[i][j]==0){
    				matrix[i][n-1] = 0;
    				matrix[m-1][j] = 0;
    				System.out.println(i+"??"+j);
    			}
    		}
    	}
    	
    	for(int i=0;i<m-1;i++){
    		if(matrix[i][n-1]==0){
    			for(int j=0;j<n-1;j++){
    				matrix[i][j]=0;
    				System.out.println(i+"??"+j);
    			}
    		}    		
    	}

    	
    	for(int j=0;j<n-1;j++){
    		if(matrix[m-1][j]==0){
				System.out.println("???"+j);
    			for(int i=0;i<m-1;i++){
    				matrix[i][j]=0;
    				System.out.println(i+"??"+j);
    			}
    		}
    	}
    	
    	if(lastRowHas0){
    		for(int j=0;j<n;j++){
				matrix[m-1][j]=0;
				System.out.println("??"+j);
			}
    	}
    	if(lastCluHas0){
    		for(int i=0;i<m;i++){
    			matrix[i][n-1]=0;
    		}
    	}
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++){
    	    	System.out.println(matrix[i][j]);
    		}
    	}
    }
    
    public void setZeros2(int[][] matrix){
    	int H = matrix.length;
    	int W = matrix[0].length;
    	
    	//find the last 0 row
    	int last0Row = -1;
    	for(int y = H-1;y>=0&&last0Row ==-1;y--){
    		for(int x=0;x<W;x++){
    			if(matrix[y][x]==0){
    				last0Row=y;
    				break;
    			}
    		}
    	}
    	
    	if(last0Row==-1){
    		return ;
    	}
    	
    	// go row by row
    	for(int y=0;y<last0Row;y++){
    		boolean thisIsA0Row = false;
    		for(int x=0;x<W;x++){
    			if(matrix[y][x]==0){
    				thisIsA0Row = true;
    				matrix[last0Row][x]=0;
    			}
    		}
    		
    		if(thisIsA0Row){
    			for(int x=0;x<W;x++){
    				matrix[y][x] = 0;
    			}
    		}
    	}
    	//set columns to 0
    	for(int y=0;y<H;y++){
    		for(int x=0;x<W;x++){
    			if(matrix[last0Row][x]==0){
    				matrix[y][x] = 0;
    			}
    		}
    	}
    	//set the last 0 row
    	for(int x=0;x<W;x++){
    		matrix[last0Row][x]=0;
    	}
    }
    
    public int searchInsert(int[] nums,int target){
    	int len = nums.length;
    	if(target<nums[0]) return 0;
    	if(target>nums[len-1]) return len;
    	for(int i=1;i<len;i++){
    		if(target<=nums[i])
    			return i;
    	}
    	return 0;
    }
    public int searchInsert2(int[] nums,int target){
    	int first=0, last = nums.length,mid;
    	while(first<last){
    		mid = first+((last-first)/2);
    		if(nums[mid]<target){
    			first = mid+1;
    		}else{
    			last = mid;
    		}
    	}
    	return first;
    	
    }
    
    
    public int uniquePaths(int m,int n){
    	int lower = m<=n?m-1:n-1;
    	int sum = m+n-2;
    	long a=1;
    	for(int i=1;i<=lower;i++){
    		System.out.println(sum+"-"+i);
    		a = a*sum;
    		a = a/i;
    		sum--;
//    		System.out.println(a+">"+sum);
    	}
    	System.out.println(a);

    	return (int)a;
    }
    
    public int search(int[] nums, int target){
    	int first = 0, last = nums.length-1,mid;
    	while(first<=last){
    		mid = first+((last-first)/2);
    		
    		if(nums[mid]==target) return mid;
    		
    		if(nums[first]==nums[mid]&&nums[last]==nums[mid]){
    			first++;
    			last--;
    		}
    		if(nums[first]<=nums[mid]){
    			if(target<nums[mid]&&target>=nums[first]){
    				last = mid-1;
    			}else{
    				first = mid-1;
    			}
    		}
    		
    		if(nums[mid]<=nums[last]){
    			if(target>nums[mid]&&target<=nums[last])
    				first = mid+1;
    			else
    				last=mid-1;
    		}
    	}
    	return -1;
    }
    public boolean search2(int[] nums, int target){
        int first = 0, last = nums.length-1,mid;
    	while(first<=last){
    		mid = first+((last-first)/2);
    		
    		if(nums[mid]==target) return true;
    		
    		if(nums[first]==nums[mid]&&nums[last]==nums[mid]){
    			first++;
    			last--;
    		}else if(nums[first]<=nums[mid]){
    			if(target<nums[mid]&&target>=nums[first]){
    				last = mid-1;
    			}else{
    				first = mid+1;
    			}
    		}else{
    			if(target>nums[mid]&&target<=nums[last])
    				first = mid+1;
    			else
    				last=mid-1;
    		}
    	}
    	return false;
    }
    
    public List<List<Integer>> getConsecutiveSums(int n){
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
		int sum = 0;
		int i=1;
		int j=1;
    	while(j<=n&&i<=n){
    		if(sum<n){
    			sum +=i++;
    		}
    		if(sum == n){
    			ArrayList<Integer> temp = new ArrayList<Integer>();
    			temp.add(j);
    			temp.add(i-1);
    			result.add(temp);
    			sum+=i++;
    		}
    		if(sum>n){
    			sum-=j++;
    		}
    	}
    	ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(n);
		temp.add(n);
		result.add(temp);
    	
    	System.out.println(result.toString());
    	return result;
    	
    }
    
    public boolean solvePath(boolean[][] maze, Point start, Point end){
    	int startx = start.x;
    	int starty = start.y;
    	int endx = end.x;
    	int endy = end.y;
    	boolean temp1=false,temp2=false,temp3 = false,temp4=false;
    	
    	System.out.println(startx+"?"+starty+"?"+endx+"?"+endy);
    	maze[startx][starty]=false;
    	if(startx==endx&&starty==endy){
    		return true;
    	}

    	
    	if(starty-1>=0&&maze[startx][starty-1]){//left
    		temp1 = solvePath(maze,new Point(startx,starty-1),end);
    	}
    	
    	if(starty+1<maze[0].length&&maze[startx][starty+1]){//right
    		temp2 = solvePath(maze,new Point(startx,starty+1),end);
    	}
    	
    	if(startx-1>=0&&maze[startx-1][starty]){//up
    		temp3 = solvePath(maze,new Point(startx-1,starty),end);//up
    	}
    	
    	if(startx+1<maze.length&&maze[startx+1][starty]){//down
    		temp4 = solvePath(maze,new Point(startx+1,starty),end);
    	}
    	return (temp1||temp2||temp3||temp4);
    	
    	
    }
    
    public int[]  searchRange(int[] nums, int target){
    	int start = 0;
    	int end = nums.length-1;
    	int mid;
    	int[] res = {-1,-1};
    	if(target<nums[0]||target>nums[nums.length-1]){
    		return res;
    	}
    	
    	while(start <= end){
    		mid = start+(end-start)/2;    		
    		if(nums[mid]<target){
    			start = mid+1;
    		}
    		if(nums[mid]>target){
    			end = mid-1;
    		}
    		if(nums[mid]==target){
    			start = mid;
    			end = mid;
    			while(start-1>=0&&nums[start-1]==target){
    				start--;
    			}
    			while(end+1<=nums.length-1&&nums[end+1]==target){
    				end++;
    			}

    			break;
    		}
    		System.out.println(start);
    		System.out.println(end);
    	}
    	if(start>end){
    		return res;
    	}
    	res[0] = start;
    	res[1] = end;
    	
    	for(int i=0;i<res.length;i++){
    		System.out.println(res[i]);
    	}
    	return res;
    }
    
    public boolean searchMatrix(int[][] matrix, int target){
    	int start = 0;
    	int end = matrix.length*matrix[0].length-1;
    	
    	int mid = 0;
    	while(start<=end){
    		int i=0,j=0;
    		mid = start+(end-start)/2;
        	i = mid/(matrix[0].length);
        	j = mid%(matrix[0].length);
    		System.out.println(i+"?"+j);
    		if(matrix[i][j]<target){ 
    			start = mid+1;
    		}
    		if(matrix[i][j]>target){ 
    			end = mid-1; 
    		}
    		if(matrix[i][j]==target){
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    public void rotate(int[][] matrix){
    	int n = matrix.length;
    	for(int i=0;i<n-1;i++){
    		for(int j=i;j<n-1-i;j++){
    			int temp = matrix[i][j];
    			matrix[i][j] = matrix[n-1-j][i];
    			matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
    			matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
    			matrix[j][n-i-1] = temp;
    		}
    	}
    	
    	
    	for(int i=0;i<n;i++)
    		for(int j=0;j<n;j++){
    			System.out.println(matrix[i][j]);
    		}
    	
    }

    public List<List<Integer>> fourSum(int[] nums, int target){
    	List<List<Integer>> result= new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	for(int i1=0;i1<nums.length-1;i1++){
    		if(i1==0||nums[i1]!=nums[i1-1]){
    			for(int i2=i1+1;i2<nums.length-1;i2++){
    				if(i2==1||nums[i2]!=nums[i2-1]||nums[i1]==nums[i2]){
    					int lo=i2+1,hi=nums.length-1;
    					while(lo<hi){
    						if(nums[i1]+nums[i2]+nums[lo]+nums[hi]<target){
        						lo++;
        					}else if(nums[i1]+nums[i2]+nums[lo]+nums[hi]>target){
        						hi--;
        					}else if(nums[i1]+nums[i2]+nums[lo]+nums[hi]==target){
        						if(!result.contains(Arrays.asList(nums[i1],nums[i2],nums[lo],nums[hi])))
            						result.add(
            								Arrays.asList(nums[i1],nums[i2],nums[lo],nums[hi]));
            						while(lo<hi&&nums[lo]==nums[lo+1]){
            							lo++;
            						}
            						while(lo<hi&&nums[hi]==nums[hi-1]){
            							hi--;
            						}
            						lo++;	
            						hi--;
            					}
    					}
    				}
    				
    			}
    		}
    	}
    	return result;	
    }
    
    public int remove2Duplicates(int[] nums){
    	int i=0;
    	for(int n:nums){
    		if(i<2||n>nums[i-2]){
    			nums[i++] = n;
    		}
    	}
    	return i;
    }
    
    public int[] productExceptSelf(int[] nums){
    	int prod = 1;
    	int[] result = new int[nums.length];
    	int count0=0;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]!=0)
    		prod*=nums[i];
    		else count0++;
    	}
    	if(count0==nums.length){
    		return result;
    	}
    	
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==0&&count0==1){
    			result[i] = prod;
    		}else if(nums[i]==0&&count0>1){
    			result[i] = 0;
    		}else if(nums[i]!=0&&count0!=0){
    			result[i] = 0;
    		}else{
    			result[i] = prod/nums[i];
    		}
    	}
    	for(int n:result){
    		System.out.println(n);
    	}
    	return result;
    }
    
    public List<Integer> majority3Element(int[] nums){
    	//1,2
    	List<Integer> resul = new ArrayList<Integer>();
    	if(nums==null||nums.length==0) return resul;
    	if(nums.length==1){
    		resul.add(nums[0]);
    		return resul;
    	}
    	int m1 = nums[0];
    	int m2 = 0;
    	
    	int c1 = 1;
    	int c2 = 0;
    	
    	for(int i=1;i<nums.length;i++){
    		int x = nums[i];
    		if(x==m1) c1++;
    		else if(x == m2) c2++;
    		else if(c1==0){
    			m1 = x;
    			c1++;
    		}else if(c2==0){
    			m2 = x;
    			c2++;
    		}else{
    			c1--;
    			c2--;
    		}
    	}
    	
    	c1 = 0; c2 = 0;
    	for(int i=0;i<nums.length;i++){
    		if(m1==nums[i]) c1++;
    		else if(m2 == nums[i] ) c2++;
    	}
    	if(c1>nums.length/3) resul.add(m1);
    	if(c2>nums.length/3) resul.add(m2);
    	
    	return resul;
    	
    	
    }
    
    public int majorityElement4(int[] nums){
    	int cnt = 0;
    	int majority=0;
    	for(int i=0;i<nums.length;i++){
    		if(cnt==0){
    			majority = nums[i];
    			cnt++;
    		}else{
    			cnt= nums[i]== majority ? cnt++ : cnt --;
        		if(cnt>nums.length/2) return majority;
    		}

    	}
    	return majority;
    }
    
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k){
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	ArrayList<Integer> temp = new ArrayList<Integer>();
    	
    	subCombine(result, temp, n, k, 0);
    	return result;
    }
    
    private void subCombine(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int n, int k,int level ){
    	
    	if(temp.size() == k){
    		result.add(new ArrayList<Integer>(temp));
    		return;
    	}
    	
    	for(int i=level;i<n;i++){
    		temp.add(i+1);
    		
    		subCombine(result,temp,n,k,i+1);
    		
    		temp.remove(temp.size()-1);
    	}
    }
    
    public List<List<Integer>> subsets(int[] nums){
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> subset = new ArrayList<Integer>();
    	res.add(subset);

    	Arrays.sort(nums);
    	doSubsets(nums,res,subset,0);
    	return res;
    	
    }
    
    private void doSubsets(int[] nums, List<List<Integer>> resu, List<Integer> subset , int start){
    	if(start!=nums.length){
    		for(int i = start; i<nums.length;i++){
    			subset.add(nums[i]);
    			resu.add(new ArrayList<Integer>(subset));
    			doSubsets(nums,resu,subset,i+1);
    			subset.remove(subset.get(subset.size()-1));
    		}
    	}
    } 
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
    	Arrays.sort(candidates);
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	dfs_com(res,list,candidates,0,target);
    	return res;
    }
    
    private void dfs_com(List<List<Integer>> res, List<Integer> list, 
    		int[] candi, int level, int target){
    	if(target==0){
    		res.add(new ArrayList(list));
    		return;
    	}
    	if(target < 0) return;
    	for(int i=level; i<candi.length;i++){
    		if(i > level && candi[i] == candi[i-1]) continue;
    		list.add(candi[i]);
    		dfs_com(res,list,candi,i+1,target-candi[i]);
    		list.remove(list.size()-1);
    	}
    }
    
    public List<List<Integer>> combinationSum22(int[] candidates, int target){
    	Arrays.sort(candidates);
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	
    	combiSum(candidates, res, list, target, 0);
    	return res;
    	
    }
    
    private void combiSum(int[] candi, List<List<Integer>> res, List<Integer> list,int target, int level){
    	if(target<0) return;
    	if(target==0){
    		res.add(new ArrayList(res));
    		return;
    	}
    	for(int i = level;i<candi.length;i++){
    		if(i==level||candi[i]!=candi[i-1]){
    			list.add(candi[i]);
    			combiSum(candi, res, list, target-candi[i], i+1);
    			list.remove(list.size()-1);
    		}
    	}
    }
    
    public List<List<Integer>> combinationSum3(int k, int n){
    	int[] nums = new int[9];
    	for(int i = 1; i<10;i++){
    		nums[i-1] = i; 
    	}
    	
    	List<List<Integer>> res=  new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	
    	combiSum3(res, list, nums, n, k, 0 );
    	return res;
    }
    
    private void combiSum3(List<List<Integer>> res, List<Integer> list,
    		int[] nums, int n, int k ,int level){
    	if(list.size()==k){
    		if(n==0){
    			res.add(new ArrayList(list));
    		}
    		return;
    	}
    	for(int i = level; i<nums.length;i++){
    		list.add(nums[i]);
    		combiSum3(res, list, nums, n-nums[i], k,i+1);
    		list.remove(list.size()-1);
    	}
    	
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target){
    	Arrays.sort(candidates);
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	
    	combiSum(res, list, candidates, target, 0);
    	return res;
    }
    
    private void combiSum(List<List<Integer>> res, List<Integer> list,
    		int[] nums, int target, int level){
    	if(target==0){
    		res.add(new ArrayList(list));
    		return;
    	}
    	if(target<0){
    		return;
    	}
    	for(int i=level; i< nums.length;i++){
    		list.add(nums[i]);
    		combiSum(res, list, nums, target-nums[i],i);
    		list.remove(list.size()-1);
    	}
    }
    
    public List<String> generateParenthesis(int n){
    	List<String> res=new ArrayList<String>();

    	generate(res, "",n,n);
    	return res;
    	
    }
    
    private void generate(List<String> res, String str, 
    		int left, int right){
    	if(left>right){
    		return;
    	}

    	if(left>0){
        	generate(res,str+"(",left-1,right);
    	}
    	if(right>0){
        	generate(res,str+")",left,right-1);
    	}
    	
    	if(right == 0 && left ==0){
    		res.add(str); 
    		return;
    	}

   }

	public List<String> generateParenthesis2(int n){
		List<String> res = new ArrayList<String>();
		generate2(res,"",0,0,n);
		return res; 

    }
	
	private void generate2(List<String> res, String str, int left, int right,int n){
		if(right>left){
			return ;
		}
		if(left<n){
			generate2(res,str+"(",left+1,right,n);
		}
		if(right<n){
			generate2(res,str+")",left,right+1,n);
		}
		if(left==n&&right==n){
			res.add(str);
			return;
		}
	}

	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		genePermu(res, nums,0);
		return res;
	}
	
	private void genePermu(List<List<Integer>> res, 
			int[] nums, int level){
		if(level==nums.length){
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<nums.length;i++){
				list.add(nums[i]);
			}
			res.add(list);
			return;
 		}
		
		for(int i = level;i<nums.length;i++){
			int temp = nums[i];
			nums[i] = nums[level];
			nums[level] = temp;
			
			genePermu(res,nums,level+1);
			
			temp = nums[level];
			nums[level] = nums[i];
			nums[i] = temp;
		}
	}
	
	public List<List<Integer>> permuteUnique(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		genePermuUni(res, nums, 0);
		return res;
	}
	
	private void genePermuUni(List<List<Integer>> res, int[] nums, int level){
		if(level==nums.length){
			List<Integer> list = new ArrayList<Integer>();
			for(int x:nums){
				list.add(x);
			}
			res.add(list);
			return;
		}
		
		for(int i = level; i < nums.length;i++){
			if(i==level||nums[level]!=nums[i]){
				int temp = 0;
				temp = nums[i];
				nums[i] = nums[level];
				nums[level] = temp;
				
				genePermuUni(res, nums, level+1);
				
				temp = nums[level];
				nums[level] = nums[i];
				nums[i] = temp;
			}
		}
	}
	
	public List<List<Integer>> permuteUnique2(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		genePermuUni2(res,list,nums,0);
		System.out.println(res.size());
		return res;
	}
	
	private void genePermuUni2(List<List<Integer>> res,List<Integer> list, int[] nums, int level){
		if(list.size()==nums.length){
			if(!res.contains(list))
				res.add(new ArrayList(list));
			return;
		}
		
		List<Integer> l = new ArrayList<Integer>();
		
		for(int i = level; i < nums.length;i++){
			if(!l.contains(nums[i])){
				l.add(nums[i]);
				list.add(nums[i]);
				int temp = 0;
				temp = nums[i];
				nums[i] = nums[level];
				nums[level] = temp;
				
				genePermuUni2(res,list, nums, level+1);
				temp = nums[level];
				nums[level] = nums[i];
				nums[i] = temp;
				list.remove(list.size()-1);

			}
		}
	}

    
    public String getPermutation(int n, int k){
    	StringBuilder sb = new StringBuilder();
    	List<String> list  = new ArrayList<String>();
    	for(int i = 1;i <= n;i++){
    		sb.append(i);
    	}
    	getpermuk(sb,list,k,0);
    	String[] res = list.toArray(new String[0]);
    	Arrays.sort(res);
    	
//    	System.out.println(res);
//    	for(int i=0;i<res.length;i++)
//    		System.out.println(res[i]);
//    	System.out.println(list);
    	return res[k-1];
    }
    
    private void getpermuk(StringBuilder sb,List<String> list,int k, int level){
    	if( sb.length() == level ){
    		list.add(sb.toString());
    		return;
    	}
    	
    	for( int i = level; i<sb.length();i++){
    		if(list.size()==k){
    			return;
    		}
    		
    		String temp = sb.substring(i, i+1);
    		sb.replace(i, i+1, sb.substring(level, level+1));
    		sb.replace(level, level+1, temp);

    		getpermuk(sb, list, k,level+1);

    		
    		temp = sb.substring(i, i+1);
    		sb.replace(i, i+1, sb.substring(level, level+1));
    		sb.replace(level, level+1, temp);
    		
    	}
    }
    
    public String getPermutation2( int n, int k){
    	int[] facts = new int[10];
    	facts[1] = 1;
    	for(int i = 2;i<=9;i++){
    		facts[i] = facts[i-1]*i;
    	}
    	
    	StringBuilder s = new StringBuilder();
    	List<Integer> digits = new ArrayList<Integer>();
    	
    	for(int i = 1;i<=n;i++){
    		digits.add(i);
    	}

    	k = k - 1;
    	
    	while(k>0&&digits.size()>1){
    		int segmentLength = facts[digits.size()-1];
    		int index = k/segmentLength;
    		k = k%segmentLength;
    		s.append(digits.remove(index));
    	}
    	for(int i:digits){
    		s.append(i);
    	}
    	return s.toString();
    	
    }
    
    public List<Integer> grayCode(int n){
    	if(n==0){
    		List<Integer> a = new ArrayList<Integer>();
    		a.add(0);
    		return a;
    	}
    	
    	List<Integer> last_r = grayCode(n-1);
    	
    	List<Integer> res = new ArrayList<Integer>(last_r);
    	for(int i = last_r.size()-1;i>=0;i--){
    		int cur = last_r.get(i) + (int)Math.pow(2,n-1);
    		res.add(cur);
    	}
    	
    	return res;
    }
    
    public boolean exist(char[][] board, String word){
    	
    	if(word.length()==0){
    		return false;
    	}
    	boolean[][] visited = new boolean[board.length][board[0].length];;
    	for(int i = 0;i<board.length;i++){
    		for(int j = 0; j<board[0].length;j++){
    			visited[i][j] = false;
    		}
    	}
    	for(int i = 0; i < board.length;i++){
    		for(int j = 0; j < board[0].length;j++){
    			if(board[i][j] == word.charAt(0)){
    				visited[i][j] = true;
    				if(sear(board,word.substring(1),i,j,visited)){
    					return true;
    				}
    				visited[i][j] = false;
    			}
    		}
    	}
    	return false;
    }
    
    private boolean sear(char[][] board, String str,int i, int j, boolean[][] visited){
    	if(str.length()==0){
    		return true;
    	}
    	System.out.println(i+"?"+j);
    	int[][] dirc = {{-1,0},{1,0},{0,-1},{0,1}};
    	
    	for(int k=0;k<dirc.length;k++){
    		int ii = i+dirc[k][0];
    		int jj = j+dirc[k][1];
    		if(ii>=0&&ii<board.length&&jj>=0&&jj<board[0].length
    				&&board[ii][jj]==str.charAt(0)&&visited[ii][jj]==false){
    			visited[ii][jj] = true;
    			if(str.length()==1||sear(board,str.substring(1),ii,jj,visited)){
    				return true;
    			}
    			visited[ii][jj] = false;
    		}
    	}
    	
    	return false;

    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums){
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	res.add(new ArrayList<Integer>(list));
    	Arrays.sort(nums);
    	getsets(res,list,nums,0);
    	return res;
    }
    
    private void getsets(List<List<Integer>> res,List<Integer> list,int[] nums, int level){
    	if(level!=nums.length){
    		for(int i = level;i<nums.length;i++){
    			list.add(nums[i]);
    			if(!res.contains(list)){
        			res.add(new ArrayList<Integer>(list));
    			}
    			getsets(res, list, nums, i+1);
    			list.remove(list.get(list.size()-1));
    		}
    	}
    }
    
    public List<List<String>> partition(String s){
    	List<List<String>> res = new ArrayList<List<String>>();
    	List<String> list = new ArrayList<String>();
    	palPar(res,list,s);
    	return res;
    }
    
    
    private void palPar(List<List<String>> res, List<String> list,
    		String str){
    	if(str.length()==0){
    		res.add(new ArrayList<String>(list));
    		return;
    	}
    	
    	for(int i = 0; i<str.length();i++){
    		if(isPal(str.substring(0,i+1))){
    			list.add(str.substring(0,i+1));
    			palPar(res,list,str.substring(i+1));
    			list.remove(list.size()-1);
    		}
    	}
    	
    }
    
    private boolean isPal(String str){
    	StringBuilder strb = new StringBuilder(str);
     	return strb.toString().equals(strb.reverse().toString());
    }
    
    public List<String> LetterCombinations(String digits){
    	
    	if(digits.equals("")){
    		return new ArrayList<String>();
    	}
    	
    	
    	StringBuilder dig = new StringBuilder(digits);
    	int oc = 0;
    	while((oc = dig.indexOf(""+'*'))!=-1){
    		dig.deleteCharAt(oc);
    	}
    	while((oc = dig.indexOf(""+'#'))!=-1){
    		dig.deleteCharAt(oc);
    	}
    	while((oc = dig.indexOf(""+'0'))!=-1){
    		dig.deleteCharAt(oc);
    	}
    	while((oc = dig.indexOf(""+'1'))!=-1){
    		dig.deleteCharAt(oc);
    	}
    	digits = dig.toString();
    	if(digits.equals("")){
    		return new ArrayList<String>();
    	}
    	List<List<Character>> dic = new ArrayList<List<Character>>();
    	for(int i = 0;i<2;i++){
        	dic.add(new ArrayList<Character>());	
    	}

    	for(int i = 1;i<6;i++){
    		List<Character> temp = new ArrayList<Character>();
    		int start = 93+3*i;
    		for(int j = 1;j<4;j++){
    			temp.add((char)(start+j));
    		}
    		dic.add(temp);		
    	}
    	
    	List<Character> temp = new ArrayList<Character>();
    	temp.add((char)(112));
    	temp.add((char)(113));
    	temp.add((char)(114));
    	temp.add((char)(115));
    	dic.add(temp);
    	temp = new ArrayList<Character>();
    	temp.add((char)(116));
    	temp.add((char)(117));
    	temp.add((char)(118));
    	dic.add(temp);
    	temp = new ArrayList<Character>();
    	temp.add((char)(119));
    	temp.add((char)(120));
    	temp.add((char)(121));
    	temp.add((char)(122));
    	dic.add(temp);
    	List<String> res = new ArrayList<String>();
//    	List<String> list = new ArrayList<String>();
    	StringBuilder list = new StringBuilder();
    	letterComb(res,list,dic,0,digits);
    	return res;
    }
    
    private void letterComb(List<String> res, StringBuilder list,
    		List<List<Character>> dic, int level,String dig){
    	if(level==dig.length()){
    		res.add(list.toString());
    		return;
    	}
    	

    	
		int temp = Integer.parseInt(dig.substring(level,level+1));
		if(2<=temp&&temp<=9){
			for(int i = 0; i < dic.get(temp).size();i++){
				list.append(""+dic.get(temp).get(i));;
				letterComb(res,list,dic,level+1,dig);
				list.deleteCharAt(list.length()-1);
			}
		}
    	
    	
    }
    
    
    public  List<String> restoreIpAddresses(String s) {
    	List<String> res = new ArrayList<>();
    	List<String> list = new ArrayList<>();
    	if(s.length()>12||s.length()<4){
    		return res;
    	}
    	restore(res,list, s,0);
		
    	return res;
	}
    
    private void  restore(List<String> res, List<String> list,
    		String s,int level) {
    	if (level == 3) {
    		if(validIp(s)){
        		list.add(s);
        		StringBuilder sbd = new StringBuilder();
        		for(String st:list){
        			sbd.append(st);
        			sbd.append(".");
        		}
        		list.remove(list.size()-1);
        		sbd.deleteCharAt(sbd.length()-1);
        		res.add(sbd.toString());
        		return;
    		}
		}
    	
    	for(int i = 0; i< s.length();i++){
    		if(validIp(s.substring(0,i))){
    			list.add(s.substring(0,i));
    			restore(res, list, s.substring(i), level+1);
    			list.remove(list.size()-1);
    		}
    	}
    	
	}
    
    private boolean validIp(String str) {
    	if(str.length()==0||str.length()>3){
    		return false;
    	}
    	if(str.charAt(0)=='0'&&str.length()!=1) return false;
    	if(str.length()<3) return true;
		int r2 = str.compareTo("255");
		return (r2<=0);
	}
    
    public void sortColors(int[] nums){
    	int r = 0;
    	int w = 0;
    	int b = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0) r++;
			if(nums[i]==1) w++;
			if(nums[i]==2) b++;
		}
    	for(int i = 0; i<r;i++){
    		nums[i]=0;
    	}
    	for(int i = r;i<r+w;i++){
    		nums[i] = 1;
    	}
    	for(int i = r + w; i < nums.length; i++){
    		nums[i] = 2;
    	}
    	
    	for(int i = 0;i<nums.length;i++){
    		System.out.println(nums[i]);
    	}
    }
    
    public void nextPermutation(int[] nums){
    	int index = -1;
    	for(int i = (nums.length-1);i>0;i--){
    		if(nums[i]>nums[i-1]){
    			index = i-1;
    			break;
    		}
    	}
    	if (index == -1) {
    		Arrays.sort(nums);
    		return;
		}
    	int index2 = -1;
    	for(int i = nums.length-1;i>0;i--){
    		if(nums[i]>nums[index]){
    			index2 = i;
    			break;
    		}
    	}
    	int temp = nums[index];
    	nums[index] = nums[index2];
    	nums[index2] = temp;
    	
    	reverse(nums, index);
    	
    }
    
    private void reverse(int[] nums, int index){
    	for(int i = nums.length-1,j = index+1;i>j;i--,j++){
    		int temp = nums[i];
    		nums[i] = nums[j];
    		nums[j] = temp;
    	}
    }
    
    public void moveZeros(int[] nums){
    	int head = 0;

    	for(int i = 0;i<nums.length;i++){
    		if(nums[i]==0){
    			for(int j = i;j<nums.length;j++){
    				if(nums[j]!=0){
    					head = j;
    					break;
    				}
    			}
    			if(head!=0){
        			int temp = nums[i];
        			nums[i] = nums[head];
        			nums[head] = temp;
    			}

    		}
    	}
    }
    
    public int uniquePaths2(int m, int n){
    	int[][] res = new int[m][n];
    	
    	for(int i = 0; i < n;i++){
    		res[m-1][i] = 1;
    	}
    	for(int i = 0; i < m;i++){
    		res[i][n-1] = 1;
    	}
    	for(int i = m-2; i >=0;i--){
    		for(int j = n-2; j >=0; j--){
    			res[i][j] = res[i+1][j] + res[i][j+1];
    		}
    	}
    	return res[0][0];
    	
    }
    
    public int uniquePathWithObstacles(int [][] obstacleGrid){
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	
    	if(m==1||n==1){
    		int sum = 0;
    		for(int[] num : obstacleGrid){
    			for(int num1:num){
    				sum +=num1;
    			}
    		}
    		if(sum==0){
    			return 1;
    		}else{
    			return 0;
    		}
    	}
    	
    	if(obstacleGrid[0][0] ==1 ||obstacleGrid[m-1][n-1]==1){
    		return 0;
    	}
    	
    	int[][] res = new int[m][n];
    	int index = n-1;
    	while(index>=0&&obstacleGrid[m-1][index]!=1){
    		res[m-1][index--] = 1;
    	}
    	while(index>=0){
    		res[m-1][index--] = 0;
    	}
    	index = m-1;
    	while(index >=0&&obstacleGrid[index][n-1]!=1){
    		res[index--][n-1] = 1;
    	}
    	while(index>=0){
    		res[index--][n-1] = 0;
    	}
    	
    	for(int i = m-2; i >=0;i--){
    		for(int j = n-2; j >=0; j--){
    			if(obstacleGrid[i][j]==1){
    				res[i][j] = 0;
    			}else	res[i][j] = res[i+1][j] + res[i][j+1];
    		}
    	}
    	for(int i = 0;i<m;i++){
    		for(int j = 0; j<n;j++){
    			System.out.println(res[i][j]);
    		}
    	}
    	return res[0][0];
    	
    }
    
    
    
    
    
       
}

	