import java.io.*;
import java.util.*;

class Category {
    String name;
    HashSet<String> keywords;
    int P;
    Category(String name, HashSet<String> keywords, int P) {
        this.name = name;
        this.keywords = keywords;
        this.P = P;
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int t = 0; t < N; t++) {
            int C = Integer.parseInt(f.readLine());
            Category[] categories = new Category[C];
            for(int i = 0; i < C; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine().replaceAll(" +"," "));
                String name = st.nextToken();
                int W = Integer.parseInt(st.nextToken());
                HashSet<String> keywords = new HashSet<>();
                int P = Integer.parseInt(st.nextToken());
                for(int j = 0; j < W; j++) {
                    keywords.add(f.readLine().replaceAll(" +",""));
                }
                categories[i] = new Category(name,keywords,P);
            }
            int[] keywordCount = new int[C];
            String nextLine;
            while((nextLine = f.readLine()) != null && nextLine.length() > 0) {
                nextLine = nextLine.replaceAll("[^a-zA-Z]"," ");
                StringTokenizer st = new StringTokenizer(nextLine);
                while(st.hasMoreTokens()) {
                    String word = st.nextToken();
                    for(int i = 0; i < C; i++) {
                        HashSet<String> keywords = categories[i].keywords;
                        if(keywords.contains(word)) {
                            keywordCount[i]++;
                            keywords.remove(word);
                        }
                    }
                }
            }
            boolean isSQF = true;
            for(int i = 0; i < C; i++) {
                if(keywordCount[i] >= categories[i].P) {
                    out.print((isSQF ? "" : ",") + categories[i].name);
                    isSQF = false;
                }
            }
            out.println(isSQF ? "SQF Problem." : "");
        }
        f.close();
        out.close();
    }
}