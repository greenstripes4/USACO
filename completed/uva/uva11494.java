import java.io.*;
import java.util.StringTokenizer;
/*
O(1)
4 4 6 2
3 5 3 5
5 5 4 3
8 8 8 8
1 1 1 1
1 8 1 8
1 8 8 1
1 1 1 8
8 8 8 1
0 0 0 0
*/

public class Main {
    public static void main (String args[]) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while(!((input = f.readLine()).equals("0 0 0 0"))){
            StringTokenizer st = new StringTokenizer(input);
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            if(x1 == x2 && y1 == y2){
                System.out.println(0);
            }
            else if((Math.abs(x2-x1) == Math.abs(y2-y1)) || x1 == x2 || y1 == y2){
                System.out.println(1);
            }
            else{
                System.out.println(2);
            }
        }
    }
}
