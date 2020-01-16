package com.example.quantifydemo;

import java.util.ArrayList;
import java.util.List;

public class MarksAndAnswers {
    private int marksObtained;
    private List<CurrentQuestion> answerSheet=new ArrayList<>();
    private String testName;
    private String teacherName;
    private int totalmarks;

    public MarksAndAnswers(){ }

    public MarksAndAnswers(int marksObtained, List<CurrentQuestion> answerSheet, String testName, String teacherName,int totalmarks) {
        this.marksObtained = marksObtained;
        this.answerSheet = answerSheet;
        this.testName = testName;
        this.teacherName = teacherName;
        this.totalmarks=totalmarks;
    }

    public int getTotalmarks() {
        return totalmarks;
    }

    public void setTotalmarks(int totalmarks) {
        this.totalmarks = totalmarks;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(int marksObtained) {
        this.marksObtained = marksObtained;
    }

    public List<CurrentQuestion> getAnswerSheet() {
        return answerSheet;
    }

    public void setAnswerSheet(List<CurrentQuestion> answerSheet) {
        this.answerSheet = answerSheet;
    }
}
