import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
O(n^2)
3 1000 2 3
200
0 2 2
300
27 3 20
5 2000 2 4
300
4 3 0 4
450
7 8 0 13
1 1 1 1
1
0
200 500000 1 3
10000
1000 300 600
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while((input = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            int guests = Integer.parseInt(st.nextToken());
            int budget = Integer.parseInt(st.nextToken());
            int hotels = Integer.parseInt(st.nextToken());
            int available_weeks = Integer.parseInt(st.nextToken());
            ArrayList<Integer> possible_prices = new ArrayList<>();
            for(int i = 0; i < hotels; i++){
                int price_per_person = Integer.parseInt(f.readLine());
                StringTokenizer info = new StringTokenizer(f.readLine());
                int[] weekends = new int[available_weeks];
                for(int j = 0; j < available_weeks; j++){
                    weekends[j] = Integer.parseInt(info.nextToken());
                }
                for(int p: weekends){
                    if(p < guests || guests*price_per_person > budget){
                        continue;
                    }
                    possible_prices.add(guests*price_per_person);
                }
            }
            if(possible_prices.size() == 0){
                System.out.println("stay home");
            }
            else{
                int min = possible_prices.get(0);
                for(int price: possible_prices){
                    if(price < min){
                        min = price;
                    }
                }
                System.out.println(min);
            }
        }
    }
}