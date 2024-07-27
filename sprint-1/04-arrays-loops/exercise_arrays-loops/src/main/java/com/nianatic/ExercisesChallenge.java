package com.nianatic;

public class ExercisesChallenge
{

    /*
     * Given an array of numbers, add only
     * the first 2 numbers and return
     * the answer.
     *
     * The array may have fewer than 2 numbers,
     * so you will need to have logic to deal
     * with that.
     *
     * sumFirst2Numbers([1, 2, 3])       =>  3
     * sumFirst2Numbers([10, 8, 14, 32]) =>  18
     * sumFirst2Numbers([3])             =>  3
     * sumFirst2Numbers([])              =>  0
     */
    public int sumFirst2Numbers(int[] numbers)
    {
        int sum = 0;

            if(numbers.length == 0){
                sum += 0;
            } else if (numbers.length == 1) {
                sum += numbers[0];
            }
            else {
                sum = numbers[0] + numbers[1];
            }

        return sum;
    }

    /*
     * Given an array of names, create a
     * new array of the same size. The new
     * array should have all of the names
     * in it but in reverse order.
     *
     * reverseNames(["Ron", "Lisa", "Kent", "Michelle"]) => ["Michelle", "Kent", "Lisa", "Ron"]
     */
    public String[] reverseNames(String[] names)
    {

        String[] newArray = new String[names.length];

        for (int i = 0; i < names.length; i++)
        {
            newArray[i] = names[names.length - 1 - i];
        }


        return newArray;
    }



    /*
     * Given a multidimensional array of numbers,
     * combine all numbers into a single 1 dimensional array
     *
     * The nested arrays will all have numbers
     * but the amount can vary
     *
     * combineArrays([
     *                [1,2,3],
     *                [4,5,6],
     *                [7,8,9]
     *               ])         =>  [1,2,3,4,5,6,7,8,9]
     *
     * combineArrays([
     *                [1,2],
     *                [3,4,5,6],
     *                [7,8,9]
     *               ])         =>  [1,2,3,4,5,6,7,8,9]
     *
     * combineArrays([
     *                [1,2,3,4],
     *                [5,6,7,8,9]
     *               ])         =>  [1,2,3,4,5,6,7,8,9]
     */
    public int[] combineArrays(int[][] numbers)
    {

        int totalSpots = 0;

        for (int i = 0; i < numbers.length; i++)
        {
            totalSpots += numbers[i].length;
        }

        int[] newArray = new int[totalSpots];


        int index = 0;

        for(int i = 0; i < numbers.length; i++)
        {
            int[] row = numbers[i];

            for (int j = 0; j < row.length; j++)
            {
                newArray[index++] = row[j];

            }

        }

        return newArray;
    }
}
