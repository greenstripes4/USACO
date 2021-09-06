import java.io.*;
import java.util.*;

public class Main {
    private static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    private static String invert(int x, int y) {
        int gcd = gcd(x, y);
        x /= gcd;
        y /= gcd;
        x = -x;
        if(y < 0) {
            x = -x;
            y = -y;
        }
        return x + " " + y;
    }
    private static String convert(int x, int y) {
        int gcd = gcd(Math.abs(x), Math.abs(y));
        x /= gcd;
        y /= gcd;
        if(x < 0) {
            x = -x;
            y = -y;
        }
        return y + " " + x;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        HashMap<String, int[]> map = new HashMap<>();
        for(int x = -a+1; x < a; x++) {
            int y = (int) Math.sqrt(a*a-x*x);
            if(y*y == a*a-x*x) {
                map.put(convert(x, y), new int[]{x, y});
                map.put(convert(x, -y), new int[]{x, -y});
            }
        }
        boolean found = false;
        for(int x = -b+1; x < b; x++) {
            int y = (int) Math.sqrt(b*b-x*x);
            if(y*y == b*b-x*x) {
                String temp = invert(x, y);
                if(map.containsKey(temp) && map.get(temp)[0] != x && map.get(temp)[1] != y) {
                    found = true;
                    out.println("YES");
                    out.println("0 0");
                    out.println(map.get(temp)[0] + " " + map.get(temp)[1]);
                    out.println(x + " " + y);
                    break;
                }
            }
        }
        if(!found) {
            out.println("NO");
        }
        f.close();
        out.close();
    }
}