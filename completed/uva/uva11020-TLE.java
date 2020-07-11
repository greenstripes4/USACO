import java.io.*;
import java.util.*;

class Groom{
    int L;
    int C;
    public Groom(int L, int C){
        this.L = L;
        this.C = C;
    }
}

public class Main{
    private static boolean isDominated(Groom A, Groom B){
        return (B.L < A.L && B.C <= A.C) || (B.C < A.C && B.L <= A.L);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int i = 0; i < N; i++){
            if(i > 0){
                out.println();
            }
            out.println("Case #" + (i+1) + ":");
            int n = Integer.parseInt(f.readLine());
            LinkedList<Groom> efficientGrooms = new LinkedList<>();
            for(int j = 0; j < n; j++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                int L = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                Groom groom = new Groom(L,C);
                boolean add = true;
                LinkedList<Groom> dominatedGrooms = new LinkedList<>();
                for(Groom k: efficientGrooms){
                    if(isDominated(groom,k)){
                        add = false;
                    } else if(isDominated(k,groom)) {
                        dominatedGrooms.add(k);
                    }
                }
                if(add){
                    efficientGrooms.add(groom);
                }
                for(Groom k: dominatedGrooms){
                    efficientGrooms.remove(k);
                }
                out.println(efficientGrooms.size());
            }
        }
        f.close();
        out.close();
    }
}
