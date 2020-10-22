package javabeans;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DogTest {

    @Test
    public void getSetName() {
        final String name = "Bodri";
        Dog dog = new Dog();
        dog.setName(name);

        assertThat(dog.getName(), is(name));
    }

    @Test
    public void isSetPedigree() {
        Dog dog = new Dog();
        dog.setPedigree(true);

        assertThat(dog.isPedigree(), is(true));
    }

    @Test
    public void getSetAge() {
        final int age = 3;
        Dog dog = new Dog();
        dog.setAge(age);

        assertThat(dog.getAge(), is(age));
    }

    @Test
    public void getSetWeight() {
        final double weight = 6.5;
        Dog dog = new Dog();
        dog.setWeight(weight);

        assertThat(dog.getWeight(), is(weight));
    }
}