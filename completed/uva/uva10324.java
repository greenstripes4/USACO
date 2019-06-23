import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String in;
        int count = 1;
        while((in = f.readLine()) != null && !(in.equals(""))){
            if(!(in.contains(" "))) {
                System.out.println("Case " + count + ":");
                count++;
            }
            char[] input = in.toCharArray();
            int numcases = Integer.parseInt(f.readLine());
            for(int i = 0; i<numcases; i++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                char look_for = input[Math.min(start, end)];
                boolean success = true;
                for(int j = Math.min(start, end) + 1; j<Math.max(start,end)+1; j++){
                    if(input[j] != look_for){
                        success = false;
                        break;
                    }
                }
                if(success){
                    System.out.println("Yes");
                }
                else{
                    System.out.println("No");
                }
            }
        }
        f.close();
    }
}
