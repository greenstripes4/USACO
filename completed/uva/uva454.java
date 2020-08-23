import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        f.readLine();
        for(int t = 0; t < testcases; t++) {
            if(t > 0) {
                out.println();
            }
            ArrayList<String> words = new ArrayList<>();
            String word;
            while((word = f.readLine()) != null && word.length() > 0) {
                words.add(word);
            }
            Collections.sort(words);
            for(int i = 0; i < words.size(); i++) {
                for(int j = i+1; j < words.size(); j++) {
                    char[] formattedI = words.get(i).replaceAll(" ","").toCharArray();
                    char[] formattedJ = words.get(j).replaceAll(" ","").toCharArray();
                    Arrays.sort(formattedI);
                    Arrays.sort(formattedJ);
                    if(Arrays.equals(formattedI,formattedJ)) {
                        out.println(words.get(i) + " = " + words.get(j));
                    }
                }
            }
        }
        f.close();
        out.close();
    }
}
