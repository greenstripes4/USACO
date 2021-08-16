import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;

public class CFRecommender {
    static Map<String, Integer> staticTagRatings = new HashMap<>();
    static List<String> tagsAsArray = new ArrayList<String>(staticTagRatings.keySet());
    static Random random = new Random();
    static String account = "GoldenShadow";
    static Set<String> needMoreData = new HashSet<>();
    static Set<String> completedProblems = new HashSet<>();
    static HashMap<String, Integer> wrongSubmissions = new HashMap<>();
    static Map<String, TreeMap<Integer, Integer>> acSubmissions = new HashMap<>();
    static HashMap<String, Integer> acTagRatings = new HashMap<>();

    static void printUserStatus(){
        System.out.println("Top 5 weak tags based on WA:");
        int count = 0;
        for(String tag : wrongSubmissions.keySet()){
            System.out.println(tag + " with " + wrongSubmissions.get(tag) + " WAs.");
            count++;
            if(count==5) break;
        }
        System.out.println("-----------------------------");
        System.out.println("Weighted Tag Rating based on ACs:");
        for(String tag : acTagRatings.keySet()){
            System.out.println(tag + " with " + acTagRatings.get(tag) + " rating.");
        }
        System.out.println("-----------------------------");
        System.out.println("Tags without enough data (<10 ACs):");
        for(String tag : needMoreData){
            System.out.println(tag);
        }
    }

    // function to sort hashmap by desc values
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    /*
    {
        status: "OK",
        result: [
            {
                id: 125531611,
                contestId: 705,
                creationTimeSeconds: 1628647676,
                relativeTimeSeconds: 2147483647,
                problem: {
                    contestId: 705,
                    index: "C",
                    name: "Thor",
                    type: "PROGRAMMING",
                    points: 1500,
                    rating: 1600,
                    tags: [
                        "brute force",
                        "data structures",
                        "implementation"
                    ]
                },
                author: {
                    contestId: 705,
                    members: [
                        {
                            handle: "GoldenShadow"
                        }
                    ],
                    participantType: "PRACTICE",
                    ghost: false,
                    startTimeSeconds: 1470578700
                },
                programmingLanguage: "Java 8",
                verdict: "OK",
                testset: "TESTS",
                passedTestCount: 99,
                timeConsumedMillis: 342,
                memoryConsumedBytes: 37888000
            },
            ...
     */
    static void refreshUser() throws IOException{
        String response = URLReader(new URL("https://codeforces.com/api/user.status?handle="+account));
        JSONObject json = new JSONObject(response);
        JSONArray submissions = json.getJSONArray("result");
        for (int i = 0; i < submissions.length(); i++) {
            JSONObject submission = submissions.getJSONObject(i);
            JSONObject problem = submission.getJSONObject("problem");
            if(problem.isNull("tags")) continue;
            JSONArray tags = problem.getJSONArray("tags");
            if(submission.getString("verdict").equals("OK")){
                completedProblems.add(problem.getString("name"));
                if(problem.isNull("rating")){
                    continue;
                }
                int rating = problem.getInt("rating");
                for (int j = 0; j < tags.length(); j++) {
                    String tag = tags.getString(j);
                    if(!acSubmissions.containsKey(tag)){
                        acSubmissions.put(tag, new TreeMap<>(Collections.reverseOrder()));
                    }
                    acSubmissions.get(tag).put(rating, acSubmissions.get(tag).getOrDefault(rating,0)+1);
                }
            } else { //weak
                for (int j = 0; j < tags.length(); j++) {
                    String tag = tags.getString(j);
                    wrongSubmissions.put(tag, wrongSubmissions.getOrDefault(tag,0)+1);
                }
            }
        }
        //calculate weighted AC rating for tags
        for(String tag : acSubmissions.keySet()){
            //Sorted desc by rating
            TreeMap<Integer, Integer> ratedACs = acSubmissions.get(tag);
            int count = 0;
            int sum = 0;
            for(int i : ratedACs.keySet()){
                count += ratedACs.get(i);
                sum += ratedACs.get(i)*i;
                if(count>=25) break;
            }
            if(count<10){
                needMoreData.add(tag);
            } else {
                acTagRatings.put(tag, sum / count);
            }
        }
        //Sort the strong tags by ACs
        acTagRatings = sortByValue(acTagRatings);
        //Sort the weak tags by WAs
        wrongSubmissions = sortByValue(wrongSubmissions);
    }

