package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SeatInExcam {

    public static void main (String[] args){
        ExamRoom examRoom = new ExamRoom(10);
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.leave(0);
        examRoom.leave(4);
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.leave(0);

    }
    static class ExamRoom {
        List<Integer> queue;
        int nmax;
        public ExamRoom(int N) {
            queue = new ArrayList<>();
            nmax = N;
            PriorityQueue<Integer> priorityQueue = new PriorityQueue();
            PriorityQueue<Integer> tt = new PriorityQueue<>(priorityQueue);
            tt.poll();
        }

        public int seat() {
            if(queue.size() == 0){
                queue.add(0);
                return 0;
            }
            Iterator iterator = queue.iterator();
            int pos=0;
            int max=0;
            int lastpos = -1;
            int counter = 0;
            while (iterator.hasNext()){
                int temp = (int) iterator.next();
                if(lastpos == -1){
                    int length = temp - 0;
                    if(length > max){
                        max = length;
                    }
                    pos = 0;
                }else {
                    int length = ( temp - lastpos) /2;
                    if(length > max){
                        max = length;
                        pos = lastpos +  length;

                    }
                }
                counter ++;
                lastpos = temp;
            }
            int length = nmax - 1 - lastpos;
            if(length > max){
                max =length;
                pos = nmax -1;
            }
            counter++;
            queue.add(counter,pos);
            return pos;
        }

        public void leave(int p) {
            queue.remove(Integer.valueOf(p));
        }
    }
}
