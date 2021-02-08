import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        char[] colors = f.readLine().toCharArray();
        TreeSet<Character> used = new TreeSet<>();
        for(char i: colors) {
            used.add(i);
        }
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int strokes = 0;
            for(char j: used) {
                boolean seen = false;
                for(int k = 0; k < a; k++) {
                    if(colors[k] == j) {
                        seen = true;
                    } else if(colors[k] < j && seen) {
                        strokes++;
                        seen = false;
                    }
                }
                if(seen) {
                    strokes++;
                }
                seen = false;
                for(int k = b+1; k < N; k++) {
                    if(colors[k] == j) {
                        seen = true;
                    } else if(colors[k] < j && seen) {
                        strokes++;
                        seen = false;
                    }
                }
                if(seen) {
                    strokes++;
                }
            }
            out.println(strokes);
        }
        f.close();
        out.close();
    }
}
/*
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        char[] colors = f.readLine().toCharArray();
        TreeSet<Character> used = new TreeSet<>();
        for(char i: colors) {
            used.add(i);
        }
        int strokes = 0;
        HashSet<int[]> intervals = new HashSet<>();
        for(char i: used) {
            int first = -1;
            int last = -1;
            for(int j = 0; j < N; j++) {
                if(colors[j] == i) {
                    if(first == -1) {
                        first = j;
                    }
                    last = j;
                } else if(colors[j] < i && last >= 0) {
                    strokes++;
                    intervals.add(new int[]{first, last});
                    first = -1;
                    last = -1;
                }
            }
            if(last >= 0) {
                strokes++;
                intervals.add(new int[]{first, last});
            }
        }
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int temp = strokes;
            for(int[] j: intervals) {
                if(j[0] < a && j[1] > b) {
                    temp++;
                } else if(j[0] >= a && j[1] <= b) {
                    temp--;
                }
            }
            out.println(temp);
        }
        f.close();
        out.close();
    }
}
 */