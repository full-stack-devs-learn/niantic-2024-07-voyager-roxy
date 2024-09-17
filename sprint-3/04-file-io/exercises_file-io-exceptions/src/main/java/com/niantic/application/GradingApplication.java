package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.services.GradesFileService;
import com.niantic.services.GradesService;
import com.niantic.ui.UserInput;

import java.io.DataOutput;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class GradingApplication implements Runnable
{
    private GradesService gradesService = new GradesFileService();

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
                    displayAllStudentStatistics();
                    break;
                case 5:
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
        File file = new File("files");

        String[] fileNames = file.list();
        for(String fileName : fileNames)
        {
            System.out.println(fileName);
        }
    }

    private void displayFileScores()
    {
        // todo: 2 - allow the user to select a file name
        // load all student assignment scores from the file - display all files
        File file = new File("files");

        String [] files = file.list();

        for(String fileName : files)
        {
            System.out.println(fileName);
        }

        int choice = UserInput.fileSelection();
        String stringNumber = String.valueOf(choice);

        for(String fileName : files)
        {
            if(fileName.contains(stringNumber))
            {
                List<Assignment> assignments = gradesService.getAssignments(fileName);
                System.out.println("Student: " + assignments.getFirst().getFirstName().substring(0,1).toUpperCase() +
                        assignments.getFirst().getFirstName().substring(1) + " " +
                        assignments.getFirst().getLastName().substring(0,1).toUpperCase() + assignments.getFirst().getLastName().substring(1));
                for (Assignment assignment : assignments)
                {
                    System.out.println(assignment.getAssignmentName());
                    System.out.println(assignment.getScore());
                }
            }
        }

    }

    private void displayStudentAverages()
    {
        // todo: 3 - allow the user to select a file name
        // load all student assignment scores from the file - display student statistics (low score, high score, average score)
        File file = new File("files");

        String [] files = file.list();

        for(String fileName : files)
        {
            System.out.println(fileName);
        }

        int choice = UserInput.fileSelection();
        String stringNumber = String.valueOf(choice);

        for(String fileName : files)
        {
            if(fileName.contains(stringNumber))
            {
                List<Assignment> assignments = gradesService.getAssignments(fileName);
                System.out.println("Student: " + assignments.getFirst().getFirstName().substring(0,1).toUpperCase() +
                        assignments.getFirst().getFirstName().substring(1) + " " +
                        assignments.getFirst().getLastName().substring(0,1).toUpperCase() + assignments.getFirst().getLastName().substring(1));
                System.out.println("Low Score: " + assignments.stream().mapToInt(Assignment::getScore).min().orElse(-1));
                System.out.println("High Score: " + assignments.stream().mapToInt(Assignment::getScore).max().orElse(-1));
                System.out.println("Average Score: " + assignments.stream().mapToInt(Assignment::getScore).average().orElse(-1));
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

    private String parseStudentName(String fileName)
    {
        return fileName.replace(".csv", "")
                        .replace("_", " ")
                        .substring(10);
    }
}
