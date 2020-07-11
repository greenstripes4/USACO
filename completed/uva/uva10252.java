import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String a;
        while((a = f.readLine()) != null){
            String b = f.readLine();
            char[] A = a.toCharArray();
            char[] B = b.toCharArray();
            int[] ACount = new int[26];
            int[] BCount = new int[26];
            for(char i: A){
                ACount[i-'a']++;
            }
            for(char i: B){
                BCount[i-'a']++;
            }
            StringBuilder ans = new StringBuilder();
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < Math.min(ACount[i],BCount[i]); j++){
                    ans.append((char)('a'+i));
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
