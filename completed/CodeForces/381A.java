import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int i = 0;
        int j = n-1;
        int[] score = new int[2];
        int idx = 0;
        while(i <= j) {
            if(arr[i] > arr[j]) {
                score[idx] += arr[i++];
            } else {
                score[idx] += arr[j--];
            }
            idx = (idx+1)%2;
        }
        out.println(score[0] + " " + score[1]);
        f.close();
        out.close();
    }
}