import java.io.*;
import java.util.*;

public class Main{
    private static boolean isStar(char[][] sky, int r, int c){
        if(sky[r][c] == '.'){
            return false;
        }
        char topLeft = (r-1 < 0 || c-1 < 0) ? '.' : sky[r-1][c-1];
        char top = (r-1 < 0) ? '.' : sky[r-1][c];
        char topRight = (r-1 < 0 || c+1 >= sky[0].length) ? '.' : sky[r-1][c+1];
        char left = (c-1 < 0) ? '.' : sky[r][c-1];
        char right = (c+1 >= sky[0].length) ? '.' : sky[r][c+1];
        char bottomLeft = (r+1 >= sky.length || c-1 < 0) ? '.' : sky[r+1][c-1];
        char bottom = (r+1 >= sky.length ) ? '.' : sky[r+1][c];
        char bottomRight = (r+1 >= sky.length || c+1 >= sky[0].length) ? '.' : sky[r+1][c+1];
        return topLeft == '.' && top == '.' && topRight == '.' && left == '.' && right == '.' && bottomLeft == '.' && bottom == '.' && bottomRight == '.';
    }
    private static void dfs(char[][] sky, int r, int c){
        if(r < 0 || c < 0 || r >= sky.length || c >= sky[0].length || sky[r][c] == '.'){
            return;
        }
        sky[r][c] = '.';
        dfs(sky,r-1,c-1);
        dfs(sky,r-1,c);
        dfs(sky,r-1,c+1);
        dfs(sky,r,c-1);
        dfs(sky,r,c+1);
        dfs(sky,r+1,c-1);
        dfs(sky,r+1,c);
        dfs(sky,r+1,c+1);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!((input = f.readLine()).equals("0 0"))){
            StringTokenizer st = new StringTokenizer(input);
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            char[][] sky = new char[r][c];
            for(int i = 0; i < r; i++){
                sky[i] = f.readLine().toCharArray();
            }
            int stars = 0;
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    if(isStar(sky,i,j)){
                        stars++;
                    } else if(sky[i][j] == '*'){
                        dfs(sky,i,j);
                    }
                }
            }
            out.println(stars);
        }
        f.close();
        out.close();
    }
}
