/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;
import java.util.function.LongToDoubleFunction;

public class Main{
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("loan.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(f.readLine());
        long total = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
            total += arr[i];
        }
        Arrays.sort(arr);
        long leftToRight = total;
        long rightToLeft = 0;
        int ind = N-1;
        while(ind >= 0 && leftToRight > rightToLeft){
            leftToRight -= arr[ind];
            rightToLeft += arr[ind];
            ind--;
        }
        long a = rightToLeft*2;
        ind = 0;
        leftToRight = 0;
        rightToLeft = total;
        while(ind < N && rightToLeft > leftToRight){
            leftToRight += arr[ind];
            rightToLeft -= arr[ind];
            ind++;
        }
        long b = leftToRight*2;
        out.println(arr.length%2 == 0 ? total : Math.min(a,b));
        out.close();
        f.close();
    }
}
