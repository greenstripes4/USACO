import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(f.readLine());
        }
        StringBuilder res = new StringBuilder();
        while(sb.length() > 0) {
            char[] forward = sb.toString().toCharArray();
            char[] backward = new char[forward.length];
            for(int i = 0; i < forward.length; i++) {
                backward[i] = forward[forward.length-i-1];
            }
            String a = new String(forward);
            String b = new String(backward);
            if(a.compareTo(b) < 0) {
                res.append(sb.charAt(0));
                sb.deleteCharAt(0);
            } else {
                res.append(sb.charAt(sb.length()-1));
                sb.deleteCharAt(sb.length()-1);
            }
        }
        int idx = 0;
        while(idx < res.length()) {
            if(idx%80 == 0 && idx > 0) {
                out.println();
            }
            out.print(res.charAt(idx++));
        }
        out.println();
        f.close();
        out.close();
    }
}