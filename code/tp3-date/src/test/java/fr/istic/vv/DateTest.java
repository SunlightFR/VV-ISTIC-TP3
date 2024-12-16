package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    /**
     * Tests du constructeur
     */
    @Test
    public void testMonthInvalidValue(){
        assertThrows(IllegalArgumentException.class, ()->new Date(5, 0, 2024));
        assertThrows(IllegalArgumentException.class, ()->new Date(5, 13, 2024));
    }

    @Test
    public void testDayNegative(){
        assertThrows(IllegalArgumentException.class, ()->new Date(0, 12, 2024));
    }

    @Test
    public void testDay31On30Month(){
        assertThrows(IllegalArgumentException.class, ()->new Date(31, 2, 2024));
        assertThrows(IllegalArgumentException.class, ()->new Date(31, 4, 2024));
        assertThrows(IllegalArgumentException.class, ()->new Date(31, 6, 2024));
        assertThrows(IllegalArgumentException.class, ()->new Date(31, 9, 2024));
        assertThrows(IllegalArgumentException.class, ()->new Date(31, 11, 2024));
    }


    @Test
    public void testDay31On31Month(){
        assertDoesNotThrow( ()->new Date(31, 1, 2024));
        assertDoesNotThrow( ()->new Date(31, 3, 2024));
        assertDoesNotThrow( ()->new Date(31, 5, 2024));
        assertDoesNotThrow( ()->new Date(31, 7, 2024));
        assertDoesNotThrow( ()->new Date(31, 8, 2024));
        assertDoesNotThrow( ()->new Date(31, 10, 2024));
        assertDoesNotThrow( ()->new Date(31, 12, 2024));
    }

    @Test
    public void testDayInvalidFebruary(){
        assertThrows(IllegalArgumentException.class, ()->new Date(30, 2, 2024));
    }

    @Test
    public void testDay29LeapYearFebruary(){
        assertDoesNotThrow(()->new Date(29, 2, 2024));
    }

    @Test
    public void testDay29NonLeapYearFebruary(){
        assertThrows(IllegalArgumentException.class, ()->new Date(29, 2, 2025));
    }

    @Test
    public void testLeapYear400(){
        assertDoesNotThrow(()->new Date(29,2,2000));
    }

    @Test
    public void testNonLeapYear100(){
        assertThrows(IllegalArgumentException.class, ()-> new Date(29,2,1900));
    }
    /**
     * Tests nextDate
     */
    @Test
    public void nextDateNonBoundaryDay(){
        assertEquals(new Date(4,4,2024).nextDate(), new Date(5,4,2024));
    }

    @Test
    public void nextDateDay31(){
        assertEquals(new Date(31,7,2024).nextDate(), new Date(1,8,2024));
    }

    @Test
    public void nextDateDay30On30Month(){
        assertEquals(new Date(30,6,2024).nextDate(), new Date(1,7,2024));
    }

    @Test
    public void nextDateDay29OnLeapYearFebruary(){
        assertEquals(new Date(29,2,2024).nextDate(), new Date(1,3,2024));
    }

    @Test
    public void nextDateDay28OnNonLeapYearFebruary(){
        assertEquals(new Date(28,2,2025).nextDate(), new Date(1,3,2025));
    }

    @Test
    public void nextDateDecember31(){
        assertEquals(new Date(31,12,2024).nextDate(), new Date(1,1,2025));
    }

    /**
     * Tests previousDate
     */
    @Test
    public void previousDateNonBoundaryDay(){
        assertEquals(new Date(4,4,2024).previousDate(), new Date(3,4,2024));
    }

    @Test
    public void previousDateDay1On31Month(){
        assertEquals(new Date(1,8,2024).previousDate(), new Date(31,7,2024));
    }

    @Test
    public void previousDateDay1On30Month(){
        assertEquals(new Date(1,7,2024).previousDate(), new Date(30,6,2024));
    }

    @Test
    public void previousDateDay1OnLeapYearFebruary(){
        assertEquals(new Date(1,3,2024).previousDate(), new Date(29,2,2024));
    }

    @Test
    public void previousDateDay1OnNonLeapYearFebruary(){
        assertEquals(new Date(1,3,2025).previousDate(), new Date(28,2,2025));
    }

    @Test
    public void previousDateJanuary1st(){
        assertEquals(new Date(1,1,2025).previousDate(), new Date(31,12,2024));
    }

    @Test
    public void compareToDifferentYears(){
        Date date1 = new Date(5,6,2024);
        Date date2 = new Date(8,9,2023);
        assertEquals(1, date1.compareTo(date2));
        assertEquals(-1, date2.compareTo(date1));
    }


    @Test
    public void compareToDifferentMonths(){
        Date date1 = new Date(5,9,2024);
        Date date2 = new Date(8,6,2024);
        assertEquals(1, date1.compareTo(date2));
        assertEquals(-1, date2.compareTo(date1));
    }

    @Test
    public void compareToDifferentDays(){
        Date date1 = new Date(10,9,2024);
        Date date2 = new Date(8,9,2024);
        assertEquals(1, date1.compareTo(date2));
        assertEquals(-1, date2.compareTo(date1));
    }

    @Test
    public void compareToSameDate(){
        Date date1 = new Date(5,6,2024);
        Date date2 = new Date(5,6,2024);
        assertEquals(0, date1.compareTo(date2));
        assertEquals(0, date2.compareTo(date1));
    }
}