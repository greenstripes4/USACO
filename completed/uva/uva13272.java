import java.io.*;
import java.util.*;

public class Main {
    private static char getConjugate(char c) {
        if(c == ')') {
            return '(';
        }
        if(c == '}') {
            return '{';
        }
        if(c == ']') {
            return '[';
        }
        if(c == '>') {
            return '<';
        }
        return ' ';
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            char[] arr = f.readLine().toCharArray();
            int[] res = new int[arr.length];
            res[arr.length-1] = 0;
            for(int i = arr.length-2; i >= 0; i--) {
                if(i+res[i+1]+1 < arr.length && arr[i] == getConjugate(arr[i+res[i+1]+1])) {
                    res[i] = res[i+1]+2+(i+res[i+1]+2 < arr.length ? res[i+res[i+1]+2] : 0);
                } else {
                    res[i] = 0;
                }
            }
            out.println("Case " + t + ":");
            for(int i: res) {
                out.println(i);
            }
        }
        f.close();
        out.close();
    }
}
