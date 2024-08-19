package com.niantic.part_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuizTests
{
    @Test
    public void getPercentage_calculatesCorrectInteger_usingScoreAndPossiblePoints()
    {
        String studentName = "Sarah";
        int possiblePoints = 100;
        int score = 80;
        int expectedPercent = 80;

        Quiz quiz = new Quiz(possiblePoints, studentName);
        quiz.setScore(score);

        int actualPercent = quiz.getPercent();

        assertEquals(expectedPercent, actualPercent, "Because it should have returned 80.");

    }

    @Test
    public void getLetterGrade_ReturnsCorrectLetterGrade_basedOnQuizPercent()
    {
        String studentName = "Lola";
        int possiblePoints = 100;
        int score = 91;
        String expectedGrade = "A";

        Quiz quiz = new Quiz(possiblePoints, studentName);
        quiz.setScore(score);

        String actualGrade = quiz.getLetterGrade();

        assertEquals(expectedGrade, actualGrade, "It should have returned 'A'.");
    }

    @Test
    public void possiblePointsAndScore_mustBePositive()
    {
        int score = 90;
        int possiblePoints = 100;
        String studentName = "Rose";

        Quiz quiz = new Quiz(possiblePoints, studentName);
        quiz.setScore(score);

        boolean scoreIsPositive = quiz.getScore() > 0;
        boolean possiblePointsIsPositive = quiz.getPossiblePoints() > 0;

        assertTrue(scoreIsPositive, "Score is not positive.");
        assertTrue(possiblePointsIsPositive, "Possible points is positive.");
    }


}