import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        String input;
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        while((input = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            int num_elements = Integer.parseInt(st.nextToken());
            int[] elements = new int[num_elements];
            for(int i = 0; i < num_elements; i++){
                elements[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<Integer> look_for = new ArrayList<>();
            for(int j = 1; j <= num_elements-1; j++){
                look_for.add(j);
            }
            for(int k = 0; k < num_elements-1; k++){
                if(look_for.contains(Math.abs(elements[k+1] - elements[k]))){
                    int index = look_for.indexOf(Math.abs(elements[k+1] - elements[k]));
                    look_for.remove(index);
                }
            }
            if(look_for.size() == 0){
                System.out.println("Jolly");
            }
            else{
                System.out.println("Not jolly");
            }
        }
    }
}
