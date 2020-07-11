import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer dimensions = new StringTokenizer(input);
            int m = Integer.parseInt(dimensions.nextToken());
            int n = Integer.parseInt(dimensions.nextToken());
            TreeMap<Integer,Integer>[] transposed = new TreeMap[n];
            for(int i = 0; i < n; i++) {
                transposed[i] = new TreeMap<>();
            }
            for(int i = 0; i < m; i++) {
                StringTokenizer nonZeroIndices = new StringTokenizer(f.readLine());
                StringTokenizer nonZeroElements = new StringTokenizer(f.readLine());
                int nonZeroRowCount = Integer.parseInt(nonZeroIndices.nextToken());
                for(int j = 0; j < nonZeroRowCount; j++) {
                    int column = Integer.parseInt(nonZeroIndices.nextToken())-1;
                    transposed[column].put(i,Integer.parseInt(nonZeroElements.nextToken()));
                }
            }
            out.println(n + " " + m);
            for(int i = 0; i < n; i++) {
                out.print(transposed[i].size());
                for(int j: transposed[i].keySet()) {
                    out.print(" " + (j+1));
                }
                out.println();
                StringBuilder sb  = new StringBuilder();
                for(int j: transposed[i].values()) {
                    sb.append(j);
                    sb.append(" ");
                }
                if(sb.length() > 0) {
                    out.println(sb.substring(0, sb.length()-1));
                } else {
                    out.println();
                }
            }

        }
        f.close();
        out.close();
    }
}
