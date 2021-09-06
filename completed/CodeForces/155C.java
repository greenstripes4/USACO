import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] s = f.readLine().toCharArray();
        int k = Integer.parseInt(f.readLine());
        boolean[][] invalid = new boolean[26][26];
        for(int i = 0; i < k; i++) {
            char[] temp = f.readLine().toCharArray();
            invalid[temp[0]-'a'][temp[1]-'a'] = true;
            invalid[temp[1]-'a'][temp[0]-'a'] = true;
        }
        ArrayList<int[]> same = new ArrayList<>();
        for(char i: s) {
            if(same.isEmpty() || i != same.get(same.size()-1)[0]) {
                same.add(new int[]{i, 1});
            } else {
                same.get(same.size()-1)[1]++;
            }
        }
        int i = 0;
        int j = 1;
        int ans = 0;
        while(j < same.size()) {
            while(j < same.size() && invalid[same.get(j)[0]-'a'][same.get(j-1)[0]-'a']) {
                j++;
            }
            j++;
            int a = 0;
            int b = 0;
            while(i < j-1) {
                if(i%2 == 0) {
                    a += same.get(i)[1];
                } else {
                    b += same.get(i)[1];
                }
                i++;
            }
            ans += Math.min(a, b);
        }
        out.println(ans);
        f.close();
        out.close();
    }
}