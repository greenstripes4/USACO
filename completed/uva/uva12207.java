import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int caseNumber = 1;
        while(true){
            int P = f.nextInt();
            int C = f.nextInt();
            if(P == 0 && C == 0){
                break;
            }
            out.println("Case " + caseNumber + ":");
            ArrayList<Integer> population = new ArrayList<>();
            for(int i = 1; i <= Math.min(P,C); i++){
                population.add(i);
            }
            for(int i = 0; i < C; i++){
                char command = f.next().charAt(0);
                if(command == 'N'){
                    int next = population.remove(0);
                    out.println(next);
                    population.add(next);
                } else {
                    int expedited = f.nextInt();
                    if(population.contains(expedited)) {
                        population.remove(population.indexOf(expedited));
                    }
                    population.add(0,expedited);
                }
            }
            caseNumber++;
        }
        f.close();
        out.close();
    }
}
