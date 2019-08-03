import java.io.*;
/*
O(1)
4

01/01/2007
10/02/2007

09/06/2007
28/02/1871

12/11/2007
01/01/1984

28/02/2005
29/02/2004
*/

public class Main {
    public static void main (String args[]) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int numTestCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < numTestCases; i++){
            f.readLine();
            String now = f.readLine();
            String birth = f.readLine();
            String[] n = now.split("/");
            String[] b = birth.split("/");
            int diff = Integer.parseInt(n[2]) - Integer.parseInt(b[2]);
            int diff2 = Integer.parseInt(n[1]) - Integer.parseInt(b[1]);
            int diff3 = Integer.parseInt(n[0]) - Integer.parseInt(b[0]);
            if((diff2 < 0) || (diff2 == 0 && diff3 < 0)){
                diff--;
            }
            if(diff < 0){
                System.out.println("Case #" + (i + 1) + ": Invalid birth date");
            }
            else if(diff > 130){
                System.out.println("Case #" + (i + 1) + ": Check birth date");
            }
            else{
                System.out.println("Case #" + (i + 1) + ": " + diff);
            }
        }
    }
}
