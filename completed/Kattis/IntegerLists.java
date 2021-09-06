import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            char[] s = f.readLine().toCharArray();
            int n = Integer.parseInt(f.readLine());
            String temp = f.readLine();
            String[] arr = temp.substring(1, temp.length()-1).split(",");
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            int i = 0;
            int j = n-1;
            boolean reversed = false;
            for(char k: s) {
                if(k == 'R') {
                    reversed = !reversed;
                } else {
                    if(reversed) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }
            if(i > j+1) {
                out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if(reversed) {
                    for(int k = j; k >= i; k--) {
                        sb.append(a[k]);
                        sb.append(",");
                    }
                } else {
                    for(int k = i; k <= j; k++) {
                        sb.append(a[k]);
                        sb.append(",");
                    }
                }
                if(sb.length() > 1) {
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.append("]");
                out.println(sb);
            }
        }
        f.close();
        out.close();
    }
}