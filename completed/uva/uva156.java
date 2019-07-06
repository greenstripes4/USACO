import java.util.*;
public class Main {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        while(true){
            String in = s.next();
            if (in.equals("#")){
                break;
            }
            char[] str = in.toUpperCase().toCharArray();
            Arrays.sort(str);
            String sorted = "";
            for (int i = 0; i < str.length; ++i) {
                sorted += str[i];
            }
            if (map.containsKey(sorted)) {
                ArrayList<String> list = map.get(sorted);
                list.add(in);
                map.put(sorted, list);
            }
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(in);
                map.put(sorted, list);
            }
        }
        ArrayList<String> words = new ArrayList<String>();
        for (ArrayList<String> stringList : map.values()) {
            if (stringList.size() == 1) {
                words.add(stringList.get(0));
            }
        }
        Collections.sort(words);
        for (String str : words) {
            System.out.println(str);
        }
    }
}
