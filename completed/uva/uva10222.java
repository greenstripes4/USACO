import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));;
        char[] message = f.readLine().toLowerCase().toCharArray();
        String sequence = "`1234567890-=qwertyuiop[]asdfghjkl;'zxcvbnm,./";
        StringBuilder sb = new StringBuilder();
        for(char i: message){
            sb.append(i == ' ' ? ' ': sequence.charAt(sequence.indexOf(i)-2));
        }
        out.println(sb.toString());
        f.close();
        out.close();
    }
}
