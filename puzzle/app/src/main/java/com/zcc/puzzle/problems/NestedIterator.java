package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator {
    //[[1,2],[3],[4,5,6]]
    public static void main(String[] args) {
        List<NestedInteger> mainl = new ArrayList<>();
        List<NestedInteger> l1 = new ArrayList<>();
//        l1.add(new NestedII(1));
//        l1.add(new NestedII(2));
        List<NestedInteger> l2 = new ArrayList<>();
        l2.add(new NestedII(3));
//        List<NestedInteger> l3 = new ArrayList<>();
//        l3.add(new NestedII(4));
//        l3.add(new NestedII(5));
//        l3.add(new NestedII(6));
        mainl.add(new NesteLL(l1));
        mainl.add(new NesteLL(l2));
//        mainl.add(new NesteLL(l3));
        NestedIteratorr rr = new NestedIteratorr(mainl);
        while (rr.hasNext()) {
            int iii = rr.next();
            System.out.print(iii);
        }
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public static class NestedII implements NestedInteger {
        private Integer val;

        public NestedII(Integer val) {
            this.val = val;
        }

        @Override
        public boolean isInteger() {
            return true;
        }

        @Override
        public Integer getInteger() {
            return val;
        }

        @Override
        public List<NestedInteger> getList() {
            return null;
        }
    }

    public static class NesteLL implements NestedInteger {
        List<NestedInteger> ll;

        public NesteLL(List<NestedInteger> ll) {
            this.ll = ll;
        }

        @Override
        public boolean isInteger() {
            return false;
        }

        @Override
        public Integer getInteger() {
            return null;
        }

        @Override
        public List<NestedInteger> getList() {
            return ll;
        }
    }

    public static class NestedIteratorr implements Iterator<Integer> {

        private int p = 0;
        private List<NestedInteger> nestedList;
        private NestedIteratorr ll;

        public NestedIteratorr(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
            p = 0;
        }

        //[[1,2],[3],[4,5,6]]
        @Override
        public Integer next() {
            if (ll != null && ll.hasNext()) {
                return ll.next();
            } else {
                ll = null;
                NestedInteger ii = nestedList.get(p);
                p++;
                if (ii.isInteger()) {
                    return ii.getInteger();
                } else {
                    ll = new NestedIteratorr(ii.getList());
                    return ll.next();
                }
            }
        }

        @Override
        public void remove() {

        }

        @Override
        public boolean hasNext() {
            if (p < nestedList.size()) {
                if (ll != null && ll.hasNext()) {
                    return true;
                } else {
                    if (nestedList.get(p).isInteger()) {
                        return true;
                    } else {
                        ll = new NestedIteratorr(nestedList.get(p).getList());
                        p++;
                        return ll.hasNext() || hasNext();
                    }
                }
            } else if (ll != null && ll.hasNext()) {
                return true;
            } else {
                return false;
            }

        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
