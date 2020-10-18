import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            char[] line = f.readLine().toCharArray();
            int sqrt = (int) Math.sqrt(line.length);
            if(sqrt*sqrt == line.length) {
                char[][] grid = new char[sqrt][sqrt];
                for(int i = 0; i < line.length; i++) {
                    grid[i/sqrt][i%sqrt] = line[i];
                }
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < sqrt; i++) {
                    for(int j = 0; j < sqrt; j++) {
                        sb.append(grid[j][i]);
                    }
                }
                out.println(sb);
            } else {
                out.println("INVALID");
            }
        }
        f.close();
        out.close();
    }
}
