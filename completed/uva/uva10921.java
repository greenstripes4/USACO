import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            for(char i: input.toCharArray()) {
                if(i == 'A' || i == 'B' || i == 'C') {
                    sb.append(2);
                } else if(i == 'D' || i == 'E' || i == 'F') {
                    sb.append(3);
                } else if(i == 'G' || i == 'H' || i == 'I') {
                    sb.append(4);
                } else if(i == 'J' || i == 'K' || i == 'L') {
                    sb.append(5);
                } else if(i == 'M' || i == 'N' || i == 'O') {
                    sb.append(6);
                } else if(i == 'P' || i == 'Q' || i == 'R' || i == 'S') {
                    sb.append(7);
                } else if(i == 'T' || i == 'U' || i == 'V') {
                    sb.append(8);
                } else if(i == 'W' || i == 'X' || i == 'Y' || i == 'Z') {
                    sb.append(9);
                } else {
                    sb.append(i);
                }
            }
            out.println(sb);
        }
        f.close();
        out.close();
    }
}
