package pets;

import java.util.ArrayList;
import java.util.List;

public class Vet {

    private List<Pet> pets = new ArrayList<>();

    public List<Pet> getPets() {
        return pets;
    }

    public void add(Pet pet) {
        for (Pet pet1 : pets) {
            if (areEquals(pet1, pet)) {
                return;
            }
        }
        pets.add(pet);
    }

    private boolean areEquals(Pet pet1, Pet pet2) {
        return pet1.getRegistrationNumber().equals(pet2.getRegistrationNumber());
    }
}