    static void init(){
        staticTagRatings.put("brute force", 1800);
        staticTagRatings.put("data structures", 1800);
        staticTagRatings.put("implementation", 1800);
        staticTagRatings.put("dfs and similar", 1800);
        staticTagRatings.put("games", 1800);
        staticTagRatings.put("constructive algorithms", 1800);
        staticTagRatings.put("math", 1800);
        staticTagRatings.put("binary search", 1800);
        staticTagRatings.put("sortings", 1800);
        staticTagRatings.put("dp", 1800);
        staticTagRatings.put("number theory", 1800);
        staticTagRatings.put("trees", 1800);
        staticTagRatings.put("bitmasks", 1800);
        staticTagRatings.put("combinatorics", 1800);
        staticTagRatings.put("matrices", 1800);
        staticTagRatings.put("two pointers", 1800);
        staticTagRatings.put("geometry", 1800);
        staticTagRatings.put("graphs", 1800);
        staticTagRatings.put("flows", 1800);
        staticTagRatings.put("graph matchings", 1800);
        staticTagRatings.put("strings", 1800);
        staticTagRatings.put("schedules", 1800);
        staticTagRatings.put("shortest paths", 1800);
        staticTagRatings.put("divide and conquer", 1800);
        staticTagRatings.put("dsu", 1800);
        staticTagRatings.put("probabilities", 1800);
        staticTagRatings.put("hashing", 1800);
        staticTagRatings.put("string suffix structures", 1800);
        staticTagRatings.put("expression parsing", 1800);
        staticTagRatings.put("ternary search", 1800);
        staticTagRatings.put("greedy", 1800);

        tagsAsArray = new ArrayList<String>(staticTagRatings.keySet());
    }

    /*
    {status: "OK",
    result: {
        problems: [
            {
                contestId: 1557,
                index: "D",
                name: "Ezzat and Grid",
                type: "PROGRAMMING",
                points: 2500,
                rating: 2200,
                tags: [
                    "data structures",
                    "dp",
                    "graphs",
                    "greedy"
                ]
            },
            ...
     */
    static Set<String> getProblems(String tag, int minrating, int maxrating, int number) throws IOException {
        Set<String> result = new HashSet<>();
        //String response = URLReader(new URL("https://codeforces.com/api/problemset.problems?tags="+tag.replace(" ", "%20")));
        String response = readWholeFile("cftags/" + tag + ".json");
        JSONObject json = new JSONObject(response);
        JSONArray problems = json.getJSONObject("result").getJSONArray("problems");
        for (int i = 0; i < problems.length(); i++) {
            JSONObject problem = problems.getJSONObject(i);
            if(completedProblems.contains(problem.getString("name")) || problem.isNull("rating"))
                continue;
            int rating = problem.getInt("rating");
            if(rating < minrating || rating > maxrating){
                continue;
            }

            JSONArray tags = problem.getJSONArray("tags");
            for (int j = 0; j < tags.length(); j++) {
                if(tags.getString(j).equalsIgnoreCase(tag)){
                    int contestId = problem.getInt("contestId");
                    String index = problem.getString("index");
                    result.add("https://codeforces.com/problemset/problem/"+contestId+"/"+index + " " + problem.getInt("rating"));
                    break;
                }
            }
            if(result.size()==number){
                break;
            }
        }
        return result;
    }

    static Set<String> getRandomTagProblemFromRating(Map<String, Integer> ratings) throws IOException {
        Set<String> result = new HashSet<>();
        while(result.size() < 10) {
            String tag = tagsAsArray.get(random.nextInt(tagsAsArray.size()));
            if(ratings.containsKey(tag)) {
                int rating = ratings.get(tag);
                result.addAll(getProblems(tag, rating, rating + 100, 1));
            }
        }
        return result;
    }

    static Set<String> getWeakProblems() throws IOException {
        Set<String> result = new HashSet<>();
        int count = 0;
        for(String tag : wrongSubmissions.keySet()){
            int minRating = 1000;
            if(acTagRatings.containsKey(tag)) {
                minRating = (int)(acTagRatings.get(tag)/100) * 100;
            } else if(staticTagRatings.containsKey(tag)){
                minRating = (int)(staticTagRatings.get(tag)/100) * 100;
            }
            //int maxRating = minRating + 100;
            result.addAll(getProblems(tag, minRating, minRating, 2));
            count++;
            if(result.size()>=5) break;
        }
        return result;
    }

    static void outputProblemSet(Set<String> problems){
        for(String problem : problems){
            System.out.println(problem);
        }
    }

    public static String URLReader(URL url) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;

        InputStream in = url.openStream();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        } finally {
            in.close();
        }

        return sb.toString();
    }

    static void refreshLocalCFProblems() throws IOException, InterruptedException {
        for(String tag : tagsAsArray) {
            System.out.println("Fetching CF problem list for " + tag);
            try (PrintWriter out = new PrintWriter("cftags/" + tag + ".json")) {
                String response = URLReader(new URL("https://codeforces.com/api/problemset.problems?tags=" + tag.replace(" ", "%20")));
                out.println(response);
            }
            Thread.sleep(5000);
        }
    }

    private static String readWholeFile(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        init();
        //refreshLocalCFProblems();
        refreshUser();
        printUserStatus();
        System.out.println("Recommend practices based on WA numbers:");
        outputProblemSet(getWeakProblems());
        System.out.println("Recommend practices based on AC ratings:");
        outputProblemSet(getRandomTagProblemFromRating(acTagRatings));
        //outputProblemSet(getRandomTagProblemFromRating(staticTagRatings));
    }
}
