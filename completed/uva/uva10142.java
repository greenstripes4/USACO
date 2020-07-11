import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        f.readLine();
        for(int t = 0; t < testcases; t++){
            if(t > 0){
                out.println();
            }
            int n = Integer.parseInt(f.readLine());
            String[] candidates = new String[n];
            boolean[] eliminated = new boolean[n];
            ArrayList<int[]> ballots = new ArrayList<>();
            for(int i = 0; i < n; i++){
                candidates[i] = f.readLine();
            }
            while(true){
                String next = f.readLine();
                if(next == null){
                    break;
                }
                StringTokenizer st = new StringTokenizer(next);
                if(st.countTokens() != n){
                    break;
                }
                int[] temp = new int[n];
                for(int i = 0; i < n; i++){
                    temp[i] = Integer.parseInt(st.nextToken())-1;
                }
                ballots.add(temp);
            }
            int half = ballots.size()/2;
            while(true){
                int[] votes = new int[n];
                for(int[] i: ballots){
                    for(int j = 0; j < n; j++){
                        if(!eliminated[i[j]]){
                            votes[i[j]]++;
                            break;
                        }
                    }
                }
                int winner = -1;
                int max = 0;
                int min = 1000;
                for(int i = 0; i < n; i++){
                    if(!eliminated[i]){
                        max = Math.max(max,votes[i]);
                        min = Math.min(min,votes[i]);
                        if(votes[i] > half){
                            winner = i;
                        }
                    }
                }
                if(winner > -1){
                    out.println(candidates[winner]);
                    break;
                } else if(min == max) {
                    for(int i = 0; i < n; i++){
                        if(!eliminated[i]){
                            out.println(candidates[i]);
                        }
                    }
                    break;
                }
                for(int i = 0; i < n; i++){
                    if(votes[i] == min){
                        eliminated[i] = true;
                    }
                }
            }
        }
        f.close();
        out.close();
    }
}
