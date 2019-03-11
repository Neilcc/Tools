package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestFeature {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator i = list.iterator();
        while(i.hasNext()){
            Integer ii = (Integer) i.next();
            list.remove(ii);
//            i.remove();
        }
//        for (Integer ii : list) {
//            list.remove(ii);
//        }

//        int[] a1 = new int[]{1, 2, 3};
//        int[] a2 = new int[]{4, 5, 6};
//        int[] ii = new int[]{0, 1, 2};
//        Integer[] aa = new Integer[]{1, 2, 3};
//        System.out.print("a2: \n");
//        for (int i : ii) {
//            System.out.print(a2[i]);
//            System.out.print("\t");
//        }
//        System.out.print("\n a1: \n");
//        for (int i : ii) {
//            System.out.print(aa[i]);
//            System.out.print("\t");
//        }
//        System.out.print("\n\n swap \n\n");
//        int[] tt = a1;
//        a1 = a2;
//        a2 = tt;
//        System.out.print("a2: \n");
//        for (int i : ii) {
//            System.out.print(a2[i]);
//            System.out.print("\t");
//        }
//        System.out.print("\n a1: \n");
//        for (int i : ii) {
//            System.out.print(a1[i]);
//            System.out.print("\t");
//        }
//
//        System.out.print("\n\n change a1[0] \n\n");
//        change(a1);
//        System.out.print("\n a1: \n");
//        for (int i : ii) {
//            System.out.print(a1[i]);
//            System.out.print("\t");
//        }
//        int jj = 12;
//        change2(jj);
//        System.out.print("\n\n");
//        System.out.print(jj);

    }

    public static void change(int[] aa) {
        aa[0] = 66666;
    }

    public static void change2(int i) {
        i++;
    }

    public class testa {
        public void doa() {
            final Object temp = new Object();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.print(temp.toString());
                }
            };
            runnable.run();
        }
    }
}
