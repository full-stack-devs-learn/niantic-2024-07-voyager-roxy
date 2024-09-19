package com.niantic.models;

import java.util.List;

public class StudentStatistics {
    private List<Assignment> assignmentList;
    private String studentName;

    public StudentStatistics(List<Assignment> assignmentList, String studentName)
    {
        this.assignmentList = assignmentList;
        this.studentName = studentName;
    }

    public StudentStatistics(List<Assignment> assignmentList)
    {
        this.assignmentList = assignmentList;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public int getLowScore()
    {
        return assignmentList.stream()
                .mapToInt(Assignment::getScore).min().getAsInt();
    }

    public int getHighScore()
    {
        return assignmentList.stream()
                .mapToInt(Assignment::getScore).max().getAsInt();
    }

    public double getAverageScore()
    {
        return assignmentList.stream()
                .mapToDouble(Assignment::getScore).average().getAsDouble();
    }

    public int getTotalAssignments()
    {
        return assignmentList.size() / getTotalStudents();
    }

    public int getTotalStudents()
    {
        return (int) assignmentList.stream().map(student -> student.getFirstName() + " " + student.getLastName())
                .distinct().count();
    }

}
