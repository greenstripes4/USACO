import java.io.*;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static int numStacks;
    public static Stack<Integer>[] stacks;
    public static int[] positions;
    public static boolean isIllegal(int a, int b){
        if(a == b || positions[a] == positions[b]) {
            return true;
        }
        return false;
    }
    public static void moveOneToInitialPos(int a){
        while(!stacks[a].empty()){
            moveOneToInitialPos(stacks[a].pop());
        }
        stacks[a].push(a);
        stacks[positions[a]].pop();
        positions[a] = a;
    }
    public static void moveAllToIntitialPos(int a){
        while(stacks[positions[a]].peek() != a){
            moveOneToInitialPos(stacks[positions[a]].peek());
        }
    }
    public static void moveOnto(int a, int b){
        moveAllToIntitialPos(b);
        moveOver(a,b);
    }
    public static void moveOver(int a, int b){
        moveAllToIntitialPos(a);
        stacks[positions[a]].pop();
        stacks[positions[b]].push(a);
        positions[a] = positions[b];
    }
    public static void pileOnto(int a, int b){
        moveAllToIntitialPos(b);
        pileOver(a,b);
    }
    public static void pileOver(int a, int b){
        Stack<Integer> temp = new Stack<>();
        while(stacks[positions[a]].peek() != a){
            temp.push(stacks[positions[a]].pop());
        }
        temp.push(a);
        stacks[positions[a]].pop();
        while(!temp.empty()){
            positions[temp.peek()] = positions[b];
            stacks[positions[b]].push(temp.pop());
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        numStacks = Integer.parseInt(f.readLine());
        stacks = new Stack[numStacks];
        positions = new int[numStacks];
        for(int i = 0; i < numStacks; i++){
            stacks[i] = new Stack<>();
            stacks[i].push(i);
            positions[i] = i;
        }
        while(!((input = f.readLine()).equals("quit"))){
            StringTokenizer st = new StringTokenizer(input);
            String op = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            String op2 = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            String opall = op+op2;
            if(!isIllegal(a,b)) {
                if (opall.equals("moveonto")) {
                    moveOnto(a, b);
                } else if (opall.equals("moveover")) {
                    moveOver(a, b);
                } else if (opall.equals("pileonto")) {
                    pileOnto(a, b);
                } else {
                    pileOver(a, b);
                }
            }
        }
        for(int i = 0; i < numStacks; i++){
            System.out.print(i + ":");
            String output = "";
            if(!stacks[i].empty()){
                System.out.print(" ");
            }
            while(!stacks[i].empty()){
                output = stacks[i].pop() + " " + output;
            }
            System.out.println(output.trim());
        }
    }
}
