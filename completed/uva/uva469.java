import java.io.*;
import java.util.*;

public class Main{
    private static int size;
    private static ArrayList<int[]> changed;
    private static void dfs(char[][] wetlands, int n, int m, int r, int c){
        if(r < 0 || c < 0 || r >= n || c >= m || wetlands[r][c] != 'W'){
            return;
        }
        size++;
        wetlands[r][c] = 'L';
        changed.add(new int[]{r,c});
        dfs(wetlands,n,m,r,c-1);
        dfs(wetlands,n,m,r,c+1);
        dfs(wetlands,n,m,r-1,c-1);
        dfs(wetlands,n,m,r-1,c);
        dfs(wetlands,n,m,r-1,c+1);
        dfs(wetlands,n,m,r+1,c-1);
        dfs(wetlands,n,m,r+1,c);
        dfs(wetlands,n,m,r+1,c+1);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = Integer.parseInt(f.readLine());
        f.readLine();
        for(int i = 0; i < testCases; i++){
            if(i > 0){
                out.println();
            }
            char[][] wetlands = new char[99][];
            int n = 0;
            int m = 0;
            String next;
            while((next = f.readLine()) != null){
                char[] temp = next.toCharArray();
                if(temp[0] != 'L' && temp[0] != 'W'){
                    break;
                }
                wetlands[n] = temp;
                m = temp.length;
                n++;
            }
            if(next == null){
                continue;
            }
            StringTokenizer st = new StringTokenizer(next);
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            size = 0;
            changed = new ArrayList<>();
            dfs(wetlands,n,m,r,c);
            out.println(size);
            for(int[] j: changed){
                wetlands[j[0]][j[1]] = 'W';
            }
            while((next = f.readLine()) != null){
                if(next.length() == 0){
                    break;
                }
                st = new StringTokenizer(next);
                r = Integer.parseInt(st.nextToken())-1;
                c = Integer.parseInt(st.nextToken())-1;
                size = 0;
                changed = new ArrayList<>();
                dfs(wetlands,n,m,r,c);
                out.println(size);
                for(int[] j: changed){
                    wetlands[j[0]][j[1]] = 'W';
                }
            }
        }
        f.close();
        out.close();
    }
}
