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
        int excuseSet = 1;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int K = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            HashSet<String> keywords = new HashSet<>();
            for(int i = 0; i < K; i++) {
                keywords.add(f.readLine());
            }
            String[] sentences = new String[E];
            String[][] excuses = new String[E][];
            int maxKeywords = 0;
            for(int i = 0; i < E; i++) {
                String original = f.readLine();
                String[] formattedWords = original.toLowerCase().replaceAll("[\"'.,!?0-9]"," ").replaceAll(" +"," ").split(" ");
                sentences[i] = original;
                excuses[i] = formattedWords;
                int keywordCount = 0;
                for(String j: formattedWords) {
                    if(keywords.contains(j)) {
                        keywordCount++;
                    }
                }
                maxKeywords = Math.max(maxKeywords,keywordCount);
            }
            out.println("Excuse Set #" + excuseSet);
            for(int i = 0; i < E; i++) {
                int keywordCount = 0;
                for(String j: excuses[i]) {
                    if(keywords.contains(j)) {
                        keywordCount++;
                    }
                }
                if(keywordCount == maxKeywords) {
                    out.println(sentences[i]);
                }
            }
            out.println();
            excuseSet++;
        }
        f.close();
        out.close();
    }
}
