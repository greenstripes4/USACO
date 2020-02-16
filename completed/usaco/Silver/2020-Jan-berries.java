/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("berries.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        StringTokenizer trees = new StringTokenizer(f.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(trees.nextToken());
        }
        Arrays.sort(arr);
        int[] needed;
        if(K <= N) {
            needed = Arrays.copyOfRange(arr, arr.length - K, arr.length);
        } else {
            needed = new int[K];
            for(int i = 0; i < N; i++){
                needed[i] = arr[i];
            }
        }
        Arrays.sort(needed);
        int total = 0;
        for(int i = 0; i < needed.length; i++){
            total += needed[i];
        }
        int max = 0;
        int average = (int) Math.ceil((double) total/K);
        for(int i = average; i > 0; i--){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j: needed){
                if(j > i){
                    while(j >= i){
                        temp.add(i);
                        j -= i;
                    }
                    if(j > 0){
                        temp.add(j);
                    }
                } else {
                    temp.add(j);
                }
            }
            Collections.sort(temp);
            int res = 0;
            for(int j = temp.size()-K; j < temp.size()-K/2; j++){
                res += temp.get(j);
            }
            max = Math.max(res,max);
        }
        out.println(max);
        out.close();
        f.close();
    }
}
