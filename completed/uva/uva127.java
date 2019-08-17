import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
/*
O(n^2)
QD AD 8H 5S 3H 5H TC 4D JH KS 6H 8S JS AC AS 8D 2H QS TS 3S AH 4H TH TD 3C 6S
8C 7D 4C 4S 7S 9H 7C 5D 2S KD 2D QH JD 6D 9D JC 2C KH 3D QC 6C 9S KC 7H 9C 5C
AC 2C 3C 4C 5C 6C 7C 8C 9C TC JC QC KC AD 2D 3D 4D 5D 6D 7D 8D TD 9D JD QD KD
AH 2H 3H 4H 5H 6H 7H 8H 9H KH 6S QH TH AS 2S 3S 4S 5S JH 7S 8S 9S TS JS QS KS
#
*/
public class Main{
    static class Card{
        char value;
        char suit;
        public Card(char value, char suit){
            this.value = value;
            this.suit = suit;
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1")));
        String input;
        while(!((input = f.readLine()).equals("#"))){
            ArrayList<Stack<Card>> cardPiles = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(input);
            for(int i = 0; i < 26; i++){
                Stack<Card> temp = new Stack<>();
                String card = st.nextToken();
                temp.push(new Card(card.charAt(0),card.charAt(1)));
                cardPiles.add(temp);
            }
            st = new StringTokenizer(f.readLine());
            for(int j = 26; j < 52; j++){
                Stack<Card> temp = new Stack<>();
                String card = st.nextToken();
                temp.push(new Card(card.charAt(0),card.charAt(1)));
                cardPiles.add(temp);
            }
            boolean hasMoreMoves = true;
            while(hasMoreMoves){
                hasMoreMoves = false;
                cardPiles.removeIf(Stack::empty);
                for(int k = 1; k < cardPiles.size(); k++){
                    Card card = cardPiles.get(k).peek();
                    int ind1 = k - 3;
                    int ind2 = k - 1;
                    Card comp = null;
                    if(ind1 >= 0){
                        comp = cardPiles.get(ind1).peek();
                    }
                    Card comp2 = cardPiles.get(ind2).peek();
                    if(comp != null && (card.suit == comp.suit || card.value == comp.value)){
                        hasMoreMoves = true;
                        cardPiles.get(k).pop();
                        cardPiles.get(ind1).push(card);
                        break;
                    }
                    else if(card.suit == comp2.suit || card.value == comp2.value){
                        hasMoreMoves = true;
                        cardPiles.get(k).pop();
                        cardPiles.get(ind2).push(card);
                        break;
                    }
                }
            }
            if(cardPiles.size() == 1){
                out.println("1 pile remaining: 52");
            }
            else{
                out.print(cardPiles.size() + " piles remaining: ");
                for(int l = 0; l < cardPiles.size(); l++){
                    out.print(cardPiles.get(l).size());
                    if(l != cardPiles.size()-1){
                        out.print(" ");
                    }
                }
                out.println();
            }
        }
        out.close();
        f.close();
    }
}
