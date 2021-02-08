import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        ArrayList<String> ans = new ArrayList<>();
        ans.add("0");
        ans.add("1");
        for(int i = 1; i < n; i++) {
            ArrayList<String> temp = new ArrayList<>(ans);
            Collections.reverse(temp);
            ans.addAll(temp);
            for(int j = 0; j < ans.size()/2; j++) {
                ans.set(j, "0"+ans.get(j));
            }
            for(int j = ans.size()/2; j < ans.size(); j++) {
                ans.set(j, "1"+ans.get(j));
            }
        }
        for(String i: ans) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}