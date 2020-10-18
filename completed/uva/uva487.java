import java.io.*;
import java.util.*;

public class Main{
    private static TreeSet<String> words;
    private static void getAllWords(char[][] table, StringBuilder sb, int r, int c, boolean[][] used) {
        if(sb.length() >= 3) {
            words.add(sb.toString());
        }
        int[][] next = {{r-1,c-1},{r-1,c},{r-1,c+1},{r,c-1},{r,c+1},{r+1,c-1},{r+1,c},{r+1,c+1}};
        for(int[] i: next) {
            if(i[0] >= 0 && i[0] < table.length && i[1] >= 0 && i[1] < table.length && table[i[0]][i[1]] > table[r][c] && !used[i[0]][i[1]]) {
                sb.append(table[i[0]][i[1]]);
                used[i[0]][i[1]] = true;
                getAllWords(table, sb, i[0], i[1], used);
                sb.delete(sb.length()-1,sb.length());
                used[i[0]][i[1]] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            f.readLine();
            if(t > 0) {
                out.println();
            }
            int N = Integer.parseInt(f.readLine());
            char[][] table = new char[N][N];
            for(int i = 0; i < N; i++) {
                table[i] = f.readLine().toCharArray();
            }
            words = new TreeSet<>(new Comparator<String>() {
                @Override
                public int compare(String s, String t1) {
                    if(s.length() == t1.length()) {
                        return s.compareTo(t1);
                    }
                    return s.length()-t1.length();
                }
            });
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    boolean[][] used = new boolean[N][N];
                    used[i][j] = true;
                    getAllWords(table, new StringBuilder().append(table[i][j]), i, j, used);
                }
            }
            for(String i: words) {
                out.println(i);
            }
        }
        f.close();
        out.close();
    }
}
