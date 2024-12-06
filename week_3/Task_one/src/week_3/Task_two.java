package week_3;
import java.util.ArrayList;

/**
 *
 * @author olive
 */
public class Task_two {
    ArrayList<Animal> animalList = new ArrayList<>();
    
    public Task_two() {
        Animal animal = new Animal("keif", 10);
        Cat cat = new Cat("donald", 67);
        Dog dog = new Dog("banna", 56);
        Bird bird = new Bird("Dang", 2389);

        // Adding animals to the list
        animalList.add(animal);
        animalList.add(cat);
        animalList.add(dog);
        animalList.add(bird);

        // Loop through the list and call makeSound()
        for (int i = 0; i < animalList.size(); i++) {
            animalList.get(i).makeSound();
        }
    }
    
    public static void main(String[] args) {
        new Task_two(); // Instantiate the Task_two class
    }
}
