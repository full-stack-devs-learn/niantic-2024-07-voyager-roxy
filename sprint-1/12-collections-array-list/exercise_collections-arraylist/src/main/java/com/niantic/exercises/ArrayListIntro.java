package com.niantic.exercises;

import java.util.ArrayList;

public class ArrayListIntro {
    /*
    1. Create an ArrayList of Strings and add the names of your
       5 favorite heroes.

    Return the list.
     */
    public ArrayList<String> getHeroesList() {
        ArrayList<String> heroes = new ArrayList<>();

        heroes.add("Spider-Man");
        heroes.add("Black Panther");
        heroes.add("Iron Man");
        heroes.add("Captain America");
        heroes.add("Thor");

        return heroes;
    }

    /*
    2. Given a list of integers, create and return a new list of just the
       even numbers in the list

       findEvens( [1, 2, 3, 4] )            ->  [2, 4]
       findEvens( [21, 98, 78, 5, 6, 8] )   ->  [98, 78, 6, 8]
     */
    public ArrayList<Integer> findEvens(ArrayList<Integer> numbers) {
        ArrayList<Integer> evens = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                evens.add(numbers.get(i));
            }
        }
        return evens;
    }

    /*
    3. Given a list of integers, return the sum of all numbers

       sum( [1, 2, 3, 4] )            ->  10
       sum( [21, 98, 78, 5, 6, 8] )   ->  216
     */
    public int sum(ArrayList<Integer> numbers) {
        int sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    /*
    4. Given a list of integers, return the highest number

       sum( [1, 2, 3, 4] )            ->  4
       sum( [21, 98, 78, 5, 6, 8] )   ->  98
     */
    public int max(ArrayList<Integer> numbers) {
        int maxNumber = numbers.getFirst();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > maxNumber) {
                maxNumber = numbers.get(i);
            }
        }
        return maxNumber;
    }

    /*
    5. Given a list of integers, return the lowest number

       sum( [1, 2, 3, 4] )            ->  1
       sum( [21, 98, -78, 5, 6, 8] )  ->  -78
     */
    public int min(ArrayList<Integer> numbers) {
        int minNumber = numbers.getFirst();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < minNumber) {
                minNumber = numbers.get(i);
            }
        }
        return minNumber;
    }

    /*
    6. Given a list of integers, return the average of all numbers
       This should return the average as an integer, not a floating point

       sum( [3, 1, 59, -4, 81, 23] )    ->  27
       sum( [21, 98, -78, 5, 6, 8] )    ->  53
     */
    public int average(ArrayList<Integer> numbers) {
        int average;
        int sum = 0;

        for (var number : numbers) {
            sum += number;
        }

        average = sum / numbers.size();
        return average;
    }

    /*
    7.  Build an arrayList that holds the fibonacci sequence

        The fibonacci sequence is a numeric pattern 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
        - each new number is added by calculating the sum of the previous 2 numbers
          0 + 1 = 1
          1 + 1 = 2
          1 + 2 = 3
          2 + 3 = 5
          etc.
        - the sequence must begin with 0, 1 so size will never be lower than 2

        Include as many numbers as is specified by the size input
     */
    public ArrayList<Integer> buildFibonacci(int size) {
        ArrayList<Integer> fibonacciSequence = new ArrayList<>(size);

        int firstNumber = 0;
        int secondNumber = 1;

        fibonacciSequence.add(firstNumber);
        fibonacciSequence.add(secondNumber);
        System.out.println("first numbers: " + fibonacciSequence);

        for (int i = 2; i < size; i++) {
            int nextNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = nextNumber;

            fibonacciSequence.add(nextNumber);
        }

        System.out.println("sequence: " + fibonacciSequence);
        return fibonacciSequence;
    }
}
