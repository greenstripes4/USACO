import java.io.*;
import java.util.*;

public class Main {
    private static boolean compatible(int n, int[] first, int[] second) {
        return Math.max(Math.min(first[0], second[0]), Math.min(first[1], second[1])) >= n;
    }
    private static ArrayList<String> getSegments(char[] a, char tar) {
        ArrayList<String> segments = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int left = a.length/2;
        int i;
        for(i = 0; i < a.length && left > 0; i++) {
            if(a[i] == tar) {
                segments.add(sb.toString());
                sb = new StringBuilder();
                left--;
            } else {
                sb.append(a[i]);
            }
        }
        for(; i < a.length; i++) {
            sb.append(a[i]);
        }
        segments.add(sb.toString());
        return segments;
    }
    private static String solve(char[] a, char[] b, int[] first, int[] second) {
        if(Math.min(first[0], second[0]) > Math.min(first[1], second[1])) {
            ArrayList<String> segments1 = getSegments(a, '0');
            ArrayList<String> segments2 = getSegments(b, '0');
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < a.length/2; i++) {
                res.append(segments1.get(i));
                res.append(segments2.get(i));
                res.append(0);
            }
            res.append(segments1.get(segments1.size()-1));
            res.append(segments2.get(segments2.size()-1));
            return res.toString();
        } else {
            ArrayList<String> segments1 = getSegments(a, '1');
            ArrayList<String> segments2 = getSegments(b, '1');
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < a.length/2; i++) {
                res.append(segments1.get(i));
                res.append(segments2.get(i));
                res.append(1);
            }
            res.append(segments1.get(segments1.size()-1));
            res.append(segments2.get(segments2.size()-1));
            return res.toString();
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            char[] a = f.readLine().toCharArray();
            char[] b = f.readLine().toCharArray();
            char[] c = f.readLine().toCharArray();
            int[] first = new int[2];
            int[] second = new int[2];
            int[] third = new int[2];
            for(int i = 0; i < 2*n; i++) {
                first[a[i]-'0']++;
                second[b[i]-'0']++;
                third[c[i]-'0']++;
            }
            if(compatible(n, first, second)) {
                out.println(solve(a, b, first, second));
            } else if(compatible(n, first, third)) {
                out.println(solve(a, c, first, third));
            } else {
                out.println(solve(b, c, second, third));
            }
        }
        f.close();
        out.close();
    }
}
