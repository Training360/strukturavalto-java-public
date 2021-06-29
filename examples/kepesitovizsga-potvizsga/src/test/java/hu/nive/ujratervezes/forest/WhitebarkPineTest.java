package hu.nive.ujratervezes.forest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhitebarkPineTest {

    @Test
    void test_create() {
        WhitebarkPine whitebarkPine = new WhitebarkPine();
        assertEquals(0, whitebarkPine.getHeight());
    }

    @Test
    void test_create_with_height() {
        WhitebarkPine whitebarkPine = new WhitebarkPine(5);
        assertEquals(5, whitebarkPine.getHeight());
    }

    @Test
    void test_irrigate() {
        WhitebarkPine whitebarkPine = new WhitebarkPine(5);
        whitebarkPine.irrigate();
        assertEquals(7, whitebarkPine.getHeight());
    }

}