package de.triplet.gradle.play

import org.junit.Test

import static org.junit.Assert.assertEquals

class TaskHelperTest {

    private static final File TESTFILE = new File("src/test/fixtures/android_app/src/main/play/en-US/whatsnew")

    @Test
    public void testFilesAreCorrectlyTrimmed() {
        String trimmed = TaskHelper.readAndTrimFile(TESTFILE, 6)

        assertEquals(6, trimmed.length())
    }

    @Test
    public void testShortFilesAreNotTrimmed() {
        String trimmed = TaskHelper.readAndTrimFile(TESTFILE, 100)

        assertEquals(12, trimmed.length())
    }

    @Test
    public void testCorrectTextLength() {
        boolean correctSize = TaskHelper.checkForTextLength(TESTFILE, 50);

        assertEquals(true, correctSize);
    }

    @Test
    public void testCloseCorrectTextLength() {
        boolean correctSize = TaskHelper.checkForTextLength(TESTFILE, 12);

        assertEquals(true, correctSize);
    }

    @Test
    public void testIncorrectTextLength() {
        boolean correctSize = TaskHelper.checkForTextLength(TESTFILE, 1);

        assertEquals(false, correctSize);
    }
}