import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowfind.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowfind.out")));
        char[] grass = f.readLine().toCharArray();
        ArrayList<Integer> hind = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < grass.length - 1; i++){
            if(grass[i] == '(' && grass[i+1] == '('){
                hind.add(i);
            } else if(grass[i] == ')' && grass[i+1] == ')'){
                count += hind.size();
            }
        }
        out.println(count);
        out.close();
        f.close();
    }
}
