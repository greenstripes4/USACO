import java.io.*;
import java.util.*;

public class Main {
    private static boolean notValid(StringBuilder num, int m, int s) {
        if(num.length() != m || (num.length() > 1 && num.charAt(0) == '0')) {
            return true;
        }
        int sum = 0;
        for(int i = 0; i < num.length(); i++) {
            sum += num.charAt(i)-'0';
        }
        return !(sum == s);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int m = f.nextInt();
        int s = f.nextInt();
        int maxNines = s/9;
        StringBuilder max = new StringBuilder();
        for(int i = 0; i < maxNines; i++) {
            max.append(9);
        }
        if(s%9 > 0) {
            max.append(s%9);
            maxNines++;
        }
        for(int i = 0; i < m-maxNines; i++) {
            max.append(0);
        }
        StringBuilder min = new StringBuilder(max.reverse());
        max.reverse();
        if(min.length() > 1 && min.charAt(0) == '0') {
            min.replace(0, 1, "1");
            for(int i = 1; i < min.length(); i++) {
                char temp = min.charAt(i);
                if(temp > '0') {
                    min.replace(i, i+1, Character.toString((char)(temp-1)));
                    break;
                }
            }
        }
        if(notValid(min, m, s)) {
            min = new StringBuilder("-1");
        }
        if(notValid(max, m, s)) {
            max = new StringBuilder("-1");
        }
        out.println(min + " " + max);
        f.close();
        out.close();
    }
}
