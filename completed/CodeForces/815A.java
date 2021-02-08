import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] g = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < m; j++) {
                g[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(n < m) {
            ArrayList<String> moves = new ArrayList<>();
            int min = 500;
            for(int i = 0; i < m; i++) {
                min = Math.min(min, g[0][i]);
            }
            for(int i = 0; i < min; i++) {
                moves.add("row 1");
            }
            boolean valid = true;
            for(int i = 0; i < m; i++) {
                g[0][i] -= min;
                if(g[0][i] > 0) {
                    for(int j = 1; j < n; j++) {
                        g[j][i] -= g[0][i];
                        if(g[j][i] < 0) {
                            valid = false;
                            break;
                        }
                    }
                    if(!valid) {
                        break;
                    }
                    for(int j = 0; j < g[0][i]; j++) {
                        moves.add("col " + (i+1));
                    }
                    g[0][i] = 0;
                }
            }
            if(valid) {
                for(int i = 1; i < n; i++) {
                    for(int j = 1; j < m; j++) {
                        g[i][j] -= g[i][0];
                        if(g[i][j] != 0) {
                            valid = false;
                            break;
                        }
                    }
                    if(!valid) {
                        break;
                    }
                    for(int j = 0; j < g[i][0]; j++) {
                        moves.add("row " + (i+1));
                    }
                    g[i][0] = 0;
                }
            }
            if(valid) {
                out.println(moves.size());
                for(String i: moves) {
                    out.println(i);
                }
            } else {
                out.println(-1);
            }
        } else {
            ArrayList<String> moves = new ArrayList<>();
            int min = 500;
            for(int i = 0; i < n; i++) {
                min = Math.min(min, g[i][0]);
            }
            for(int i = 0; i < min; i++) {
                moves.add("col 1");
            }
            boolean valid = true;
            for(int i = 0; i < n; i++) {
                g[i][0] -= min;
                if(g[i][0] > 0) {
                    for(int j = 1; j < m; j++) {
                        g[i][j] -= g[i][0];
                        if(g[i][j] < 0) {
                            valid = false;
                            break;
                        }
                    }
                    if(!valid) {
                        break;
                    }
                    for(int j = 0; j < g[i][0]; j++) {
                        moves.add("row " + (i+1));
                    }
                    g[i][0] = 0;
                }
            }
            if(valid) {
                for(int i = 1; i < m; i++) {
                    for(int j = 1; j < n; j++) {
                        g[j][i] -= g[0][i];
                        if(g[j][i] != 0) {
                            valid = false;
                            break;
                        }
                    }
                    if(!valid) {
                        break;
                    }
                    for(int j = 0; j < g[0][i]; j++) {
                        moves.add("col " + (i+1));
                    }
                    g[0][i] = 0;
                }
            }
            if(valid) {
                out.println(moves.size());
                for(String i: moves) {
                    out.println(i);
                }
            } else {
                out.println(-1);
            }
        }
        f.close();
        out.close();
    }
}
