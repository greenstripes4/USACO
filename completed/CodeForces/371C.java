import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] ingredients = f.readLine().toCharArray();
        int[] frequencies = new int[3];
        for(char i: ingredients) {
            if(i == 'B') {
                frequencies[0]++;
            } else if(i == 'S') {
                frequencies[1]++;
            } else {
                frequencies[2]++;
            }
        }
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] n = new int[3];
        n[0] = Integer.parseInt(st.nextToken());
        n[1] = Integer.parseInt(st.nextToken());
        n[2] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] p = new int[3];
        p[0] = Integer.parseInt(st.nextToken());
        p[1] = Integer.parseInt(st.nextToken());
        p[2] = Integer.parseInt(st.nextToken());
        long r = Long.parseLong(f.readLine());
        long low = 0;
        long high = (long) (Math.pow(10, 12)+100);
        long ans = 0;
        while(low <= high) {
            long mid = (low+high)/2;
            long price = 0;
            for(int i = 0; i < 3; i++) {
                price += Math.max(0, frequencies[i]*mid-n[i])*p[i];
            }
            if(price <= r) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}