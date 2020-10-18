import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        HashMap<Character,Integer> noteValues = new HashMap<>();
        noteValues.put('W',64);
        noteValues.put('H',32);
        noteValues.put('Q',16);
        noteValues.put('E',8);
        noteValues.put('S',4);
        noteValues.put('T',2);
        noteValues.put('X',1);
        while(!(input = f.readLine()).equals("*")) {
            String[] measures = input.split("/");
            int count = 0;
            for(String i: measures) {
                int sum = 0;
                for(char j: i.toCharArray()) {
                    sum += noteValues.get(j);
                }
                if(sum == 64) {
                    count++;
                }
            }
            out.println(count);
        }
        f.close();
        out.close();
    }
}
