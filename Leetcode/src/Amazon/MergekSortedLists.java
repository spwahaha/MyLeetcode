package Amazon;

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeKLists(ListNode[] lists, int start, int end){
        if(start > end){
            return null;
        }
        if(start == end){
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode l1 = mergeKLists(lists, start, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, end);
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                node.next = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        
        if(l1 == null){
            node.next = l2;
        }else{
            node.next = l1;
        }
        return dummy.next;
    }
}
