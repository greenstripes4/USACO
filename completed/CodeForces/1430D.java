import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            char[] s = f.readLine().toCharArray();
            int pointer1 = 0;
            int pointer2 = 0;
            int operations = 0;
            while(pointer1 < n && pointer2 < n-1) {
                while(pointer2 < n-1 && s[pointer2] != s[pointer2+1]) {
                    pointer2++;
                }
                s[pointer2] = ' ';
                while(pointer1 < n && s[pointer1] == ' ') {
                    pointer1++;
                }
                char temp = s[pointer1];
                while(pointer1 < n && (s[pointer1] == temp || s[pointer1] == ' ')) {
                    s[pointer1] = ' ';
                    pointer1++;
                }
                pointer2 = Math.max(pointer2, pointer1);
                operations++;
            }
            int count = 0;
            for(char j: s) {
                if(j != ' ') {
                    count++;
                }
            }
            operations += (count+1)/2;
            out.println(operations);
        }
        f.close();
        out.close();
    }
}
