package hu.nive.ujratervezes.forest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoxtailPineTest {

    @Test
    void test_create() {
        FoxtailPine foxtailPine = new FoxtailPine();
        assertEquals(0, foxtailPine.getHeight());
    }

    @Test
    void test_create_with_height() {
        FoxtailPine foxtailPine = new FoxtailPine(5);
        assertEquals(5, foxtailPine.getHeight());
    }

    @Test
    void test_irrigate() {
        FoxtailPine foxtailPine = new FoxtailPine(5);
        foxtailPine.irrigate();
        assertEquals(6, foxtailPine.getHeight());
    }

}