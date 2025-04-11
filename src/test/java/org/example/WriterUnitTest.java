package org.example;

import org.junit.jupiter.api.Test;


import java.io.File;
import java.nio.file.Files;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class WriterUnitTest {

    final Writer mockWriter = mock(Writer.class);

    @Test
    void testSetUpInitialization() {
        assertNotNull(mockWriter, "The writer should be initialized in the setUp method.");
    }

    @Test
    void TestGeneratesFile()  {

        String outputFilePath = "";

        mockWriter.run();

        assertTrue(Files.exists(new File(outputFilePath).toPath()), "The file should exist at the specified path.");

    }


}