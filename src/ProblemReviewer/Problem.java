package ProblemReviewer;

import java.util.Date;

public class Problem {
    String title;
    String tags;
    String URL;
    String note;
    int stage; //每review对一次++，错一次reset
    int strange; // 每做错一次++
    Date firstReview;
    Date lastReview;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getStrange() {
        return strange;
    }

    public void setStrange(int strange) {
        this.strange = strange;
    }

    public Date getFirstReview() {
        return firstReview;
    }

    public void setFirstReview(Date firstReview) {
        this.firstReview = firstReview;
    }

    public Date getLastReview() {
        return lastReview;
    }

    public void setLastReview(Date lastReview) {
        this.lastReview = lastReview;
    }

    public Problem() {
    }

    public Problem(String title, String URL, String tags) {
        this.title = title;
        this.URL = URL;
        this.tags = tags;
        this.firstReview = java.util.Calendar.getInstance().getTime();
        this.lastReview = java.util.Calendar.getInstance().getTime();
        this.note = "";
        this.stage = 0;
        this.strange = 0;
    }
}
