import java.io.*;
import java.util.LinkedList;
/*
O(n)
1
50
7
19
10
6
0
*/
public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1")));
        String input;
        while (!((input = f.readLine()).equals("0"))) {
            int cards = Integer.parseInt(input);
            LinkedList<Integer> deck = new LinkedList<>();
            for(int i = 1; i <= cards; i++){
                deck.add(i);
            }
            int[] discarded = new int[deck.size()-1];
            int ind = 0;
            while(deck.size() > 1){
                discarded[ind] = deck.poll();
                deck.add(deck.poll());
                ind++;
            }
            out.print("Discarded cards:");
            for(int j = 0; j < discarded.length; j++){
                if(j == 0){
                    out.print(" ");
                }
                out.print(discarded[j]);
                if(j != discarded.length - 1){
                    out.print(", ");
                }
            }
            out.println();
            out.println("Remaining card: " + deck.get(0));
        }
        out.close();
        f.close();
    }
}
