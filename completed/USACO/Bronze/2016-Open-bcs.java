import java.io.*;
import java.util.*;

public class Main{
    public static char[][] merge(char[][] piece1, char[][] piece2, int i, int j){
        int length = piece1.length;
        char[][] built = new char[2*piece1.length][2*piece1.length];
        int top = -1;
        int left = -1;
        boolean assigned = false;
        for (int x=0; x<built.length;x++)
            for (int y=0; y<built.length;y++) {
                built[x][y]='.';
            }
        for(int k = 0; k < piece1.length; k++){
            for(int l = 0; l < piece1.length; l++){
                built[k][l] = piece1[k][l];
                if(piece1[k][l] == '#' && !assigned){
                    top = k;
                    left = l;
                    assigned = true;
                }
            }
        }
        boolean inValid = false;
        for(int m = 0; m < piece2.length; m++){
            for(int n = 0; n < piece2.length; n++){
                if((built[m+i][n+j] == '#' && piece2[m][n] == '#') || (piece2[m][n] == '#' && (m - top >= length || n - left >= length))){
                    inValid = true;
                    break;
                }
                built[m + i][n + j] = (built[m + i][n + j] == '#') ? '#':piece2[m][n];
            }
            if(inValid){
                break;
            }
        }
        if(!inValid){
            /*
            for(int l = 0; l < built.length; l++){
                for(int m = 0; m < built.length; m++){
                    System.out.print(built[l][m]);
                }
                System.out.println();
            }
            */
            return built;
        } else {
            return null;
        }
    }
    public static boolean isValid(char[][] piece1, char[][] piece2, char[][] original){
        int length = piece1.length;
        for(int i = 0; i <= piece1.length; i++){
            for(int j = 0; j <= piece1.length; j++){
                char[][] built = merge(piece1, piece2, i, j);
                if(built == null){
                    continue;
                }
                if(contains(built,original)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean contains(char[][] build, char[][] original){
        for(int i = 0; i <= build.length - original.length; i++){
            for(int j = 0; j <= build.length - original.length; j++){
                boolean isEquals = true;
                for(int k = 0; k < original.length; k++){
                    for(int l = 0; l < original.length; l++){
                        if(build[k+i][l+j] != original[k][l]){
                            isEquals = false;
                            break;
                        }
                    }
                    if(!isEquals) {
                        break;
                    }
                }
                if(isEquals){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("bcs.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcs.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[][][] pieces = new char[K][N][N];
        char[][] figurine = new char[N][N];
        for(int i = 0; i < N; i++){
            figurine[i] = f.readLine().toCharArray();
        }
        for(int j = 0; j < K; j++){
            for(int k = 0; k < N; k++){
                pieces[j][k] = f.readLine().toCharArray();
            }
        }
        merge(pieces[2],pieces[0],1,3);
        for(int l = 0; l < K; l++){
            for(int m = 0; m < K; m++){
                if(l != m && isValid(pieces[l], pieces[m], figurine)){
                    out.println(Math.min(l+1,m+1) + " " + Math.max(l+1,m+1));
                    break;
                }
            }
        }
        f.close();
        out.close();
    }
}
