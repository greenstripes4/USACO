import java.io.*;
import java.util.*;

public class Main {
    private static int check(int[] a, int i) {
        if(i <= 0 || i >= a.length-1) {
            return 0;
        }
        return (a[i-1] < a[i] && a[i] > a[i+1]) || (a[i-1] > a[i] && a[i] < a[i+1]) ? 1 : 0;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for(int j = 1; j < n-1; j++) {
                count += check(a, j);
            }
            int min = count;
            for(int j = 1; j < n-1; j++) {
                int original = check(a, j-1)+check(a, j)+check(a, j+1);
                int temp = a[j];
                a[j] = a[j-1];
                int first = check(a, j-1)+check(a, j)+check(a, j+1);
                a[j] = a[j+1];
                int second = check(a, j-1)+check(a, j)+check(a, j+1);
                min = Math.min(min, count+first-original);
                min = Math.min(min, count+second-original);
                a[j] = temp;
            }
            out.println(min);
        }
        f.close();
        out.close();
    }
}
