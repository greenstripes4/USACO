import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        ArrayList<Integer> arrayList = new ArrayList<>();
        String input;
        while((input = f.readLine()) != null){
            arrayList.add(Integer.parseInt(input.trim()));
            Collections.sort(arrayList);
            if(arrayList.size()%2 == 1){
                int ind = (int) (arrayList.size()/2.0 - 0.5);
                System.out.println(arrayList.get(ind));
            }
            else{
                int ind1 = arrayList.size()/2 - 1;
                int ind2 = arrayList.size()/2;
                System.out.println((arrayList.get(ind1) + arrayList.get(ind2))/2);
            }
        }
    }
}
