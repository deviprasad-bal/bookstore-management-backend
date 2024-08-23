package com.devi.bookstore.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeUtils {

    // Define the date and time format
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Private constructor to prevent instantiation
    private DateTimeUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Formats a LocalDateTime object into a string.
     *
     * @param dateTime the LocalDateTime object to format
     * @return the formatted date-time string
     */
    public static String format(LocalDateTime dateTime) {
        if (dateTime == null) {
            throw new IllegalArgumentException("LocalDateTime cannot be null");
        }
        return dateTime.format(DATE_TIME_FORMATTER);
    }

    /**
     * Parses a date-time string into a LocalDateTime object.
     *
     * @param dateTimeStr the date-time string to parse
     * @return the parsed LocalDateTime object
     * @throws DateTimeParseException if the string cannot be parsed
     */
    public static LocalDateTime parse(String dateTimeStr) throws DateTimeParseException {
        if (dateTimeStr == null || dateTimeStr.trim().isEmpty()) {
            throw new IllegalArgumentException("Date-time string cannot be null or empty");
        }
        return LocalDateTime.parse(dateTimeStr, DATE_TIME_FORMATTER);
    }
}