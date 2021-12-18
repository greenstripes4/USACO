package ProblemReviewer;//https://github.com/whypro/Hello-Word
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Reviewer {

    ObjectMapper mapper = new ObjectMapper();
    List<Problem> problems = new ArrayList<>();
    String REVIEW_FILE = "review.json";
    Random random = new Random(System.currentTimeMillis());
    Ebbinghaus ebbinghaus = new Ebbinghaus();
    public int problemsLeft = 0;

    public void saveReview() {
        try{
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(problems);
            try (PrintWriter out = new PrintWriter(REVIEW_FILE)) {
                out.println(jsonString);
            }
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }

    private String readWholeFile(String filePath)
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

    public void loadReview() {
        try{
            String pArray = readWholeFile(REVIEW_FILE);
            CollectionType javaType = mapper.getTypeFactory()
                    .constructCollectionType(List.class, Problem.class);
            problems = mapper.readValue(pArray, javaType);
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }

    public Problem getRandomRecord() {
        List<Problem> needReciteRecords = new ArrayList<>();
        for (Problem r : problems) {
            if (ebbinghaus.needRecite(r)) {
                needReciteRecords.add(r);
            }
        }
        problemsLeft = needReciteRecords.size();
        if (needReciteRecords.size() != 0) {
            int index = random.nextInt(needReciteRecords.size());
            return needReciteRecords.get(index);
        }
        else {
            return null;
        }
    }

    public void addProblem(Problem newProblem){
        for(Problem p : problems){
            if(p.URL.equalsIgnoreCase(newProblem.URL)) {
                p.stage = 0;
                p.strange++;
                p.lastReview = newProblem.lastReview;
                saveReview();
                return;
            }
        }
        problems.add(newProblem);
        saveReview();
    }

    public void updateProblem(Problem oldProblem){
        for(Problem p : problems){
            if(p.stage == oldProblem.stage
            && p.strange == oldProblem.stage
            && p.lastReview.compareTo(oldProblem.lastReview)==0
            && p.firstReview.compareTo(oldProblem.firstReview)==0) {
                p.tags = oldProblem.tags;
                p.title = oldProblem.title;
                p.URL = oldProblem.URL;
                p.note = oldProblem.note;
                saveReview();
                return;
            }
        }
    }

    public void removeProblem(Problem oldProblem){
        problems.remove(oldProblem);
        saveReview();
        return;
    }

    public void init() {
        loadReview();
    }
}
