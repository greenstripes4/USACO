import java.io.*;
import java.util.*;

public class Main{
    public static int[] getRect(char color, char[][] canvas){
        int[] dim = {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        for(int i = 0; i < canvas.length; i++){
            for(int j = 0; j < canvas.length; j++){
                if(canvas[i][j] == color){
                    dim[0] = Math.min(dim[0],i);
                    dim[1] = Math.min(dim[1],j);
                    dim[2] = Math.max(dim[2],i);
                    dim[3] = Math.max(dim[3],j);
                }
            }
        }
        return dim;
    }
    public static boolean covered(char color, int[] rect, char[][] canvas){
        for(int i = rect[0]; i <= rect[2]; i++){
            for(int j = rect[1]; j <= rect[3]; j++){
                if(canvas[i][j] == color){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("art.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("art.out")));
        int N = Integer.parseInt(f.readLine());
        char[][] canvas = new char[N][N];
        HashSet<Character> colors = new HashSet<>();
        for(int i = 0; i < N; i++){
            canvas[i] = f.readLine().toCharArray();
            for(char j: canvas[i]){
                if(j != '0') {
                    colors.add(j);
                }
            }
        }
        int possibleFirst = colors.size();
        for(char c1: colors){
            for(char c2: colors){
                if(c1 != c2){
                    int[] rect = getRect(c2,canvas);
                    if(covered(c1,rect,canvas)){
                        possibleFirst--;
                        break;
                    }
                }
            }
        }
        out.println(possibleFirst);
        f.close();
        out.close();
    }
}
