import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        char[][] arr = new char[5][n*4];
        for(int i = 0; i < 5; i++) {
            arr[i] = f.readLine().toCharArray();
        }
        for(int i = 0; i < n; i++) {
            if(arr[3][i*4+1] == '*') {
                out.print(1);
            } else if(arr[3][i*4] == '*') {
                out.print(2);
            } else {
                out.print(3);
            }
        }
        out.println();
        f.close();
        out.close();
    }
}
