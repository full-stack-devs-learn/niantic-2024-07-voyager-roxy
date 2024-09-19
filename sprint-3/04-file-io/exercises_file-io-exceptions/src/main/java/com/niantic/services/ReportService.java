package com.niantic.services;

import com.niantic.application.GradingApplication;
import com.niantic.models.Assignment;
import com.niantic.models.StudentStatistics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReportService {
    public void createStudentSummaryReport(StudentStatistics statistics)
    {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fileName = "reports/" + today.format(formatter) + "_" + statistics.getStudentName().replace(" ", "_") + ".txt";

        File file = new File(fileName);

        try (PrintWriter out = new PrintWriter(file))
        {
            out.println(statistics.getStudentName());
            out.println("-".repeat(30));
            out.println("Low Score                " + statistics.getLowScore());
            out.println("High Score               " + statistics.getHighScore());
            out.println("Average Score            " + statistics.getAverageScore());
        }
        catch (FileNotFoundException e)
        {

        }
    }

    public void createAllStudentsSummaryReport(StudentStatistics statistics)
    {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fileName = "reports/" + today.format(formatter) + "_all_students.txt";

        File file = new File(fileName);

        try (PrintWriter out = new PrintWriter(file))
        {
            out.println("All Assignments");
            out.println("-".repeat(50));
            out.println("Total Students                " + statistics.getTotalStudents());
            out.println("Total Assignments             " + statistics.getTotalAssignments());
            out.println("-".repeat(50));
            out.println("Low Score                     " + statistics.getLowScore());
            out.println("High Score                    " + statistics.getHighScore());
            out.println("Average Score                 " + statistics.getAverageScore());
        }
        catch (FileNotFoundException e)
        {

        }
    }
}
