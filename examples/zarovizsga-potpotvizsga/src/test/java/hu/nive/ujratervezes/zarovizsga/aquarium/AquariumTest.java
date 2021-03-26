package hu.nive.ujratervezes.zarovizsga.aquarium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AquariumTest {

    private Aquarium aquarium;

    @BeforeEach
    void init() {
        aquarium = new Aquarium();
    }

    @Test
    void test_getStatus_emptyList_emptyAquarium() {
        assertEquals(0, aquarium.getStatus().size());
    }

    @Test
    void test_addFish_getOneFish_addOneClownfish () {
        Clownfish clownfish = new Clownfish("Nemo", 5, "orange-white");
        aquarium.addFish(clownfish);
        assertEquals(1, aquarium.getStatus().size());
    }

    @Test
    void test_getStatus_statusWithThreeFish_addThreeFish() {
        Clownfish clownfish = new Clownfish("Nemo", 5, "orange-white");
        Kong kong = new Kong("Kong", 10, "black");
        Tang tang = new Tang("Dory", 6, "blue");
        aquarium.addFish(clownfish);
        aquarium.addFish(kong);
        aquarium.addFish(tang);
        assertEquals(3, aquarium.getStatus().size());
        assertEquals("Nemo, weight: 5, color: orange-white, short term memory loss: false", aquarium.getStatus().get(0));
        assertEquals("Kong, weight: 10, color: black, short term memory loss: false", aquarium.getStatus().get(1));
        assertEquals("Dory, weight: 6, color: blue, short term memory loss: true", aquarium.getStatus().get(2));
    }

    @Test
    void test_getStatus_statusWithFiveFish_addFiveFish() {
        Clownfish clownfish = new Clownfish("Nemo", 5, "orange-white");
        Kong kong = new Kong("Kong", 10, "black");
        Tang tang = new Tang("Dory", 6, "blue");
        Tang tang2 = new Tang("Dory2", 6, "blue");
        Clownfish clownfish2 = new Clownfish("Nemo2", 10, "orange-white");
        aquarium.addFish(clownfish);
        aquarium.addFish(kong);
        aquarium.addFish(tang);
        aquarium.addFish(tang2);
        aquarium.addFish(clownfish2);
        assertEquals(5, aquarium.getStatus().size());
        assertEquals("Nemo, weight: 5, color: orange-white, short term memory loss: false", aquarium.getStatus().get(0));
        assertEquals("Kong, weight: 10, color: black, short term memory loss: false", aquarium.getStatus().get(1));
        assertEquals("Dory, weight: 6, color: blue, short term memory loss: true", aquarium.getStatus().get(2));
        assertEquals("Dory2, weight: 6, color: blue, short term memory loss: true", aquarium.getStatus().get(3));
        assertEquals("Nemo2, weight: 10, color: orange-white, short term memory loss: false", aquarium.getStatus().get(4));
    }

    @Test
    void test_removeFish_removeNone_dontHaveBiggerFishThan10() {
        Clownfish clownfish = new Clownfish("Nemo", 5, "orange-white");
        Kong kong = new Kong("Kong", 10, "black");
        Tang tang = new Tang("Dory", 6, "blue");
        Tang tang2 = new Tang("Dory2", 6, "blue");
        Clownfish clownfish2 = new Clownfish("Nemo2", 10, "orange-white");
        aquarium.addFish(clownfish);
        aquarium.addFish(kong);
        aquarium.addFish(tang);
        aquarium.addFish(tang2);
        aquarium.addFish(clownfish2);
        assertEquals(5, aquarium.getStatus().size());
        aquarium.removeFish();
        assertEquals(5, aquarium.getStatus().size());
    }

    @Test
    void test_feed_feedFiveFish() {
        Clownfish clownfish = new Clownfish("Nemo", 5, "orange-white");
        Kong kong = new Kong("Kong", 10, "black");
        Tang tang = new Tang("Dory", 6, "blue");
        Tang tang2 = new Tang("Dory2", 6, "blue");
        Clownfish clownfish2 = new Clownfish("Nemo2", 10, "orange-white");
        aquarium.addFish(clownfish);
        aquarium.addFish(kong);
        aquarium.addFish(tang);
        aquarium.addFish(tang2);
        aquarium.addFish(clownfish2);
        aquarium.feed();
        assertEquals("Nemo, weight: 6, color: orange-white, short term memory loss: false", aquarium.getStatus().get(0));
        assertEquals("Kong, weight: 12, color: black, short term memory loss: false", aquarium.getStatus().get(1));
        assertEquals("Dory, weight: 7, color: blue, short term memory loss: true", aquarium.getStatus().get(2));
        assertEquals("Dory2, weight: 7, color: blue, short term memory loss: true", aquarium.getStatus().get(3));
        assertEquals("Nemo2, weight: 11, color: orange-white, short term memory loss: false", aquarium.getStatus().get(4));
    }

    @Test
    void test_removeFish_removeTwo_haveTwoBiggerFishThan10() {
        Clownfish clownfish = new Clownfish("Nemo", 5, "orange-white");
        Kong kong = new Kong("Kong", 12, "black");
        Tang tang = new Tang("Dory", 6, "blue");
        Tang tang2 = new Tang("Dory2", 6, "blue");
        Clownfish clownfish2 = new Clownfish("Nemo2", 11, "orange-white");
        aquarium.addFish(clownfish);
        aquarium.addFish(kong);
        aquarium.addFish(tang);
        aquarium.addFish(tang2);
        aquarium.addFish(clownfish2);
        aquarium.removeFish();
        assertEquals(3, aquarium.getStatus().size());
    }

    @Test
    void test_removeFish_removeTwoFishAfterFeedFiveFish() {
        Clownfish clownfish = new Clownfish("Nemo", 5, "orange-white");
        Kong kong = new Kong("Kong", 10, "black");
        Tang tang = new Tang("Dory", 6, "blue");
        Tang tang2 = new Tang("Dory2", 6, "blue");
        Clownfish clownfish2 = new Clownfish("Nemo2", 10, "orange-white");
        aquarium.addFish(clownfish);
        aquarium.addFish(kong);
        aquarium.addFish(tang);
        aquarium.addFish(tang2);
        aquarium.addFish(clownfish2);
        assertEquals(5, aquarium.getStatus().size());
        aquarium.removeFish();
        assertEquals(5, aquarium.getStatus().size());
        aquarium.feed();
        aquarium.removeFish();
        assertEquals(3, aquarium.getStatus().size());
    }



}