import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        Integer[] idx = new Integer[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            idx[i] = i;
        }
        Arrays.sort(idx, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return a[integer]-a[t1];
            }
        });
        int[] first = new int[n];
        int[] second = new int[n];
        int[] third = new int[n];
        int cur = 0;
        int size = 1;
        int twos = 0;
        int threes = 0;
        for(int i = 1; i < n; i++) {
            if(a[idx[i]] == a[idx[i-1]]) {
                size++;
            } else {
                if(size == 1) {
                    first[cur] = second[cur] = third[cur] = idx[i-1];
                    cur++;
                } else if(size == 2) {
                    if(twos == 0) {
                        first[cur] = second[cur] = idx[i-1];
                        third[cur] = idx[i-2];
                        cur++;
                        first[cur] = second[cur] = idx[i-2];
                        third[cur] = idx[i-1];
                        cur++;
                    } else {
                        first[cur] = third[cur] = idx[i-1];
                        second[cur] = idx[i-2];
                        cur++;
                        first[cur] = third[cur] = idx[i-2];
                        second[cur] = idx[i-1];
                        cur++;
                    }
                    twos++;
                } else {
                    for(int j = 0; j < size-3; j++) {
                        first[cur] = second[cur] = third[cur] = idx[i-j-4];
                        cur++;
                    }
                    first[cur] = second[cur] = idx[i-1];
                    third[cur] = idx[i-3];
                    cur++;
                    first[cur] = third[cur] = idx[i-2];
                    second[cur] = idx[i-3];
                    cur++;
                    first[cur] = idx[i-3];
                    second[cur] = idx[i-2];
                    third[cur] = idx[i-1];
                    cur++;
                    threes++;
                }
                size = 1;
            }
        }
        int i = n;
        if(size == 1) {
            first[cur] = second[cur] = third[cur] = idx[i-1];
        } else if(size == 2) {
            if(twos == 0) {
                first[cur] = second[cur] = idx[i-1];
                third[cur] = idx[i-2];
                cur++;
                first[cur] = second[cur] = idx[i-2];
                third[cur] = idx[i-1];
            } else {
                first[cur] = third[cur] = idx[i-1];
                second[cur] = idx[i-2];
                cur++;
                first[cur] = third[cur] = idx[i-2];
                second[cur] = idx[i-1];
            }
            twos++;
        } else {
            for(int j = 0; j < size-3; j++) {
                first[cur] = second[cur] = third[cur] = idx[i-j-4];
                cur++;
            }
            first[cur] = second[cur] = idx[i-1];
            third[cur] = idx[i-3];
            cur++;
            first[cur] = third[cur] = idx[i-2];
            second[cur] = idx[i-3];
            cur++;
            first[cur] = idx[i-3];
            second[cur] = idx[i-2];
            third[cur] = idx[i-1];
            threes++;
        }
        out.println(twos > 1 || threes > 0 ? "YES" : "NO");
        if(twos > 1 || threes > 0) {
            out.print(first[0]+1);
            for(int j = 1; j < n; j++) {
                out.print(" " + (first[j]+1));
            }
            out.println();
            out.print(second[0]+1);
            for(int j = 1; j < n; j++) {
                out.print(" " + (second[j]+1));
            }
            out.println();
            out.print(third[0]+1);
            for(int j = 1; j < n; j++) {
                out.print(" " + (third[j]+1));
            }
            out.println();
        }
        f.close();
        out.close();
    }
}