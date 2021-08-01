import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int cases = Integer.parseInt(f.readLine());
        boolean first = true;
        f.readLine();
        while(cases-- > 0) {
            if(!first) {
                out.println();
            }
            String[] deck = new String[52];
            String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
            String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 13; j++) {
                    deck[i*13+j] = values[j] + " of " + suits[i];
                }
            }
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[][] moves = new int[n][52];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < 52;) {
                    if(st.hasMoreTokens()) {
                        moves[i][j] = Integer.parseInt(st.nextToken())-1;
                        j++;
                    } else {
                        st = new StringTokenizer(f.readLine());
                    }
                }
            }
            String input;
            while((input = f.readLine()) != null && input.length() > 0) {
                String[] next = new String[52];
                int k = Integer.parseInt(input)-1;
                for(int i = 0; i < 52; i++){
                    next[i] = deck[moves[k][i]];
                }
                deck = next;
            }
            for(String i: deck) {
                out.println(i);
            }
            first = false;
        }
        f.close();
        out.close();
    }
}