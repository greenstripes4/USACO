/*
ID: strongh2
LANG: JAVA
PROG: wormhole
TASK: wormhole
*/

/*
import java.util.*;
import java.io.*;

public class wormhole {
    public static int[] x;
    public static int[] y;
    public static int N;
    public static int[] right;
    public static int[] pairs;

    public static boolean isCycle(){
        int pos;
        boolean[] allStarts = new boolean[N];
        for(int i = 0; i < N; i++){
            allStarts[i] = true;
        }
        for(int i = 0; i < N; i++){
            pos = i;
            for(int j = 0; j < N; j++){
                pos = right[pairs[pos]];
                if(pos == -1){
                    allStarts[i] = false;
                    break;
                }
            }
        }
        for(boolean i: allStarts){
            if(i){
                return true;
            }
        }
        return false;
    }

    public static int recur(){
        int ind = -1;
        int count = 0;
        for(int i = 0; i < pairs.length; i++){
            if(pairs[i] == -1){
                ind = i;
                break;
            }
        }
        if(ind == -1){
            return isCycle() ? 1:0;
            // return isCycle() ? 0:1;
        }
        for(int i = 0; i < pairs.length; i++){
            if(i != ind && pairs[i] == -1){
                pairs[ind] = i;
                pairs[i] = ind;
                count += recur();
                pairs[ind] = -1;
                pairs[i] = -1;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        N = Integer.parseInt(f.readLine());
        right = new int[N];
        for(int i = 0; i < right.length; i++){
            right[i] = -1;
        }
        pairs = new int[N];
        x = new int[N];
        y = new int[N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(y[i] == y[j]){
                    if((right[i] == -1) || (x[j] - x[i] <= x[right[i]] - x[i])){
                        if(x[j] - x[i] > 0) {
                            right[i] = j;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < pairs.length; i++){
            pairs[i] = -1;
        }
        out.println(recur());
        out.close();
        f.close();
    }
}
*/
import java.io.*;
import java.util.StringTokenizer;

public class wormhole {
    public static int[] x;
    public static int[] y;
    public static int N;
    public static int[] right;
    public static int[] pairs;
    /*
    public static boolean isCycle(){
        int pos;
        for(int i=0; i<pairs.length;i++){
            System.out.println(pairs[i]);
        }
        for(int i = 0; i < N; i++){
            pos = i;
            for(int j = 0; j < N; j++){
                pos = right[pairs[pos]];
                if(pos == -1){
                    return false;
                }
            }
        }
        return true;
    }
    */
    public static boolean isCycle(){
        int pos;
        for(int i = 0; i < N; i++){
            pos = i;
            for(int j = 0; j < N; j++){
                pos = right[pairs[pos]];
                if(pos == -1){
                    break;
                }
            }
            if(pos != -1) {
                return true;
            }
        }
        return false;
    }

    public static int recur(){
        int ind = -1;
        int count = 0;
        for(int i = 0; i < pairs.length; i++){
            if(pairs[i] == -1){
                ind = i;
                break;
            }
        }
        if(ind == -1){
            return isCycle() ? 1:0;
            // return isCycle() ? 0:1;
        }
        for(int i = 0; i < pairs.length; i++){
            if(i != ind && pairs[i] == -1){
                pairs[ind] = i;
                pairs[i] = ind;
                count += recur();
                pairs[ind] = -1;
                pairs[i] = -1;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        N = Integer.parseInt(f.readLine());
        right = new int[N];
        for(int i = 0; i < right.length; i++){
            right[i] = -1;
        }
        pairs = new int[N];
        x = new int[N];
        y = new int[N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                // if(y[i] == y[j] && ((x[j] - x[i] <= right[i] || right[i] == -1) && x[j] - x[i] > 0)){
                if(y[i] == y[j]){
                    if(x[j] > x[i]){
                        if((right[i] == -1) || x[j] < x[right[i]]){
                            right[i] = j;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < pairs.length; i++){
            pairs[i] = -1;
        }
        out.println(recur());
        out.close();
        f.close();
    }
}
