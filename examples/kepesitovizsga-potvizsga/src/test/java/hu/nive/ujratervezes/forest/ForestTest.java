package hu.nive.ujratervezes.forest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForestTest {

    @Test
    void test_create() {
        Forest forest = forestWithFiveTrees();
        assertEquals(5, forest.getTrees().size());
        assertEquals(4, forest.getTrees().get(2).getHeight());
    }

    @Test
    void test_rain() {
        Forest forest = forestWithFiveTrees();
        forest.rain();
        assertEquals(5, forest.getTrees().size());
        assertEquals(6, forest.getTrees().get(2).getHeight());
    }

    @Test
    void test_cut_trees() {
        Forest forest = forestWithFiveTrees();
        forest.cutTrees(new Lumberjack());
        assertEquals(3, forest.getTrees().size());
        assertEquals(3, forest.getTrees().get(1).getHeight());
    }

    @Test
    void test_is_empty() {
        Forest forest = new Forest(new ArrayList<>());
        assertTrue(forest.isEmpty());
    }

    @Test
    void test_get_status() {
        Forest forest = forestWithTwoTrees();
        List<String> status =
                forest.getStatus();

        assertEquals(List.of(
                "There is a 2 tall WhitebarkPine in the forest.",
                "There is a 3 tall FoxtailPine in the forest.")
                , status);
    }

    private Forest forestWithFiveTrees() {
        return new Forest(new ArrayList<>(List.of(
                new WhitebarkPine(2),
                new FoxtailPine(3),
                new WhitebarkPine(4),
                new WhitebarkPine(5),
                new FoxtailPine(6)
        )));
    }

    private Forest forestWithTwoTrees() {
        return new Forest(new ArrayList<>(List.of(
                new WhitebarkPine(2),
                new FoxtailPine(3)
        )));
    }
}