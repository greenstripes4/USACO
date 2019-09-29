/*
ID: strongh2
LANG: JAVA
TASK: ride
PROG: ride
*/
import java.io.*;
import java.util.*;

public class ride {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String line;
        int product1 = 0;
        int product2 = 0;
        for(int i = 0; i < 2; i++){
            line = f.readLine();
            int product = 1;
            char[] letters = line.toCharArray();
            for(char j: letters){
                int value = ((int) j)-64;
                product *= value;
            }
            if(i == 0){
                product1 = product;
            }
            else{
                product2 = product;
            }
        }
        if((product1%47) == (product2%47)){
            out.println("GO");
        }
        else{
            out.println("STAY");
        }
        out.close();
    }
}
