import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while(!((input = f.readLine()).equals("0 0"))){
            HashSet<Integer> cds = new HashSet<>();
            StringTokenizer st = new StringTokenizer(input);
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            for(int i = 0; i<c1; i++) {
                cds.add(Integer.parseInt(f.readLine()));
            }
            int count = 0;
            for(int j = 0; j<c2; j++){
                int item = Integer.parseInt(f.readLine());
                if(cds.contains(item)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
