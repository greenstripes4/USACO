import java.io.*;
import java.util.*;
//O(n)
//1
//7
//a 3
//W 10
//A 100
//, 10
//k 7
//. 3
//I 13
//7
//ACM International Collegiate Programming Contest (abbreviated
//as ACM-ICPC or just ICPC) is an annual multi-tiered competition
//among the universities of the world. The ICPC challenges students
//to set ever higher standards of excellence for themselves
//through competition that rewards team work, problem analysis,
//and rapid software development.
//From Wikipedia.

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < testCases; i++){
            int numPaidChars = Integer.parseInt(f.readLine());
            HashMap<Character,Integer> charValues = new HashMap<>();
            for(int j = 0; j < numPaidChars; j++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                charValues.put(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
            }
            int numLines = Integer.parseInt(f.readLine());
            double cost = 0;
            for(int k = 0; k < numLines; k++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                while(st.hasMoreTokens()){
                    char[] word = st.nextToken().toCharArray();
                    for(char l: word){
                        if(charValues.containsKey(l)){
                            cost += ((double) charValues.get(l))/100;
                        }
                    }
                }
            }
            System.out.printf("%.2f",cost);
            System.out.println("$");
        }
    }
}
