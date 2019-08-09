import java.io.*;
import java.util.*;
/*
O(n^2)
1 1 1
1 1 1 1
2 2 2
1 1 1 2
1 1 2 1
493 182 3
349 148 363 146
241 123 443 147
303 124 293 17
0 0 0
 */

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while(!((input = f.readLine()).equals("0 0 0"))){
            StringTokenizer st = new StringTokenizer(input);
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            boolean[][] board = new boolean[w][h];
            int emptySpots = w*h;
            for(int i = 0; i < n; i++){
                StringTokenizer corners = new StringTokenizer(f.readLine());
                int x1 = Integer.parseInt(corners.nextToken());
                int y1 = Integer.parseInt(corners.nextToken());
                int x2 = Integer.parseInt(corners.nextToken());
                int y2 = Integer.parseInt(corners.nextToken());
                for(int j = Math.min(x1,x2); j <= Math.max(x1,x2); j++){
                    for(int k = Math.min(y1,y2); k <= Math.max(y1,y2); k++){
                        if(!board[j-1][k-1]){
                            emptySpots--;
                            board[j-1][k-1] = true;
                        }
                    }
                }
            }
            if(emptySpots == 0){
                System.out.println("There is no empty spots.");
            }
            else if(emptySpots == 1){
                System.out.println("There is one empty spot.");
            }
            else{
                System.out.println("There are " + emptySpots + " empty spots.");
            }
            f.readLine();
        }
    }
}
