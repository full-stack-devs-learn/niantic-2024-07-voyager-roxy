package com.niantic.part_2_challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrinterTests
{
    @Test
    public void printMethodCorrectlyUpdatesTonerAndSheetsOfPaper()
    {
        int sheets = 400;
        int toner = 300;
        int pages = 100;

        Printer printer = new Printer(sheets, toner);

        printer.print(pages);

        int expectedSheets = 300;
        int expectedToner = 200;

        int actualSheets = printer.getSheets();
        int actualToner = printer.getToner();

        assertEquals(expectedSheets, actualSheets, "Because it should have returned 300.");
        assertEquals(expectedToner, actualToner, "Because it should have returned 300.");
    }

    @Test
    public void printMethod_shouldReturnNumberOfPagesPrinted()
    {
        int sheets = 400;
        int toner = 300;
        int pages = 100;

        Printer printer = new Printer(sheets, toner);

        int actualNumberOfPagesPrinted = printer.print(pages);

        assertEquals(pages, actualNumberOfPagesPrinted, "Because it should have returned 100.");
    }

    @Test
    public void shouldNotPrintNegativeCopies_shouldReturnZeroCopies()
    {
        int sheets = 400;
        int toner = 300;
        int pages = -10;

        Printer printer = new Printer(sheets, toner);

        int expectedNumberOfPagesPrinted = 0;
        int actualNumberOfPagesPrinted = printer.print(pages);

        assertEquals(expectedNumberOfPagesPrinted, actualNumberOfPagesPrinted, "Because it should have returned 0.");
    }

    @Test
    public void sheetsAndToner_shouldNeverFallBelowZero()
    {
        int sheets = 60;
        int toner = 60;
        int pages = 100;

        Printer printer = new Printer(sheets, toner);

        printer.print(pages);

        int actualSheets = printer.getSheets();
        int actualToner = printer.getToner();

        int expectedSheets = 0;
        int expectedToner = 0;

        assertEquals(expectedSheets, actualSheets, "Because the number of sheets should not fall below 0.");
        assertEquals(expectedToner, actualToner, "Because the toner should not fall below 0.");
    }

    @Test
    public void printer_ShouldOnlyPrintSheetsOrTonerAvailableEvenIfMoreRequested()
    {
        int sheets = 100;
        int toner = 50;
        int paper = 200;

        Printer printer = new Printer(sheets, toner);

        int printed = printer.print(paper);

        int expectedPages = 50;
        int expectedSheets = 50;
        int expectedToner = 0;

        int actualSheets = printer.getSheets();
        int actualToner = printer.getToner();

        assertEquals(expectedPages, printed, "Because it should only print the pages available by toner.");
        assertEquals(expectedSheets, actualSheets, "Because it should only print based on available sheets.");
        assertEquals(expectedToner, actualToner, "Because it should only print based on available sheets.");
    }

    @Test
    public void addPaperMethod_updatesPaperInPrinter()
    {
        int sheets = 100;
        int toner = 400;
        int paper = 100;

        Printer printer = new Printer(sheets, toner);

        printer.addPaper(paper);

        int expectedPaper = 200;
        int actualPaper = printer.getSheets();

        assertEquals(expectedPaper, actualPaper, "Because it should have returned 100 + 100.");
    }

    @Test
    public void amountOfPaper_shouldNeverExceedMaxSheets()
    {
        int sheets = 100;
        int toner = 400;
        int paper = 600;
        int maxSheets = 500;

        Printer printer = new Printer(sheets, toner);

        printer.addPaper(paper);

        int actualPaper = printer.getSheets();

        assertEquals(maxSheets, actualPaper, "Because the amount of paper should never exceed the max sheets.");
    }

    @Test
    public void replaceToner_shouldBeResetToMaxCapacity()
    {
        int sheets = 100;
        int toner = 1000;

        Printer printer = new Printer(sheets, toner);

        printer.replaceToner();

        int actualToner = printer.getToner();

        assertEquals(toner, actualToner, "Because it should reset toner to max capacity of 1000.");
    }

    @Test
    public void shouldNotAddNegativePaper()
    {
        int paper = 0;
        int sheets = 100;
        int toner = 400;

        Printer printer = new Printer(sheets, toner);

        printer.addPaper(paper);

        int actualPaper = printer.getSheets();

        assertEquals(100, actualPaper, "Because you cannot add negative paper.");
    }
}