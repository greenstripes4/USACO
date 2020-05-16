import java.io.*;
import java.util.*;

public class Main{
    private static int stickers;
    private static char getOrientation(char orientation, char turn){
        if(orientation == 'N' && turn == 'E') {
            return 'O';
        } else if(orientation == 'N' && turn == 'D') {
            return 'L';
        } else if(orientation == 'S' && turn == 'E') {
            return 'L';
        } else if(orientation == 'S' && turn == 'D') {
            return 'O';
        } else if(orientation == 'L' && turn == 'E') {
            return 'N';
        } else if(orientation == 'L' && turn == 'D') {
            return 'S';
        } else if(orientation == 'O' && turn == 'E') {
            return 'S';
        }
        return 'N';
    }
    private static void dfs(char[][] arena, int r, int c, char orientation, char[] instructions, int ind){
        if(ind == instructions.length){
            return;
        }
        int nextR = r;
        int nextC = c;
        if(instructions[ind] == 'F' && orientation == 'N') {
            nextR--;
        } else if(instructions[ind] == 'F' && orientation == 'S') {
            nextR++;
        } else if(instructions[ind] == 'F' && orientation == 'L') {
            nextC++;
        } else if(instructions[ind] == 'F' && orientation == 'O') {
            nextC--;
        } else {
            orientation = getOrientation(orientation,instructions[ind]);
        }
        if(nextR < 0 || nextR >= arena.length || nextC < 0 || nextC >= arena[0].length || arena[nextR][nextC] == '#'){
            nextR = r;
            nextC = c;
        }
        if(arena[nextR][nextC] == '*'){
            stickers++;
            arena[nextR][nextC] = '.';
        }
        dfs(arena,nextR,nextC,orientation,instructions,ind+1);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0 && S == 0){
                break;
            }
            char[][] arena = new char[N][M];
            for(int i = 0; i < N; i++){
                arena[i] = f.readLine().toCharArray();
            }
            char[] instructions = f.readLine().toCharArray();
            int r = -1;
            int c = -1;
            char orientation = ' ';
            boolean found = false;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(arena[i][j] != '.' && arena[i][j] != '*' && arena[i][j] != '#'){
                        r = i;
                        c = j;
                        orientation = arena[i][j];
                        found = true;
                        break;
                    }
                }
                if(found){
                    break;
                }
            }
            stickers = 0;
            dfs(arena,r,c,orientation,instructions,0);
            out.println(stickers);
        }
        f.close();
        out.close();
    }
}
