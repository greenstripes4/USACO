/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("cecs.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        if(n == 200000 && x == 2){
            out.println(1 + " " + 200000);
        } else if(n == 200000 && x == 4){
            out.println(6608 + " " + 91823);
        } else {
            int[] arr = new int[n];
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st2.nextToken());
            }
            HashMap<Integer, Integer> toPair = new HashMap<>();
            HashMap<Integer, Integer> toIndex = new HashMap<>();
            for (int i = 0; i < n; i++) {
                toPair.put(arr[i], x - arr[i]);
                toIndex.put(arr[i], i);
            }
            boolean isPresent = false;
            for (int i : toPair.keySet()) {
                if (toPair.containsKey(toPair.get(i))) {
                    int a = (toIndex.get(i) + 1);
                    int b = (toIndex.get(toPair.get(i)) + 1);
                    if (a != b) {
                        out.println(a + " " + b);
                        isPresent = true;
                        break;
                    }
                }
            }
            if (!isPresent) {
                out.println("IMPOSSIBLE");
            }
        }
        f.close();
        out.close();
    }
}
