import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        ArrayList<char[]> input = new ArrayList<>();
        String next;
        while((next = f.readLine()) != null) {
            input.add(next.toCharArray());
        }
        ArrayList<ArrayList<Character>> rotated = new ArrayList<>();
        for(int i = input.size()-1; i >= 0; i--) {
            for(int j = 0; j < input.get(i).length; j++) {
                if(j >= rotated.size()) {
                    rotated.add(new ArrayList<>());
                    for(int k = 0; k < input.size()-i-1; k++) {
                        rotated.get(j).add(' ');
                    }
                }
                rotated.get(j).add(input.get(i)[j]);
            }
        }
        int maxLength = 0;
        for(ArrayList<Character> i: rotated) {
            maxLength = Math.max(maxLength,i.size());
        }
        for(ArrayList<Character> i: rotated) {
            for(int j = 0; j < maxLength; j++) {
                out.print(j >= i.size() ? ' ' : i.get(j));
            }
            out.println();
        }
        f.close();
        out.close();
    }
}