import java.io.*;
import java.util.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        int count = 1;
        while(!((input = f.readLine()).equals("0"))){
            int numPiles = Integer.parseInt(input);
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] pileHeights = new int[numPiles];
            int totalHeight = 0;
            for(int i = 0; i < numPiles; i++){
                int pile_height = Integer.parseInt(st.nextToken());
                totalHeight += pile_height;
                pileHeights[i] = pile_height;
            }
            int meanHeight = totalHeight/numPiles;
            int TDFTM = 0;
            for(int j: pileHeights){
                TDFTM += Math.abs(j-meanHeight);
            }
            System.out.println("Set #" + count);
            System.out.println("The minimum number of moves is " + (TDFTM/2) + ".");
            count++;
            System.out.println();
        }
        f.close();
    }
}
