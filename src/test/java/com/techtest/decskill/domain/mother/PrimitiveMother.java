package com.techtest.decskill.domain.mother;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class PrimitiveMother {
    public static final int DEFAULT_INT_LIMIT = 100000;
    public static final long DEFAULT_LONG_LIMIT = 1000000000000L;
    public static final long DEFAULT_DOUBLE_LIMIT = DEFAULT_INT_LIMIT;
    public static final LocalDateTime DEFAULT_LOWER_DATE = LocalDateTime.of(1900, Month.JANUARY, 1, 0, 0);
    public static final LocalDateTime DEFAULT_UPPER_DATE = LocalDateTime.of(2149, Month.DECEMBER, 31, 23, 59);


    public static UUID getRandomUuid() {
        return UUID.randomUUID();
    }
    public static String getRandomString() {
        return getRandomUuid().toString();
    }

    public static int getRandomInt() {
        return PrimitiveMother.getRandomInt(-1*DEFAULT_INT_LIMIT, DEFAULT_INT_LIMIT);
    }
    public static int getRandomInt(int from, int to) {
        return new Random().nextInt(to-from) + to;
    }

    public static long getRandomLong() {
        return getRandomLong(-1*DEFAULT_LONG_LIMIT, DEFAULT_LONG_LIMIT);
    }
    public static long getRandomLong(long from, long to) {
        return new Random().nextLong(to-from) + to;
    }

    public static double getRandomDouble() {
        return getRandomDouble(-1*DEFAULT_DOUBLE_LIMIT, DEFAULT_DOUBLE_LIMIT);
    }
    public static double getRandomDouble(double from, double to) {
        return new Random().nextDouble(to-from) + to;
    }

    public static <T> T getRandomFromArray(T[] array) {
        return array[getRandomInt(0, array.length-1)];
    }

    public static boolean getRandomBoolean() {
        return getRandomFromArray(new Boolean[]{true, false});
    }


    public static LocalDateTime getRandomLocalDateTime() {
        return getRandomLocalDateTime(DEFAULT_LOWER_DATE, DEFAULT_UPPER_DATE);
    }
    public static LocalDateTime getRandomLocalDateTime(LocalDateTime from, LocalDateTime to) {
        long randomDay = ThreadLocalRandom.current().nextLong(from.toEpochSecond(ZoneOffset.UTC), to.toEpochSecond(ZoneOffset.UTC));
        return LocalDateTime.ofEpochSecond(randomDay, 0, ZoneOffset.UTC);
    }
}
