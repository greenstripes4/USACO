import java.io.*;
import java.util.*;

public class Main {
    public static boolean isPrime(int n) {
        if(n == 1){
            return true;
        }
        for (int i = 2; i <= Math.ceil(Math.sqrt(n)); i++) {
            if (n % i == 0 && i != n) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('a',1);
        map.put('b',2);
        map.put('c',3);
        map.put('d',4);
        map.put('e',5);
        map.put('f',6);
        map.put('g',7);
        map.put('h',8);
        map.put('i',9);
        map.put('j',10);
        map.put('k',11);
        map.put('l',12);
        map.put('m',13);
        map.put('n',14);
        map.put('o',15);
        map.put('p',16);
        map.put('q',17);
        map.put('r',18);
        map.put('s',19);
        map.put('t',20);
        map.put('u',21);
        map.put('v',22);
        map.put('w',23);
        map.put('x',24);
        map.put('y',25);
        map.put('z',26);
        map.put('A',27);
        map.put('B',28);
        map.put('C',29);
        map.put('D',30);
        map.put('E',31);
        map.put('F',32);
        map.put('G',33);
        map.put('H',34);
        map.put('I',35);
        map.put('J',36);
        map.put('K',37);
        map.put('L',38);
        map.put('M',39);
        map.put('N',40);
        map.put('O',41);
        map.put('P',42);
        map.put('Q',43);
        map.put('R',44);
        map.put('S',45);
        map.put('T',46);
        map.put('U',47);
        map.put('V',48);
        map.put('W',49);
        map.put('X',50);
        map.put('Y',51);
        map.put('Z',52);
        String input;
        while((input = f.readLine()) != null){
            char[] letters = input.toCharArray();
            int sum = 0;
            for(char i: letters){
                sum += map.get(i);
            }
            if(isPrime(sum)){
                out.println("It is a prime word.");
            } else {
                out.println("It is not a prime word.");
            }
        }
        f.close();
        out.close();
    }
}
