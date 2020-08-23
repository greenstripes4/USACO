import java.io.*;
import java.util.*;

public class Main {
    private static TreeSet<String> permutations;
    private static void generatePermutations(char[] str, boolean[] visited, StringBuilder sb) {
        if(sb.length() == str.length) {
            permutations.add(sb.toString());
            return;
        }
        for(int i = 0; i < str.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sb.append(str[i]);
                generatePermutations(str,visited,sb);
                visited[i] = false;
                sb.delete(sb.length()-1,sb.length());
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        for(int t = 0; t < n; t++) {
            char[] str = f.readLine().toCharArray();
            Arrays.sort(str);
            permutations = new TreeSet<>();
            generatePermutations(str,new boolean[str.length],new StringBuilder());
            for(String i: permutations) {
                out.println(i);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
