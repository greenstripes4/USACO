import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(f.readLine());
            HashMap<String,Integer> comfortableSubjects = new HashMap<>();
            for(int j = 0; j < N; j++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                String subject = st.nextToken();
                int days = Integer.parseInt(st.nextToken());
                comfortableSubjects.put(subject,days);
            }
            int D = Integer.parseInt(f.readLine());
            String subject = f.readLine();
            if(!comfortableSubjects.containsKey(subject) || comfortableSubjects.get(subject) > D+5){
                out.println("Case " + (i+1) + ": Do your own homework!");
            } else if(comfortableSubjects.get(subject) > D) {
                out.println("Case " + (i+1) + ": Late");
            } else {
                out.println("Case " + (i+1) + ": Yesss");
            }
        }
        f.close();
        out.close();
    }
}
