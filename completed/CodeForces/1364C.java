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
        HashSet<Integer> invalid = new HashSet<>();
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            invalid.add(a[i]);
        }
        int[] b = new int[n];
        int temp = 0;
        while(invalid.contains(temp)) {
            temp++;
        }
        invalid.add(temp);
        b[0] = temp;
        for(int i = 1; i < n; i++) {
            if(a[i] != a[i-1]) {
                b[i] = a[i-1];
            } else {
                while(invalid.contains(temp)) {
                    temp++;
                }
                invalid.add(temp);
                b[i] = temp;
            }
        }
        out.print(b[0]);
        for(int i = 1; i < n; i++) {
            out.print(" " + b[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}