import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("crosswords.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crosswords.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] chars = new char[N][M];
        for(int i = 0; i < N; i++){
            chars[i] = f.readLine().toCharArray();
        }
        ArrayList<int[]> validPos = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(chars[i][j] == '.'){
                    if((i-1 < 0 || chars[i-1][j] == '#') && (i+2 < N && chars[i+1][j] == '.' && chars[i+2][j] == '.')){
                        validPos.add(new int[]{i+1,j+1});
                    } else if((j-1 < 0 || chars[i][j-1] == '#') && (j+2 < M && chars[i][j+1] == '.' && chars[i][j+2] == '.')) {
                        validPos.add(new int[]{i+1,j+1});
                    }
                }
            }
        }
        out.println(validPos.size());
        for(int[] i: validPos){
            out.println(i[0] + " " + i[1]);
        }
        f.close();
        out.close();
    }
}
