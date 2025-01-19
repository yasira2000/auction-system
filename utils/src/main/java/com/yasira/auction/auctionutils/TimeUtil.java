package com.yasira.auction.auctionutils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class TimeUtil {

    /**
     * Converts a given LocalDateTime to Unix time (epoch seconds).
     *
     * @param dateTime the LocalDateTime to convert
     * @return the Unix time in seconds
     */
    public static Long toUnixTime(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    /**
     * Converts a given LocalDateTime to Unix time (epoch milliseconds).
     *
     * @param dateTime the LocalDateTime to convert
     * @return the Unix time in milliseconds
     */
    public static Long toUnixTimeMillis(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * Converts Unix time (epoch seconds) to LocalTime.
     *
     * @param unixTime the Unix time in seconds
     * @return the corresponding LocalTime
     */
    public static LocalTime fromUnixTime(Long unixTime) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(unixTime), ZoneId.systemDefault()).toLocalTime();
    }

    /**
     * Converts Unix time (epoch milliseconds) to LocalTime.
     *
     * @param unixTimeMillis the Unix time in milliseconds
     * @return the corresponding LocalTime
     */
    public static LocalTime fromUnixTimeMillis(Long unixTimeMillis) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(unixTimeMillis), ZoneId.systemDefault()).toLocalTime();
    }


}
