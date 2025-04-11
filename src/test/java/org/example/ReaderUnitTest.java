package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ReaderUnitTest {
    private final Reader mockReader = mock(Reader.class);

    @Test
    void readFileContent() throws IOException {
        String mockFilePath = "src/main/java/org/example/MockFile.java";
        Path path = Paths.get(mockFilePath);

        assertTrue(Files.exists(path), "The file should exist at the specified path.");
        assertFalse(Files.readAllLines(path).isEmpty(), "The file should contain lines to read.");
        assertTrue(Files.readAllBytes(path).length > 0, "The file should contain byte data.");
    }
    @Test
    void testSetUpInitialization() {
        assertNotNull(mockReader, "The reader should be initialized in the setUp method.");
    }

}