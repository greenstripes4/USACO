import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int testCase = 1;
        while(!(input = f.readLine()).equals("end")){
            ArrayList<Stack<Character>> stacks = new ArrayList<>();
            char[] containers = input.toCharArray();
            for(char i: containers){
                boolean hasStack = false;
                for(Stack<Character> j: stacks){
                    if(j.peek() >= i){
                        hasStack = true;
                        j.push(i);
                        break;
                    }
                }
                if(!hasStack){
                    Stack<Character> temp = new Stack<>();
                    temp.push(i);
                    stacks.add(temp);
                }
            }
            out.println("Case " + testCase + ": " + stacks.size());
            testCase++;
        }
        f.close();
        out.close();
    }
}
