package hu.nive.ujratervezes.kepesitovizsga_pot_potvizsga.zoo;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ZooTest {

    private Zoo zoo;
    private Zoo zooDatabase;

    @BeforeEach
    public void setUp() {
        zoo = new Zoo();
        zoo.addAnimal(new Elephant("Ambassador", 2, 6500));
        zoo.addAnimal(new Lion("Aaliyah"));
        zoo.addAnimal(new Lion("Savannah"));
        zoo.addAnimal(new Giraffe("Unika", 2));
        zoo.addAnimal(new Giraffe("Kamili", 3));
        zoo.addAnimal(new Lion("Simba"));
        zoo.addAnimal(new Elephant("Diana", 2, 4200));
        zoo.addAnimal(new Lion("Betsabé"));
        zoo.addAnimal(new Giraffe("Zara", 2));
        zoo.addAnimal(new Lion("Leonidas"));
        zoo.addAnimal(new Giraffe("Zazi", 3));
        zoo.addAnimal(new Elephant("Serafina", 1, 3100));
        zoo.addAnimal(new Lion("Kopa"));

        try {
            MariaDbDataSource dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");

            Flyway fw = Flyway.configure().dataSource(dataSource).load();
            fw.clean();
            fw.migrate();

            zooDatabase = new Zoo(dataSource);
            zooDatabase.loadAnimals();

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not reach database.", sqle);
        }
    }

    @Test
    public void testAddAnimalThroughGetter() {
        Assertions.assertEquals(13, zoo.getAnimals().size());

        zoo.getAnimals().add(new Lion("Pumba"));

        Assertions.assertEquals(13, zoo.getAnimals().size());
    }

    @Test
    public void testGetHeaviestAnimalInTheZoo() {
        ZooAnimal elephant = new Elephant("Ambassador", 2, 6500);

        Assertions.assertEquals(elephant, zoo.getHeaviestAnimalInTheZoo());
    }

    @Test
    public void testCountWeights() {
        Assertions.assertEquals(13800, zoo.countWeights());
    }

    @Test
    public void testFindExactAnimal() {
        ZooAnimal lion = new Lion("Aaliyah");

        Assertions.assertEquals(lion, zoo.findExactAnimal(new Lion("Aaliyah")));
    }

    @Test
    public void testFindExactAnimalNotExisting() {
        ZooAnimal elephant = new Elephant("Ola", 2, 5679);

        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> zoo.findExactAnimal(elephant));
        Assertions.assertEquals("There is no such animal in the zoo!", ex.getMessage());
    }

    @Test
    public void testFindExactAnimalByName() {
        ZooAnimal elephant = new Elephant("Serafina", 1, 3100);

        Assertions.assertEquals(elephant, zoo.findExactAnimalByName("Serafina"));
    }

    @Test
    public void testFindExactAnimalByNameNotExisting() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> zoo.findExactAnimalByName("xyz"));
        Assertions.assertEquals("There is no such animal in the zoo!", ex.getMessage());
    }

    @Test
    public void testGetNumberOfAnimals() {
        Assertions.assertEquals(13, zoo.getNumberOfAnimals());
    }

    @Test
    public void testGetAnimalsOrderedByName() {
        List<ZooAnimal> zooAnimals = zoo.getAnimalsOrderedByName();

        Assertions.assertEquals("Aaliyah", zooAnimals.get(0).getName());
        Assertions.assertEquals("Diana", zooAnimals.get(3).getName());
        Assertions.assertEquals("Simba", zooAnimals.get(9).getName());
    }

    @Test
    public void testGetAnimalStatistics() {
        Map<AnimalType, Integer> statistics = zoo.getAnimalStatistics();

        Assertions.assertEquals(6, statistics.get(AnimalType.LION));
        Assertions.assertEquals(4, statistics.get(AnimalType.GIRAFFE));
        Assertions.assertEquals(3, statistics.get(AnimalType.ELEPHANT));
    }

    @Test
    public void testAddAnimal() {
        ZooAnimal giraffe = new Giraffe("Balboa", 3);

        Assertions.assertFalse(zooDatabase.getAnimals().contains(giraffe));
        Assertions.assertEquals(13, zooDatabase.getAnimals().size());

        zooDatabase.addAnimal(giraffe);
        zooDatabase.loadAnimals();

        Assertions.assertTrue(zooDatabase.getAnimals().contains(giraffe));
        Assertions.assertEquals(14, zooDatabase.getAnimals().size());
    }

    @Test
    public void testAddAnimalTwice() {
        ZooAnimal giraffe = new Giraffe("Balboa", 3);

        Assertions.assertFalse(zooDatabase.getAnimals().contains(giraffe));
        Assertions.assertEquals(13, zooDatabase.getAnimals().size());

        zooDatabase.addAnimal(giraffe);
        zooDatabase.loadAnimals();

        Assertions.assertTrue(zooDatabase.getAnimals().contains(giraffe));
        Assertions.assertEquals(14, zooDatabase.getAnimals().size());

        zooDatabase.addAnimal(giraffe);
        zooDatabase.loadAnimals();

        Assertions.assertTrue(zooDatabase.getAnimals().contains(giraffe));
        Assertions.assertEquals(14, zooDatabase.getAnimals().size());
    }
}
