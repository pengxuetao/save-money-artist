package com.luffy.artist.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void generateUUID() {
        String uuid = Utils.generateUUID();
        assertNotNull(uuid);
        assertEquals(32, uuid.length());
        assertNotEquals(30, uuid.length());
        assertNotEquals(36, uuid.length());
    }

    @Test
    void getRandomFileName() {
        String fileName = Utils.getRandomFileName("124154.123.5.jpg");
        assertNotNull(fileName);
        assertEquals(36, fileName.length());
        assertTrue(fileName.contains(".jpg"));
    }
}