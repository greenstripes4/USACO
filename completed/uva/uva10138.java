import java.io.*;
import java.util.*;

public class Main {
    private static class Record implements Comparable<Record> {
        private String license;
        private int month;
        private int day;
        private int hour;
        private int minute;
        private boolean type;
        private int distance;
        private Record(String license, String time, String type, int distance) {
            this.license = license;
            String[] arr = time.split(":");
            this.month = Integer.parseInt(arr[0]);
            this.day = Integer.parseInt(arr[1]);
            this.hour = Integer.parseInt(arr[2]);
            this.minute = Integer.parseInt(arr[3]);
            this.type = type.equals("enter");
            this.distance = distance;
        }
        @Override
        public int compareTo(Record o) {
            if(month == o.month) {
                if(day == o.day) {
                    if(hour == o.hour) {
                        if(minute == o.minute) {
                            return 0;
                        }
                        return minute-o.minute;
                    }
                    return hour-o.hour;
                }
                return day-o.day;
            }
            return month-o.month;
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        f.readLine();
        for(int t = 0; t < T; t++) {
            if(t > 0) {
                out.println();
            }
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] rate = new int[24];
            for(int i = 0; i < 24; i++) {
                rate[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<Record> records = new ArrayList<>();
            String input;
            while((input = f.readLine()) != null && input.length() > 0) {
                st = new StringTokenizer(input);
                records.add(new Record(st.nextToken(), st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(records);
            HashMap<String, int[]> map = new HashMap<>();
            TreeMap<String, Integer> total = new TreeMap<>();
            for(Record i: records) {
                if(i.type) {
                    map.put(i.license, new int[]{rate[i.hour], i.distance});
                } else if (map.containsKey(i.license)) {
                    int[] temp = map.get(i.license);
                    total.put(i.license, total.getOrDefault(i.license, 0)+temp[0]*Math.abs(i.distance-temp[1])+100);
                    map.remove(i.license);
                }
            }
            for(String i: total.keySet()) {
                out.println(i + " $"  + String.format("%.2f", total.get(i)/100.0+2));
            }
        }
        f.close();
        out.close();
    }
}