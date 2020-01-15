/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.util.*;
import java.io.*;


public class Main {
    static ArrayList<String> res = new ArrayList<>();
    public static void getDistinctPermutations(String str, String ans) {
        if (str.length() == 0) {
            res.add(ans);
            return;
        }
        boolean[] alpha = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            if (!alpha[ch - 'a'])
                getDistinctPermutations(ros, ans + ch);
            alpha[ch - 'a'] = true;
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("cecs.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input = f.readLine();
        getDistinctPermutations(input,"");
        out.println(res.size());
        Collections.sort(res);
        for(String i: res){
            out.println(i);
        }
        f.close();
        out.close();
    }
}
