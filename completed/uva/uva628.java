import java.io.*;
import java.util.*;

public class Main{
    private static void dfs(char[] rules, int ind, ArrayList<String> words, String password, PrintWriter out){
        if(ind == rules.length){
            out.println(password);
            return;
        }
        if(rules[ind] == '#'){
            for(String i: words){
                dfs(rules,ind+1,words,password+i,out);
            }
        } else {
            for(int i = 0; i < 10; i++){
                dfs(rules,ind+1,words,password+i,out);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null){
            out.println("--");
            int n = Integer.parseInt(input);
            ArrayList<String> words = new ArrayList<>();
            for(int i = 0; i < n; i++){
                words.add(f.readLine());
            }
            int m = Integer.parseInt(f.readLine());
            for(int i = 0; i < m; i++){
                dfs(f.readLine().toCharArray(),0,words,"",out);
            }
        }
        f.close();
        out.close();
    }
}
