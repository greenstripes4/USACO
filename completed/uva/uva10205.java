import java.io.*;
import java.util.StringTokenizer;
/*
O(n)
2

2
2 1 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 52 51
52 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 1
1
2

1
2 1 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 52 51
1
*/

public class Main {
    public static void main (String args[]) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(f.readLine());
        boolean first = true;
        for(int i = 0; i < cases; i++){
            if(!first){
                System.out.println();
            }
            else{
                f.readLine();
            }
            first = false;
            String[] deck = new String[52];
            String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
            String[] values = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
            int ind = 0;
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 13; k++){
                    deck[ind] = values[k] + " of " + suits[j];
                    ind++;
                }
            }
            int num_shuffles = Integer.parseInt(f.readLine());
            int[][] moves = new int[num_shuffles][52];
            String input;
            StringTokenizer st = new StringTokenizer("");
            for(int j = 0; j < num_shuffles; j++){
                for(int j2 = 0; j2 < 52; j2++){
                    if(!st.hasMoreTokens()){
                        st = new StringTokenizer(f.readLine());
                    }
                    moves[j][j2] = Integer.parseInt(st.nextToken())-1;
                }
            }
            while((input = f.readLine()) != null && !(input.equals(""))){
                String[] temp = new String[52];
                int shuffle_num = Integer.parseInt(input);
                for(int k = 0; k < 52; k++){
                    temp[k] = deck[moves[shuffle_num-1][k]];
                }
                deck = temp;
            }
            for (String n : deck) {
                System.out.println(n);
            }
        }
    }
}
