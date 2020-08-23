import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        f.readLine();
        for(int t = 0; t < N; t++) {
            if(t > 0) {
                out.println();
            }
            ArrayList<char[]> matrix = new ArrayList<>();
            String input;
            while((input = f.readLine()) != null && input.length() > 0) {
                matrix.add(input.toCharArray());
            }
            int maximumNumberOfElements = 0;
            for(int i = 1; i <= matrix.size(); i++) {
                for(int j = 0; j < matrix.size()-i+1; j++) {
                    int currentNumberOfElements = 0;
                    for(int k = 0; k < matrix.size(); k++) {
                        boolean allOnes = true;
                        for(int l = 0; l < i; l++) {
                            if(matrix.get(j+l)[k] != '1') {
                                allOnes = false;
                                break;
                            }
                        }
                        if(allOnes) {
                            currentNumberOfElements += i;
                            maximumNumberOfElements = Math.max(maximumNumberOfElements,currentNumberOfElements);
                        } else {
                            currentNumberOfElements = 0;
                        }
                    }
                }
            }
            out.println(maximumNumberOfElements);
        }
        f.close();
        out.close();
    }
}
