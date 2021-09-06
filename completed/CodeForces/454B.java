import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int i = 1;
        while(i < n && a[i] >= a[i-1]) {
            i++;
        }
        boolean flag = false;
        for(int j = i+1; j < n; j++) {
            if(a[j] < a[j-1]) {
                flag = true;
                break;
            }
        }
        if(i < n && a[n-1] > a[0]) {
            flag = true;
        }
        out.println(flag ? -1 : n-i);
        f.close();
        out.close();
    }
}