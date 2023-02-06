import org.jfree.chart.labels.IntervalCategoryItemLabelGenerator;

import java.util.*;
import java.io.*;

public class Main{
    public static void getMatches(HashMap<Integer,Integer> open, HashMap<Integer,Integer> closed, char[] instructions){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < instructions.length; i++){
            if(instructions[i] == '[') {
                stack.push(i);
            } else if(instructions[i] == ']'){
                int prev = stack.pop();
                open.put(prev,i);
                closed.put(i,prev);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("esoteric.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("esoteric.out")));
        char[] instructions = f.readLine().toCharArray();
        ArrayList<Integer> cells = new ArrayList<>();
        HashMap<Integer,Integer> open = new HashMap<>();
        HashMap<Integer,Integer> closed = new HashMap<>();
        getMatches(open,closed,instructions);
        cells.add(0);
        int ind = 0;
        for(int i = 0; i < instructions.length; i++){
            if(instructions[i] == '>'){
                if(ind == cells.size()-1){
                    cells.add(0);
                }
                ind++;
            } else if(instructions[i] == '<'){
                if(ind == 0){
                    cells.add(0,0);
                } else {
                    ind--;
                }
            } else if(instructions[i] == '+'){
                int cur = cells.get(ind);
                cur = (cur+1)%256;
                cells.set(ind,cur);
            } else if(instructions[i] == '-'){
                int cur = cells.get(ind);
                cur = (cur+255)%256;
                cells.set(ind,cur);
            } else if(instructions[i] == '.'){
                out.print((char) cells.get(ind).intValue());
            } else if(instructions[i] == '[' && cells.get(ind) == 0){
                i = open.get(i);
            } else if(instructions[i] == ']' && cells.get(ind) != 0){
                i = closed.get(i);
            }
        }
        out.println();
        f.close();
        out.close();
    }
}
