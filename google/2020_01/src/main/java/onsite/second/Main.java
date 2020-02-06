package onsite.second;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    }

    static int lastPos(String[][] input, int startPos) {
        // Your code here!
        for(int i = 0; i < input.length; i++) {
            startPos = nextPos(input[i], startPos);
        }
        return startPos;
    }

    static int nextPos(String[] input, int startPos) {
        if(0 < startPos-1 && startPos-1 < input.length && input[startPos-1].equals("/")){
            return startPos-1;
        }
        if(startPos < input.length && input[startPos].equals("\\")) {
            return startPos+1;
        }
        return startPos;
    }

    static int minimizeMaximum(String[][] input, int maxPos, int[] balls) {
        //mapping startPos and lastPos
        int[] map = new int[maxPos];
        for(int i = 0; i < maxPos; i++) {
            map[i] = lastPos(input, i);
        }

        int max = 0;
        for(int i = 0; i < balls.length; i++) {
            max += balls[i];
        }

        int r = max;
        int l = 0;
        while(l + 1< r){
            int mid = l + (r-l)/2;
            if(helper(balls, maxPos, mid, map)){
                r = mid;
            } else {
                l = mid;
            }
        }
        return r;
    }

    static boolean helper(int[] balls, int maxPos, int maxCap, int[] map) {
        int pos = 0;
        int[] container = new int[maxPos];
        for(int i = 0; i < balls.length; i++) {
            if(maxCap < balls[i])
                return false;
            while(pos < maxPos) {
                if (container[map[pos]] + balls[i] <= maxCap) {
                    container[map[pos]] += balls[i];
                    break;
                } else
                    pos++;
            }
            if(pos == maxPos)
                return false;
        }
        return true;
    }
}