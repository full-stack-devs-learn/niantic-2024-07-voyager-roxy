package com.niantic.ui;

import com.niantic.models.Assignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserInput
{
    protected static Scanner in = new Scanner(System.in);

    public static int homeScreenSelection()
    {
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println("-".repeat(40));
        System.out.println();
        System.out.println("  1) Display files");
        System.out.println();
        System.out.println("  ------------ Individual File ------------");
        System.out.println("  2) Student: display all scores");
        System.out.println("  3) Student: display average score");
        System.out.println();
        System.out.println("  ---------- Challenge All Files ----------");
        System.out.println("  5) All Students: display average score");
        System.out.println("  6) All Assignments: display average score");
        System.out.println();
        System.out.println("  0) Exit");

        System.out.println();
        System.out.print("Please make a selection: ");

        return Integer.parseInt(in.nextLine());
    }

    public static int fileSelection()
    {
        System.out.println();
        System.out.println("-".repeat(40));
        System.out.print("Please select a file by the student number: ");

        return Integer.parseInt(in.nextLine());
    }

    public static void displayFiles(String[] fileNames)
    {
        System.out.println();
        System.out.println("Files:");
        System.out.println("-".repeat(40));
        for(String fileName : fileNames)
        {
            System.out.println(fileName);
        }

        System.out.println();
        System.out.print("Press enter to go back to the home screen...");
        in.nextLine();
    }

    public static void displayFilesForIndividualScores(String[] fileNames)
    {
        System.out.println();
        System.out.println("Files:");
        System.out.println("-".repeat(40));
        for(String fileName : fileNames)
        {
            System.out.println(fileName);
        }
    }

    public static void displayAssignment(List<Assignment> assignments)
    {
        System.out.println("-".repeat(40));
        System.out.println("Student: " + assignments.getFirst().getFirstName().substring(0,1).toUpperCase() +
                assignments.getFirst().getFirstName().substring(1) + " " +
                assignments.getFirst().getLastName().substring(0,1).toUpperCase() +
                assignments.getFirst().getLastName().substring(1));
        System.out.println("-".repeat(40));
        for (Assignment assignment : assignments)
        {
            System.out.println(assignment);
        }
        System.out.println();
        System.out.println("Press enter to return to home selection...");
        in.nextLine();
    }

    public static void displayAverages(List<Assignment> assignments)
    {
        System.out.println("-".repeat(40));
        System.out.println("Student: " + assignments.getFirst().getFirstName().substring(0,1).toUpperCase() +
                assignments.getFirst().getFirstName().substring(1) + " " +
                assignments.getFirst().getLastName().substring(0,1).toUpperCase() +
                assignments.getFirst().getLastName().substring(1));
        System.out.println("-".repeat(40));
        System.out.println("Low Score: " + assignments.stream()
                .min(Comparator.comparingInt(Assignment::getScore))
                .map(Assignment::getScore).orElse(-1));
        System.out.println("High Score: " + + assignments.stream()
                .max(Comparator.comparingInt(Assignment::getScore))
                .map(Assignment::getScore).orElse(-1));
        System.out.println("Average Score: " + assignments.stream()
                .mapToInt(Assignment::getScore)
                .average().orElse(-1));
        System.out.println();
        System.out.println("Press enter to return to home selection...");
        in.nextLine();
    }

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
    }
}
