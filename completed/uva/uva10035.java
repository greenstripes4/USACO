import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));;
        String input;
        while(!((input = f.readLine()).equals("0 0"))){
            StringTokenizer st = new StringTokenizer(input);
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            ArrayList<Integer> num1 = new ArrayList<>();
            ArrayList<Integer> num2 = new ArrayList<>();
            while (n1 != 0){
                num1.add(n1%10);
                n1 /= 10;
            }
            while (n2 != 0){
                num2.add(n2%10);
                n2 /= 10;
            }
            if(num1.size() < num2.size()){
                for(int i = num1.size(); i < num2.size(); i++){
                    num1.add(0);
                }
            } else if (num2.size() < num1.size()){
                for(int i = num2.size(); i < num1.size(); i++){
                    num2.add(0);
                }
            }
            boolean lastCarry = false;
            int carries = 0;
            for(int i = 0; i < Math.min(num1.size(),num2.size()); i++){
                if(num1.get(i) + num2.get(i) + (lastCarry ? 1:0) >= 10){
                    carries++;
                    lastCarry = true;
                } else {
                    lastCarry = false;
                }
            }
            if(carries == 0){
                out.println("No carry operation.");
            } else if(carries == 1) {
                out.println("1 carry operation.");
            } else {
                out.println(carries + " carry operations.");
            }
        }
        f.close();
        out.close();
    }
}
