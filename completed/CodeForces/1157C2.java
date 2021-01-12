import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0;
        int r = n-1;
        StringBuilder sb = new StringBuilder();
        int last = 0;
        while(l <= r) {
            if(a[l] <= last && a[r] <= last) {
                break;
            }
            if(a[l] > last && a[r] > last) {
                if(a[l] < a[r]) {
                    sb.append('L');
                    last = a[l++];
                } else if(a[r] < a[l]) {
                    sb.append('R');
                    last = a[r--];
                } else {
                    int lL = 1;
                    int lR = 1;
                    while(l+lL <= r && a[l+lL] > a[l+lL-1]) {
                        lL++;
                    }
                    while(r-lR >= l && a[r-lR] > a[r-lR+1]) {
                        lR++;
                    }
                    if(lL < lR) {
                        for(int i = 0; i < lR; i++) {
                            sb.append('R');
                        }
                    } else {
                        for(int i = 0; i < lL; i++) {
                            sb.append('L');
                        }
                    }
                    break;
                }
            } else if(a[l] > last) {
                sb.append('L');
                last = a[l++];
            } else {
                sb.append('R');
                last = a[r--];
            }
        }
        out.println(sb.length());
        out.println(sb);
        f.close();
        out.close();
    }
}
