import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        char[] arr = f.readLine().toCharArray();
        StringBuilder ans = new StringBuilder();
        for(char i: arr) {
            if(i == '2' || i == '3' || i == '5' || i == '7') {
                ans.append(i);
            } else if(i == '4') {
                ans.append(322);
            } else if(i == '6') {
                ans.append(53);
            } else if(i == '8') {
                ans.append(7222);
            } else if(i == '9') {
                ans.append(7332);
            }
        }
        char[] temp = new char[ans.length()];
        for(int i = 0; i < ans.length(); i++) {
            temp[i] = ans.charAt(i);
        }
        Arrays.sort(temp);
        StringBuilder sb = new StringBuilder();
        for(char i: temp) {
            sb.append(i);
        }
        out.println(sb.reverse());
        f.close();
        out.close();
    }
}
