package com.gl.pojo;

public class Respondent {
    private String name;
    private int score;
    private String introduce;
    private String projectID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public Respondent(String name, int score, String introduce, String projectID) {
        this.name = name;
        this.score = score;
        this.introduce = introduce;
        this.projectID = projectID;
    }

    public Respondent() {
    }
}
