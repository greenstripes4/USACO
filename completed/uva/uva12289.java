import java.io.*;
//O(1)
//owe
//too
//theee
//one
//two
//three

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < cases; i++){
            String n = f.readLine();
            if(n.length() == 5){
                System.out.println(3);
            }
            else{
                char[] c = n.toCharArray();
                int count1 = 0;
                char[] one = {'o','n','e'};
                for(int j = 0; j < 3; j++){
                    if(c[j] != one[j]){
                        count1++;
                    }
                }
                if(count1 <= 1){
                    System.out.println(1);
                }
                else{
                    System.out.println(2);
                }
            }
        }
    }
}
