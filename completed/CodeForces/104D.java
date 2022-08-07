import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        long next = Math.max(0, k-n/2);
        for(int i = 0; i < p; i++) {
            long x = Long.parseLong(f.readLine());
            if(k == 0) {
                out.print('.');
            } else if(k == 1) {
                if(x == n) {
                    out.print('X');
                } else {
                    out.print('.');
                }
            } else {
                long t1 = n-2*(k-1);
                long t2 = n-(1+(next-1)*2);
                if(n%2 == 1) {
                    if(x == n) {
                        out.print('X');
                    } else {
                        if(x < t1) {
                            out.print('.');
                        } else if((x-t1)%2 == 1) {
                            out.print('X');
                        } else if (x >= t2) {
                            out.print('X');
                        } else {
                            out.print('.');
                        }
                    }
                } else {
                    if((x-t1) < 0) {
                        out.print('.');
                    } else if ((x-t1)%2 == 0) {
                        out.print('X');
                    } else if (x >= t2) {
                        out.print('X');
                    } else {
                        out.print('.');
                    }
                }
            }
        }
        out.println();
        f.close();
        out.close();
    }
}