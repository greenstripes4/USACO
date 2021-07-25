import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        char[] s = f.readLine().toCharArray();
        ArrayList<Character> left = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            left.add(s[i]);
        }
        while(true) {
            int max = -1;
            for(int i = 0; i < left.size(); i++) {
                if((i > 0 && left.get(i)-1 == left.get(i-1)) || (i < left.size()-1 && left.get(i)-1 == left.get(i+1))) {
                    if(max == -1 || left.get(i) > left.get(max)) {
                        max = i;
                    }
                }
            }
            if(max == -1) {
                break;
            }
            left.remove(max);
        }
        out.println(n-left.size());
        f.close();
        out.close();
    }
}