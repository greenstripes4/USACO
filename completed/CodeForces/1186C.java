import sun.awt.im.CompositionArea;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] a = f.readLine().toCharArray();
        char[] b = f.readLine().toCharArray();
        int bOnes = 0;
        for(char i: b) {
            if(i == '1') {
                bOnes++;
            }
        }
        int cOnes = 0;
        for(int i = 0; i < b.length; i++) {
            if(a[i] == '1') {
                cOnes++;
            }
        }
        int count = 0;
        if(bOnes%2 == cOnes%2) {
            count++;
        }
        for(int i = b.length; i < a.length; i++) {
            if(a[i-b.length] == '1') {
                cOnes--;
            }
            if(a[i] == '1') {
                cOnes++;
            }
            if(bOnes%2 == cOnes%2) {
                count++;
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}
