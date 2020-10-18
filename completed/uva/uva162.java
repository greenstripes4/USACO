import java.io.*;
import java.util.*;

public class Main{
    private static int getIntegerRepresentation(String card) {
        char value = card.charAt(1);
        if(value == 'T') {
            return 10;
        }
        if(value == 'J') {
            return 11;
        }
        if(value == 'Q') {
            return 12;
        }
        if(value == 'K') {
            return 13;
        }
        if(value == 'A') {
            return 14;
        }
        return Character.getNumericValue(value);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("#")) {
            Stack<Integer> one = new Stack<>();
            Stack<Integer> two = new Stack<>();
            StringTokenizer st = new StringTokenizer(input);
            for(int i = 0; i < 52; i++) {
                if(st.hasMoreTokens()) {
                    if(i%2 == 0) {
                        two.push(getIntegerRepresentation(st.nextToken()));
                    } else {
                        one.push(getIntegerRepresentation(st.nextToken()));
                    }
                } else {
                    st = new StringTokenizer(f.readLine());
                }
            }
            Stack<Integer> pile = new Stack<>();
            boolean turn = true;
            int lastFaceCard = 0;
            while(true) {
                if(turn) {
                    if(lastFaceCard == 2) {
                        Stack<Integer> nextTwo = new Stack<>();
                        for(int i: pile) {
                            nextTwo.push(i);
                        }
                        pile.clear();
                        for(int i: two) {
                            nextTwo.push(i);
                        }
                        two = nextTwo;
                    }
                    if(two.isEmpty()) {
                        break;
                    }
                    if(pile.isEmpty() || pile.peek() < 12) {
                        pile.push(two.pop());
                    } else {
                        int cover = pile.peek()-12;
                        if(two.isEmpty()) {
                            break;
                        }
                        pile.push(two.pop());
                        while(cover > 0 && pile.peek() < 12 && !two.isEmpty()) {
                            pile.push(two.pop());
                            cover--;
                        }
                        if(cover > 0 && pile.peek() < 12) {
                            break;
                        }
                    }
                    if(pile.peek() >= 11) {
                        lastFaceCard = 2;
                    }
                } else {
                    if(lastFaceCard == 1) {
                        Stack<Integer> nextOne = new Stack<>();
                        for(int i: pile) {
                            nextOne.push(i);
                        }
                        pile.clear();
                        for(int i: one) {
                            nextOne.push(i);
                        }
                        one = nextOne;
                    }
                    if(one.isEmpty()) {
                        break;
                    }
                    if(pile.isEmpty() || pile.peek() < 12) {
                        pile.push(one.pop());
                    } else {
                        int cover = pile.peek()-12;
                        if(one.isEmpty()) {
                            break;
                        }
                        pile.push(one.pop());
                        while(cover > 0 && pile.peek() < 12 && !one.isEmpty()) {
                            pile.push(one.pop());
                            cover--;
                        }
                        if(cover > 0 && pile.peek() < 12) {
                            break;
                        }
                    }
                    if(pile.peek() >= 11) {
                        lastFaceCard = 1;
                    }
                }
                turn = !turn;
            }
            if(turn) {
                out.println(1 + String.format("%1$3s",one.size()));
            } else {
                out.println(2 + String.format("%1$3s",two.size()));
            }
        }
        f.close();
        out.close();
    }
}
