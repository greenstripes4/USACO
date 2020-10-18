import java.io.*;
import java.util.*;

public class Main{
    private static int getIntegerRepresentation(String card) {
        char suit = card.charAt(0);
        char value = card.charAt(1);
        return (suit == 'C' ? 0 : suit == 'D' ? 14 : suit == 'S' ? 28 : 42) + (value == 'A' ? 12 : value == 'K' ? 11 : value == 'Q' ? 10 : value == 'J' ? 9 : value == 'T' ? 8 : Character.getNumericValue(value)-2);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("#")) {
            char temp = input.charAt(0);
            int next = temp == 'N' ? 0 : temp == 'E' ? 1 : temp == 'S' ? 2 : 3;
            ArrayList<String>[] hands = new ArrayList[4];
            for(int i = 0; i < 4; i++) {
                hands[i] = new ArrayList<>();
            }
            char[] firstLine = f.readLine().toCharArray();
            for(int i = 0; i < 52; i += 2) {
                next = (next+1)%4;
                hands[next].add(Character.toString(firstLine[i])+firstLine[i+1]);
            }
            char[] secondLine = f.readLine().toCharArray();
            for(int i = 0; i < 52; i += 2) {
                next = (next+1)%4;
                hands[next].add(Character.toString(secondLine[i])+secondLine[i+1]);
            }
            for(int i = 0; i < 4; i++) {
                Collections.sort(hands[i], new Comparator<String>() {
                    @Override
                    public int compare(String s, String t1) {
                        return getIntegerRepresentation(s)-getIntegerRepresentation(t1);
                    }
                });
            }
            out.print("S:");
            for(int i = 0; i < 13; i++) {
                out.print(" " + hands[2].get(i));
            }
            out.println();
            out.print("W:");
            for(int i = 0; i < 13; i++) {
                out.print(" " + hands[3].get(i));
            }
            out.println();
            out.print("N:");
            for(int i = 0; i < 13; i++) {
                out.print(" " + hands[0].get(i));
            }
            out.println();
            out.print("E:");
            for(int i = 0; i < 13; i++) {
                out.print(" " + hands[1].get(i));
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
