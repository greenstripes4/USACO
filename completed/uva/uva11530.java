import java.io.*;
import java.util.HashMap;
/*
O(n)
2
welcome to ulab
good luck and have fun
*/

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        HashMap<Character, Integer> times = new HashMap<>();
        times.put('a',1);
        times.put('b',2);
        times.put('c',3);
        times.put('d',1);
        times.put('e',2);
        times.put('f',3);
        times.put('g',1);
        times.put('h',2);
        times.put('i',3);
        times.put('j',1);
        times.put('k',2);
        times.put('l',3);
        times.put('m',1);
        times.put('n',2);
        times.put('o',3);
        times.put('p',1);
        times.put('q',2);
        times.put('r',3);
        times.put('s',4);
        times.put('t',1);
        times.put('u',2);
        times.put('v',3);
        times.put('w',1);
        times.put('x',2);
        times.put('y',3);
        times.put('z',4);
        times.put(' ',1);
        int numCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < numCases; i++){
            char[] chars = f.readLine().toCharArray();
            int sum = 0;
            for(char j: chars){
                sum += times.get(j);
            }
            System.out.println("Case #" + (i + 1) + ": " + sum);
        }
    }
}
