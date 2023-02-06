/*
ID: strongh2
LANG: JAVA
PROG: frac1
TASK: frac1
 */

import java.io.*;
import java.util.*;
public class frac1 {
    private static int gcd(int x, int y) {
        int modY = x%y;
        int modX = y%x;
        if(modY == 0) {
            return y;
        }
        if(modX == 0) {
            return x;
        }
        if(modY < modX) {
            return gcd(modY,y);
        }
        return gcd(x,modX);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        int N = Integer.parseInt(f.readLine());
        ArrayList<int[]> fractions = new ArrayList<>();
        fractions.add(new int[]{0,1});
        for(int i = 1; i <= N; i++) {
            for(int j = i; j <= N; j++) {
                if(gcd(i,j) == 1) {
                    fractions.add(new int[]{i,j});
                }
            }
        }
        Collections.sort(fractions, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                int x = ints[0]*t1[1];
                int y = ints[1]*t1[0];
                return x-y;
            }
        });
        for(int[] i: fractions) {
            out.println(i[0] + "/" + i[1]);
        }
        out.close();
        f.close();
    }
}
