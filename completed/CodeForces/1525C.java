import java.io.*;
import java.util.*;

public class Main {
    private static class Cow implements Comparable<Cow> {
        private int pos;
        private int dir;
        private int idx;
        private Cow() {}
        @Override
        public int compareTo(Cow o) {
            return pos-o.pos;
        }
    }
    private static int m;
    private static int[] res;
    private static void solve(ArrayList<Cow> cows) {
        Collections.sort(cows);
        Stack<Cow> right = new Stack<>();
        Cow left = null;
        for(Cow i: cows) {
            if(i.dir == 1) {
                right.push(i);
            } else {
                if(right.isEmpty()) {
                    if(left == null) {
                        left = i;
                    } else {
                        res[i.idx] = res[left.idx] = (i.pos+left.pos)/2;
                        left = null;
                    }
                } else {
                    Cow j = right.pop();
                    res[i.idx] = res[j.idx] = (i.pos-j.pos)/2;
                }
            }
        }
        while(right.size() > 1) {
            Cow i = right.pop();
            Cow j = right.pop();
            res[i.idx] = res[j.idx] = m-(i.pos+j.pos)/2;
        }
        if(!right.isEmpty() && left != null) {
            Cow i = right.pop();
            res[i.idx] = res[left.idx] = m-(i.pos-left.pos)/2;
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            Cow[] cows = new Cow[n];
            for(int i = 0; i < n; i++) {
                cows[i] = new Cow();
                cows[i].pos = Integer.parseInt(st.nextToken());
                cows[i].idx = i;
            }
            st = new StringTokenizer(f.readLine());
            ArrayList<Cow> even = new ArrayList<>();
            ArrayList<Cow> odd = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                cows[i].dir = st.nextToken().charAt(0) == 'L' ? -1 : 1;
                if(cows[i].pos%2 == 0) {
                    even.add(cows[i]);
                } else {
                    odd.add(cows[i]);
                }
            }
            res = new int[n];
            Arrays.fill(res, -1);
            solve(even);
            solve(odd);
            out.print(res[0]);
            for(int i = 1; i < n; i++) {
                out.print(" " + res[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
