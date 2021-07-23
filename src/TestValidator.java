import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TestValidator {
    public static boolean isDistinct(Integer arr[]){
        // Put all array elements in a HashSet
        Set<Integer> s = new HashSet<Integer>(Arrays.asList(arr));

        // If all elements are distinct, size of
        // HashSet should be same array.
        return (s.size() == arr.length);
    }

    public static boolean isInRange(Integer arr[], int min, int max) {
        for(int num : arr){
            if(num<min || num>max) return false;
        }
        return true;
    }

    public static boolean isPermutation(Integer arr[], int start) {
        Arrays.sort(arr);
        int cur = start;
        for(int num : arr){
            if(num != cur) return false;
            cur++;
        }
        return true;
    }

    public static HashMap<Integer, Integer> countFreq(Integer arr[])
    {
        HashMap <Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int num : arr) {
            if (hm.containsKey(num))
                hm.put(num, hm.get(num) + 1);
            else hm.put(num, 1);
        }
        return hm;
    }

    // Check whether the numbers in array is even distributed,
    // the difference between max frequency and min frequency should not > gapAllowed
    // the num in excluded are not checked
    public static boolean isEvenDistributed(Integer arr[], Set<Integer> excluded, int gapAllowed){
        if(excluded==null) excluded = new HashSet<>();
        HashMap <Integer, Integer> hm = countFreq(arr);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int key : hm.keySet()){
            if(excluded.contains(key)) continue;
            min = Math.min(min, hm.get(key));
            max= Math.max(max, hm.get(key));
        }
        return (max-min)<=gapAllowed;
    }

    public static Integer[] readIntArray(String line){
        String[] strs = line.split(" ");
        Integer[] result = new Integer[strs.length];
        for(int i=0;i<strs.length;i++){
            result[i] = Integer.parseInt(strs[i]);
        }
        return result;
    }

    // Sample validator for https://codeforces.com/contest/1551/problem/B2
    public static boolean validate(File result) throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader(result));
        String line1 = reader1.readLine();
        Set<Integer> excl = new HashSet<>();
        excl.add(0);
        while (line1 != null){
            Integer[] one = readIntArray(line1);
            if(!isEvenDistributed(one, excl, 0)) return false;
            line1 = reader1.readLine();
        }
        reader1.close();
        return true;
    }
}
