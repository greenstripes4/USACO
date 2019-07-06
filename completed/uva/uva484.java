import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        ArrayList<Integer> nums = new ArrayList<>();
        while((input = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            while(st.hasMoreTokens()){
                nums.add(Integer.parseInt(st.nextToken()));
            }
        }
        ArrayList<Integer> already_passed = new ArrayList<>();
        for(int i: nums){
            if(already_passed.contains(i)){
                continue;
            }
            int count = 0;
            for(int j: nums){
                if(j == i){
                    count++;
                }
            }
            System.out.println(i + " " + count);
            already_passed.add(i);
        }
    }
}
