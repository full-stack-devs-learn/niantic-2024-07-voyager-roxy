package com.niantic.part_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTests
{
    private Rectangle rectangle;

//    @BeforeEach
//    public void setup()
//    {
//        rectangle = new Rectangle();
//    }

    @Test
    public void parameterlessConstructor_shouldCreateSize5by5Rectangle()
    {
        Rectangle rectangle = new Rectangle();

        int expectedArea = 25;

        int actualArea = rectangle.getArea();

        assertEquals(expectedArea, actualArea, "Because it should have returned 25.");

    }

    @Test
    public void areaOfRectangle_shouldBeCalculatedCorrectly()
    {
        int height = 7;
        int width = 3;
        int expectedArea = 21;

        Rectangle rectangle = new Rectangle(width, height);

        int actualArea = rectangle.getArea();

        assertEquals(expectedArea, actualArea, "Because it should have returned 7 * 3.");

    }

    @Test
    public void perimeterOfRectangle_shouldBeCalculatedCorrectly()
    {
        int height = 9;
        int width = 2;
        int expectedPerimeter = 22;


        Rectangle rectangle = new Rectangle(width, height);

        int actualPerimeter = rectangle.getPerimeter();

        assertEquals(expectedPerimeter, actualPerimeter, "Because it should have returned 22.");
    }

    @Test
    public void widthAndHeight_mustBePositive()
    {
        int width = 9;
        int height = 9;

        Rectangle rectangle = new Rectangle(width, height);


        boolean widthPositive = rectangle.getWidth() > 0;
        boolean heightPositive = rectangle.getHeight() > 0;

        assertTrue(widthPositive, "Because the width is not positive.");
        assertTrue(heightPositive, "Because the height is not positive.");
    }

    @Test
    public void widthOrHeightZero_mustReturnAreaZero()
    {
        int width = -8;
        int height = 8;

        Rectangle rectangle = new Rectangle(width, height);

        int expectedArea = 0;

        int actualArea = rectangle.getArea();

        assertEquals(expectedArea, actualArea, "Because it should have returned 0.");
    }

    @Test
    public void widthOrHeightZero_mustReturnPerimeterZero()
    {
        int width = 9;
        int height = 0;

        Rectangle rectangle = new Rectangle(width, height);

        int expectedPerimeter = 0;

        int actualPerimeter = rectangle.getPerimeter();

        assertEquals(expectedPerimeter, actualPerimeter, "Because it should have returned 0.");
    }

}