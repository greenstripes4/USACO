import java.io.*;
import java.util.*;

class Person implements Comparable<Person>{
    String name;
    int day;
    int month;
    int year;
    public Person(String name, int day, int month, int year){
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
    @Override
    public int compareTo(Person o){
        if(o.year == this.year){
            if(o.month == this.month){
                return o.day-this.day;
            }
            return o.month-this.month;
        }
        return o.year-this.year;
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        Person[] people = new Person[n];
        for(int i = 0; i < n ; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            people[i] = new Person(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(people);
        out.println(people[0].name);
        out.println(people[people.length-1].name);
        f.close();
        out.close();
    }
}
