import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
/*
O(n)
This_is_a_[Beiju]_text
[[]][][]Happy_Birthday_to_Tsinghua_University
*/
public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1")));
        String input;
        while((input = f.readLine()) != null){
            LinkedList<Character> text =new LinkedList<>();
            int index = 0;
            for(char c : input.toCharArray()){
                if(c == '['){
                    index=0;
                }
                else if(c==']'){
                    index =text.size();
                }
                else {
                    text.add(index, c);
                    index++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(char literal: text){
                sb.append(literal);
            }
            out.println(sb);
        }
        out.close();
        f.close();
    }
}
