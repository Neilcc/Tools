package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.List;

public class SpechialMatrix {

    public static void main(String[] args){
        SpechialMatrix spechialMatrix = new SpechialMatrix();
        int[][] m = new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        spechialMatrix.spiralOrder(m);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null) {
            return null;
        }
        List<Integer> ret = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return ret;
        }
        int c = matrix[0].length;
        int r = matrix.length;
        int ics = 0;
        int ice = c;
        int irs = 0;
        int ire = r;
        int ic = ics;
        int ir = irs;
        while(ret.size() != c *r){
            if(ic < ice){
                for(; ic < ice && ic >=0 ; ic++){
                    ret.add(matrix[ir][ic]);
                }
                ic --;
                ir ++;
            }

            irs++;
            if(ir < ire){
                for(; ir < ire && ir>=0; ir ++){
                    ret.add(matrix[ir][ic]);
                }
                ir --;
                ic --;
            }

            ice --;
            if(ic >= ics){
                for(; ic >= ics; ic --){
                    ret.add(matrix[ir][ic]);
                }
                ic ++;
                ir --;
            }

            ire--;

            if(ir >= irs){
                for(; ir>= irs; ir --){
                    ret.add(matrix[ir][ic]);
                }
                ir ++;
                ic ++;
            }
            ics++;
        }
        return ret;
    }
}
