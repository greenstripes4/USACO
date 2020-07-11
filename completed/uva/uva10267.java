import java.io.*;
import java.util.*;

public class Main{
    private static void floodFill(char[][] grid, int r, int c, char cur, char change){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != cur){
            return;
        }
        grid[r][c] = change;
        floodFill(grid,r+1,c,cur,change);
        floodFill(grid,r-1,c,cur,change);
        floodFill(grid,r,c+1,cur,change);
        floodFill(grid,r,c-1,cur,change);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[][] image = new char[0][0];
        while(true){
            String command = f.next();
            if(command.equals("X")){
                break;
            }
            if(command.equals("I")) {
                int M = f.nextInt();
                int N = f.nextInt();
                image = new char[N][M];
                for(char[] i: image){
                    Arrays.fill(i,'O');
                }
            } else if(command.equals("C")) {
                for(char[] i: image){
                    Arrays.fill(i,'O');
                }
            } else if(command.equals("L")) {
                int X = f.nextInt()-1;
                int Y = f.nextInt()-1;
                String C = f.next();
                image[Y][X] = C.charAt(0);
            } else if(command.equals("V")) {
                int X = f.nextInt()-1;
                int Y1 = f.nextInt()-1;
                int Y2 = f.nextInt()-1;
                if(Y1 > Y2){
                    int temp = Y1;
                    Y1 = Y2;
                    Y2 = temp;
                }
                String C = f.next();
                for(int i = Y1; i <= Y2; i++){
                    image[i][X] = C.charAt(0);
                }
            } else if(command.equals("H")) {
                int X1 = f.nextInt()-1;
                int X2 = f.nextInt()-1;
                int Y = f.nextInt()-1;
                if(X1 > X2){
                    int temp = X1;
                    X1 = X2;
                    X2 = temp;
                }
                String C = f.next();
                for(int i = X1; i <= X2; i++){
                    image[Y][i] = C.charAt(0);
                }
            } else if(command.equals("K")) {
                int X1 = f.nextInt()-1;
                int Y1 = f.nextInt()-1;
                int X2 = f.nextInt()-1;
                int Y2 = f.nextInt()-1;
                String C = f.next();
                for(int i = Math.min(X1,X2); i <= Math.max(X1,X2); i++){
                    for(int j = Math.min(Y1,Y2); j <= Math.max(Y1,Y2); j++){
                        image[j][i] = C.charAt(0);
                    }
                }
            } else if(command.equals("F")) {
                int X = f.nextInt()-1;
                int Y = f.nextInt()-1;
                String C = f.next();
                if(image[Y][X] != C.charAt(0)) {
                    floodFill(image,Y,X,image[Y][X],C.charAt(0));
                }
            } else if(command.equals("S")) {
                String name = f.next();
                out.println(name);
                for(char[] i: image){
                    out.println(i);
                }
            }
        }
        f.close();
        out.close();
    }
}
