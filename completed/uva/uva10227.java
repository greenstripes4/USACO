import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        f.readLine();
        for(int t = 0; t < testcases; t++) {
            if(t > 0) {
                out.println();
            }
            StringTokenizer st = new StringTokenizer(f.readLine());
            int P = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            TreeSet<Integer>[] treesHeard = new TreeSet[P];
            for(int i = 0; i < P; i++) {
                treesHeard[i] = new TreeSet<>();
            }
            String input;
            while((input = f.readLine()) != null && input.length() > 0) {
                StringTokenizer heard = new StringTokenizer(input);
                int person = Integer.parseInt(heard.nextToken())-1;
                int tree = Integer.parseInt(heard.nextToken())-1;
                treesHeard[person].add(tree);
            }
            HashSet<String> differentSets = new HashSet<>();
            for(int i = 0; i < P; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j: treesHeard[i]) {
                    sb.append(j);
                    sb.append(" ");
                }
                differentSets.add(sb.toString());
            }
            out.println(differentSets.size());
        }
        f.close();
        out.close();
    }
}