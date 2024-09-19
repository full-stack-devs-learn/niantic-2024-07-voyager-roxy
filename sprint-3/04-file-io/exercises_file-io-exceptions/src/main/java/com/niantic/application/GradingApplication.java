package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.models.StudentStatistics;
import com.niantic.services.GradesFileService;
import com.niantic.services.GradesService;
import com.niantic.services.ReportService;
import com.niantic.ui.UserInput;

import java.io.DataOutput;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GradingApplication implements Runnable
{
    private GradesService gradesService = new GradesFileService();
    private final UserInput ui = new UserInput();

    public void run()
    {
        while(true)
        {
            int choice = UserInput.homeScreenSelection();
            switch(choice)
            {
                case 1:
                    displayAllFiles();
                    break;
                case 2:
                    displayFileScores();
                    break;
                case 3:
                    displayStudentAverages();
                    break;
                case 4:
                    createStudentSummaryReport();
                    break;
                case 5:
                    createAllStudentsReport();
                    break;
                case 6:
                    displayAllStudentStatistics();
                    break;
                case 7:
                    displayAssignmentStatistics();
                    break;
                case 0:
                    UserInput.displayMessage("Goodbye");
                    System.exit(0);
                default:
                    UserInput.displayMessage("Please make a valid selection");
            }
        }
    }

    private void displayAllFiles()
    {
        // todo: 1 - get and display all student file names
        String[] fileNames = gradesService.getFileNames();

        String[] sortedFileNames = Arrays.stream(fileNames)
                                            .sorted(Comparator.comparingInt(this::parseStudentNumber))
                                            .toArray(String[]::new);

        UserInput.displayFiles(sortedFileNames);
    }

    private void displayFileScores()
    {
        // todo: 2 - allow the user to select a file name
        // load all student assignment scores from the file - display all files
        String[] fileNames = gradesService.getFileNames();

        String[] sortedFileNames = Arrays.stream(fileNames)
                .sorted(Comparator.comparingInt(this::parseStudentNumber))
                .toArray(String[]::new);

        UserInput.displayFilesForIndividualScores(sortedFileNames);

        int choice = UserInput.fileSelection();
        String stringNumber = String.valueOf(choice);

        for(String fileName : fileNames)
        {
            if(fileName.contains(stringNumber))
            {
                List<Assignment> assignments = gradesService.getAssignments(fileName);
                UserInput.displayAssignment(assignments);
            }
        }
    }

    private void displayStudentAverages()
    {
        // todo: 3 - allow the user to select a file name
        // load all student assignment scores from the file - display student statistics (low score, high score, average score)
        String[] fileNames = gradesService.getFileNames();

        String[] sortedFileNames = Arrays.stream(fileNames)
                .sorted(Comparator.comparingInt(this::parseStudentNumber))
                .toArray(String[]::new);

        UserInput.displayFilesForIndividualScores(sortedFileNames);

        int choice = UserInput.fileSelection();
        String stringNumber = String.valueOf(choice);

        for(String fileName : fileNames)
        {
            if(fileName.contains(stringNumber))
            {
                List<Assignment> assignments = gradesService.getAssignments(fileName);
                UserInput.displayAverages(assignments);
            }
        }
    }

    private void displayAllStudentStatistics()
    {
        // todo: 4 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for all scores (low score, high score, average score, number of students, number of assignments)
    }

    private void displayAssignmentStatistics()
    {
        // todo: 5 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for each assignment (assignment name, low score, high score, average score)
        // this one could take some time
    }

    public void createStudentSummaryReport()
    {
        displayAllFiles();

        int choice = UserInput.fileSelection();
        String stringNumber = String.valueOf(choice);

        var files = gradesService.getFileNames();


        for(String fileName : files)
        {
            if(fileName.contains(stringNumber))
            {
                var studentName = parseStudentName(fileName);

                List<Assignment> assignments = gradesService.getAssignments(fileName);
                StudentStatistics statistics = new StudentStatistics(assignments, studentName);

                ReportService service = new ReportService();

                service.createStudentSummaryReport(statistics);
            }
        }
    }

    public void createAllStudentsReport()
    {

    }

    private String parseStudentName(String fileName)
    {
        return fileName.replace(".csv", "")
                        .replace("_", " ")
                        .substring(10);
    }

    private int parseStudentNumber(String fileName)
    {
        return Integer.parseInt(fileName.substring(8,9));
    }
}
