import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long[] len = new long[40001];
        long count = 0;
        long last;
        StringBuilder b = new StringBuilder();
        for (int i = 1; i < 40000; i++) {
            last = (i + "").length();
            count += last;
            len[i] = count + len[i - 1];
            b.append(i);
        }
        int n = f.nextInt();
        for (int j = 0; j < n; j++) {
            int pos = f.nextInt();
            int lo = 1, hi = 40000;
            for (int i = 0; i < 20; i++) {
                int mid = (lo + hi) / 2;
                if (len[mid] == pos) {
                    lo = mid;
                    break;
                } else if (len[mid] < pos) {
                    lo = mid;
                } else
                    hi = mid;
            }
            if (pos > len[lo]) {
                out.println(b.charAt((int) (pos - len[lo]) - 1));
            } else {
                out.println(lo);
            }
        }
    }
}
