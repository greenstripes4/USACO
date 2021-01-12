import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> aOnly = new ArrayList<>();
        ArrayList<Integer> bOnly = new ArrayList<>();
        ArrayList<Integer> aAndB = new ArrayList<>();
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            int ti = Integer.parseInt(st.nextToken());
            int ai = Integer.parseInt(st.nextToken());
            int bi = Integer.parseInt(st.nextToken());
            if(ai == 0 && bi == 0) {
                continue;
            }
            if(ai == 1 && bi == 0) {
                aOnly.add(ti);
                a++;
            } else if(ai == 0 && bi == 1) {
                bOnly.add(ti);
                b++;
            } else if(ai == 1 && bi == 1) {
                aAndB.add(ti);
                a++;
                b++;
            }
            c += ti;
        }
        Collections.sort(aOnly);
        Collections.sort(bOnly);
        Collections.sort(aAndB);
        int pointer1 = aOnly.size()-1;
        int pointer2 = bOnly.size()-1;
        int pointer3 = aAndB.size()-1;
        while(a > k || b > k) {
            if(a == k) {
                if(pointer2 < 0) {
                    break;
                }
                b--;
                c -= bOnly.get(pointer2--);
            } else if(b == k) {
                if(pointer1 < 0) {
                    break;
                }
                a--;
                c -= aOnly.get(pointer1--);
            } else {
                int c1 = (pointer1 < 0 ? 0 : aOnly.get(pointer1)) + (pointer2 < 0 ? 0 : bOnly.get(pointer2));
                int c2 = pointer3 < 0 ? 0 : aAndB.get(pointer3);
                if(c1 < c2) {
                    a--;
                    b--;
                    pointer3--;
                } else {
                    a -= pointer1 < 0 ? 0 : 1;
                    b -= pointer2 < 0 ? 0 : 1;
                    pointer1--;
                    pointer2--;
                }
                c -= Math.max(c1, c2);
            }
        }
        out.println(a < k || b < k ? -1 : c);
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
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> aOnly = new ArrayList<>();
        ArrayList<Integer> bOnly = new ArrayList<>();
        ArrayList<Integer> aAndB = new ArrayList<>();
        int a = 0;
        int b = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            int ti = Integer.parseInt(st.nextToken());
            int ai = Integer.parseInt(st.nextToken());
            int bi = Integer.parseInt(st.nextToken());
            if(ai == 0 && bi == 0) {
                continue;
            }
            if(ai == 1 && bi == 0) {
                aOnly.add(ti);
                a++;
            } else if(ai == 0 && bi == 1) {
                bOnly.add(ti);
                b++;
            } else if(ai == 1 && bi == 1) {
                aAndB.add(ti);
                a++;
                b++;
            }
        }
        Collections.sort(aOnly);
        Collections.sort(bOnly);
        Collections.sort(aAndB);
        if(a < k || b < k) {
            out.println(-1);
        } else {
            int c = 0;
            int index = 0;
            while(index < k) {
                if(index >= aOnly.size() || index >= bOnly.size()) {
                    c += aAndB.get(index++);
                }
            }
        }
        f.close();
        out.close();
    }
}
 */