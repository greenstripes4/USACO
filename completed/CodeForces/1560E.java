import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            char[] t = f.readLine().toCharArray();
            Character[] order = new Character[26];
            for(int i = 0; i < 26; i++) {
                order[i] = (char) ('a'+i);
            }
            int[] occ = new int[26];
            int[] last = new int[26];
            for(int i = 0; i < t.length; i++) {
                last[t[i]-'a'] = i;
                occ[t[i]-'a']++;
            }
            Arrays.sort(order, new Comparator<Character>() {
                @Override
                public int compare(Character character, Character t1) {
                    return last[character-'a']-last[t1-'a'];
                }
            });
            StringBuilder sb = new StringBuilder();
            for(char i: order) {
                if(occ[i-'a'] > 0) {
                    sb.append(i);
                }
            }
            HashMap<Character, Integer> map = new HashMap<>();
            boolean flag = false;
            for(int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if(occ[c-'a']%(i+1) != 0) {
                    flag = true;
                    break;
                }
                map.put(c, occ[c-'a']/(i+1));
            }
            if(flag) {
                out.println(-1);
            } else {
                StringBuilder res = new StringBuilder();
                int i = 0;
                while(i < t.length && !map.isEmpty()) {
                    if(!map.containsKey(t[i])) {
                        flag = true;
                        break;
                    }
                    res.append(t[i]);
                    map.put(t[i], map.get(t[i])-1);
                    if(map.get(t[i]) == 0) {
                        map.remove(t[i]);
                    }
                    i++;
                }
                if(flag || !map.isEmpty()) {
                    out.println(-1);
                } else {
                    String cur = res.toString();
                    StringBuilder temp = new StringBuilder();
                    for(char j: sb.toString().toCharArray()) {
                        temp.append(cur);
                        cur = cur.replaceAll(""+j, "");
                    }
                    if(!Arrays.equals(temp.toString().toCharArray(), t)) {
                        out.println(-1);
                    } else {
                        out.println(res + " " + sb);
                    }
                }
            }
        }
        f.close();
        out.close();
    }
}
