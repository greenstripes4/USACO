import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int c = 1;
        while((input = f.readLine()) != null) {
            if(c != 1){
                System.out.println();
            }
            HashMap<String, Integer> money_list = new HashMap<>();
            int number_of_people = Integer.parseInt(input);
            String[] people = new String[number_of_people];
            StringTokenizer st = new StringTokenizer(f.readLine());
            for (int i = 0; i < number_of_people; i++) {
                String giver = st.nextToken();
                money_list.put(giver, 0);
                people[i] = giver;
            }
            for (int i = 0; i < number_of_people; i++) {
                StringTokenizer s = new StringTokenizer(f.readLine());
                String name = s.nextToken();
                int transaction = Integer.parseInt(s.nextToken());
                int shared_people = Integer.parseInt(s.nextToken());
                if(shared_people == 0){
                    continue;
                }
                money_list.replace(name, money_list.get(name) - transaction);
                for (int j = 0; j < shared_people; j++) {
                    String person = s.nextToken();
                    money_list.replace(person, money_list.get(person) + (transaction / shared_people));
                }
                if (shared_people != 0) {
                    money_list.replace(name, money_list.get(name) + (transaction % shared_people));
                }
            }
            for (String k : people) {
                System.out.println(k + " " + money_list.get(k));
            }
            c = 2;
        }
        f.close();
    }
}
