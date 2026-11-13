package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameFormatterTest {

    @Test
    public void format_firstAndLast_putsLastNameFirst() {
        //* Arrange & Act
        String result = NameFormatter.format("Mel", "Johnson");

        //* Assert
        assertEquals("Johnson, Mel", result);
    }

    @Test
    public void format_allFiveParts_matchesStandardFormat() {
        String result = NameFormatter.format("Dr.", "Mel", "B", "Johnson", "PhD");
        assertEquals("Johnson, Dr. Mel B, PhD", result);
    }

    @Test
    public void format_onlyFirstAndLast_hasNoExtraSpacesOrCommas() {
        String result = NameFormatter.format("", "Mel", "", "Johnson", "");
        assertEquals("Johnson, Mel", result);
    }

    @Test
    public void testFirstAndLastName() {
        String actual = NameFormatter.format("John Smith");

        assertEquals("Smith, John", actual);
    }

    @Test
    public void testFirstMiddleAndLastName() {
        String actual = NameFormatter.format("John Michael Smith");

        assertEquals("Smith, John Michael", actual);
    }

    @Test
    public void testPrefixFirstAndLastName() {
        String actual = NameFormatter.format("Dr. John Smith");

        assertEquals("Smith, Dr. John", actual);
    }

    @Test
    public void testPrefixFirstMiddleAndLastName() {
        String actual = NameFormatter.format("Dr. John Michael Smith");

        assertEquals("Smith, Dr. John Michael", actual);
    }

    @Test
    public void testNameWithSuffix() {
        String actual = NameFormatter.format("John Smith, Jr.");

        assertEquals("Smith, John, Jr.", actual);
    }

    @Test
    public void testNameWithPrefixAndSuffix() {
        String actual = NameFormatter.format("Dr. John Smith, PhD");

        assertEquals("Smith, Dr. John, PhD", actual);
    }
}


}