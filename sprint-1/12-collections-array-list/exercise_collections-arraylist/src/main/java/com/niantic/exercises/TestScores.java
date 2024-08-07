package com.niantic.exercises;

import com.niantic.models.TestScore;

import java.util.ArrayList;

public class TestScores
{

    /*
    1.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores and the name of a test - return all scores for the
        requested tests.
     */
    public ArrayList<TestScore> getScoresByTest(ArrayList<TestScore> testScores, String testName)
    {
        ArrayList<TestScore> matchingScores = new ArrayList<>();

        for(var score : testScores)
        {
            if (score.getTestName().equals(testName))
            {
                matchingScores.add(score);
            }
        }
        return matchingScores;
    }

    /*
    2.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores and the name of a student - return all scores for the
        requested student.
     */
    public ArrayList<TestScore> getScoresByStudent(ArrayList<TestScore> testScores, String student)
    {
        ArrayList<TestScore> requestedStudentScores = new ArrayList<>();

        for (var score : testScores)
        {
            if (score.getStudentName().equals(student))
            {
                requestedStudentScores.add(score);
            }
        }

        return requestedStudentScores;
    }

    /*
    3.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score.
     */
    public int getHighestScore(ArrayList<TestScore> testScores)
    {
        int maxScore = testScores.getFirst().getScore();

        for (var score : testScores)
        {
            if (score.getScore() > maxScore)
            {
                maxScore = score.getScore();
            }
        }
        return maxScore;
    }

    /*
    4.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score.
     */
    public int getLowestScore(ArrayList<TestScore> testScores)
    {
        int minScore = testScores.getFirst().getScore();

        for (var score : testScores)
        {
            if (score.getScore() < minScore)
            {
                minScore = score.getScore();
            }
        }
        return minScore;
    }

    /*
    5.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score.
     */
    public int getAverageScore(ArrayList<TestScore> testScores)
    {
        int average;
        int sum = 0;

        for(var score : testScores)
        {
            sum += score.getScore();
        }

        average = sum / testScores.size();
        return average;
    }

    /*
    6.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score for the specified test name.
     */
    public int getHighestScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        ArrayList<TestScore> studentScores = new ArrayList<>();

        for (var score: testScores) {
            if (score.getTestName().equals(testName)) {
                studentScores.add(score);
            }
        }
        int maxScore = studentScores.getFirst().getScore();
        for (var studentScore: studentScores)
        {
            if (studentScore.getScore() > maxScore)
            {
                maxScore = studentScore.getScore();
            }
        }
        return maxScore;
    }

    /*
    7.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score for the specified test name.
     */
    public int getLowestScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        ArrayList<TestScore> studentScores = new ArrayList<>();

        for (var score: testScores) {
            if (score.getTestName().equals(testName)) {
                studentScores.add(score);
            }
        }
        int minScore = studentScores.getFirst().getScore();
        for (var studentScore: studentScores)
        {
            if (studentScore.getScore() < minScore)
            {
                minScore = studentScore.getScore();
            }
        }
        return minScore;
    }

    /*
    8.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score for the specified test name.
     */
    public int getAverageScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        int average;
        int sum = 0;

        ArrayList<TestScore> matchingTests = new ArrayList<>();

        for (var score : testScores) {
            if (score.getTestName().equals(testName))
            {
                sum += score.getScore();
                matchingTests.add(score);
            }
        }

        average = sum / matchingTests.size();

        return average;
    }

    /*
    9.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score for the specified student.
     */
    public int getHighestScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        ArrayList<TestScore> studentScores = new ArrayList<>();

        for (var score: testScores) {
            if (score.getStudentName().equals(student)) {
                studentScores.add(score);
            }
        }
        int maxScore = studentScores.getFirst().getScore();
        for (var studentScore: studentScores)
        {
            if (studentScore.getScore() > maxScore)
            {
                maxScore = studentScore.getScore();
            }
        }
        return maxScore;
    }

    /*
    10.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score for the specified student.
     */
    public int getLowestScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        ArrayList<TestScore> studentScores = new ArrayList<>();

        for (var score: testScores) {
            if (score.getStudentName().equals(student)) {
                studentScores.add(score);
            }
        }
        int minScore = studentScores.getFirst().getScore();
            for (var studentScore: studentScores)
            {
                if (studentScore.getScore() < minScore)
                {
                    minScore = studentScore.getScore();
                }
            }
        return minScore;
    }

    /*
    11.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score for the specified student.
     */
    public int getAverageScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        int sum = 0;
        int average;

        ArrayList<TestScore> studentScores = new ArrayList<>();

        for(var score: testScores)
        {
            if (score.getStudentName().equals(student))
            {
                sum += score.getScore();
                studentScores.add(score);
            }
        }

        average = sum / studentScores.size();

        return average;
    }
}
