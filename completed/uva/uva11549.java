import sun.awt.image.ImageWatched;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long t = f.nextLong();
        for(long i = 0; i < t; i++){
            int n = f.nextInt();
            long k = f.nextLong();
            HashSet<Long> seen = new HashSet<>();
            long max = k;
            while(!seen.contains(k)){
                seen.add(k);
                String temp = Long.toString(k*k);
                k = Long.parseLong(temp.substring(0,Math.min(n,temp.length())));
                max = Math.max(max,k);
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}
