这里摘抄了两种算法，一种是基于对顶部节点排序的理论，对顶部节点中的最小pop link 然后在排序，这一点跟自己的思路是一致的。实现的时候，自己的难点在于没有实现好排序的结构，答案中直接给初了优先级队列，对于出队和入队的元素自动排序的数据结构，解决了这一个问题。关键是api 的使用， 自己实现compareator 这一块可能是不熟悉的。

另一种是分治的理论，这一点是不理解的，
做法是两两分块合并，最后在一起合并。形成的合并树应该是一个完全二叉树。跟从左到右合并的区别是什么？

归并的trick在于，它后面是将有序序列做合并，整体比较次数将会下降。

sorted linked lists and return it as one sorted list. Analyze and describe its complexity.



public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}



public static ListNode mergeKLists(ListNode[] lists){
    return partion(lists,0,lists.length-1);
}

public static ListNode partion(ListNode[] lists,int s,int e){
    if(s==e)  return lists[s];
    if(s<e){
        int q=(s+e)/2;
        ListNode l1=partion(lists,s,q);
        ListNode l2=partion(lists,q+1,e);
        return merge(l1,l2);
    }else
        return null;
}

//This function is from Merge Two Sorted Lists.
public static ListNode merge(ListNode l1,ListNode l2){
    if(l1==null) return l2;
    if(l2==null) return l1;
    if(l1.val<l2.val){
        l1.next=merge(l1.next,l2);
        return l1;
    }else{
        l2.next=merge(l1,l2.next);
        return l2;
    }
}
