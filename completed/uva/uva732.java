import java.io.*;
import java.util.*;

public class Main{
    private static void generateSequences(String ins, Stack<Character> stack, String source, String target, int push, int pop, PrintWriter out){
        if(pop == source.length()){
            out.println(ins.substring(1));
            return;
        }
        if(push < source.length()){
            stack.push(source.charAt(push));
            generateSequences(ins+" i",stack,source,target,push+1,pop,out);
            stack.pop();
        }
        if(!stack.isEmpty() && stack.peek() == target.charAt(pop)){
            char next = stack.pop();
            generateSequences(ins+" o",stack,source,target,push,pop+1,out);
            stack.push(next);
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String source;
        while((source = f.readLine()) != null){
            String target = f.readLine();
            out.println("[");
            if(source.length() == target.length()) {
                generateSequences("", new Stack<>(), source, target, 0, 0, out);
            }
            out.println("]");
        }
        f.close();
        out.close();
    }
}
