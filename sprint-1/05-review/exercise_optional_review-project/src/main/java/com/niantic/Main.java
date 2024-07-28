package com.niantic;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Main
{
    private static Scanner userInput = new Scanner(System.in);
    private static int[] scores = new int[0];

    public static void main(String[] args)
    {
        while(true)
        {
            int choice = getHomeSelection();

            switch(choice)
            {
                case 1:
                    createNewTestScores();
                    break;
                case 2:
                    calculateAverage();
                    break;
                case 3:
                    findHighestScore();
                    break;
                case 4:
                    findLowestScore();
                    break;
                case 5:
                    System.out.println("Thanks for playing!");
                    System.out.println("Good bye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid selection!");
                    break;
            }
        }
    }

    public static int getHomeSelection()
    {
        System.out.println();
        System.out.println("Welcome to The Test Calculator!");
        System.out.println("------------------------------");
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1) Enter new test scores");
        System.out.println("2) Calculate the class average");
        System.out.println("3) Find the highest score");
        System.out.println("4) Find the lowest score");
        System.out.println("5) Exit");

        System.out.print("Please select an option: ");
        return Integer.parseInt(userInput.nextLine());
//        return userInput.nextInt();
    }

    private static void createNewTestScores()
    {

        System.out.println("Please enter the number of scores: ");

//        int totalNumberOfScores = userInput.nextInt();
        int totalNumberOfScores = Integer.parseInt(userInput.nextLine());

        scores = new int[totalNumberOfScores];

        System.out.println("Please enter the scores, pressing enter after each score: ");
        for(int i=0; i < totalNumberOfScores; i++){
            scores[i] = Integer.parseInt(userInput.nextLine());
//            scores[i] = userInput.nextInt();
        }

        System.out.println(Arrays.toString(scores));
    }

    private static void calculateAverage()
    {

        if(scores.length == 0)
        {
            System.out.println("Please enter test scores first.");
        }
        else {
            int sum = 0;

            for (int score : scores) {
                sum += score;
            }
            double average = (double) sum / scores.length;
            double roundedAverage = Math.round(average);


            System.out.println("The average score is: " + roundedAverage);
        }


    }

    private static void findHighestScore()
    {

        if(scores.length == 0)
        {
            System.out.println("Please enter test scores first.");
        }
        else {
            int maxScore = scores[0];

            for (int score : scores) {
                if (score > maxScore) {
                    maxScore = score;
                }
            }

            System.out.println("The highest score is: " + maxScore);
        }
    }

    private static void findLowestScore()
    {

        if(scores.length == 0)
        {
            System.out.println("Please enter test scores first.");
        }
        else {
            int minScore = scores[0];

            for (int score : scores) {
                if (score < minScore) {
                    minScore = score;
                }
            }

            System.out.println("The minimum score is: " + minScore);
        }
    }
}