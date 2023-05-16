package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyDraw {

    private List<Toy> toys = new ArrayList<>();

    public List<Toy> getToys() {
        return toys;
    }

    public int getSize(List<Toy> toys) {
        return toys.size();
    }

    public List<Toy> showToys(List<Toy> toys) {
        System.out.println("Toys:");
        for (Toy toy : toys) {
            System.out.printf("%d. %s (quantity: %d, frequency: %d)\n",
                    toy.getId(), toy.getName(), toy.getQuantity(), toy.getFrequency());
        }
        return toys;
    }

    public void addToy(String name, int quantity, int frequency){
        int id = toys.size() + 1;
        Toy toy = new Toy (id, name, quantity, frequency);
        toys.add(toy);
        showToys(toys);
    }

    public void changeFrequency(int id, int frequency) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setFrequency(frequency);
                showToys(toys);
                return;
            }
        }
        System.out.println("The toy has not been found.");

    }
    public void drawToy() {
        int totalFrequency = 0;
        for (Toy toy : toys) {
            totalFrequency += toy.getFrequency();
        }
        int random = new Random().nextInt(totalFrequency);
        int quantity = 0;
        for (Toy toy : toys) {
            quantity += toy.getFrequency();
            if (quantity > random) {
                if (toy.getQuantity() > 0) {
                    toy.setQuantity(toy.getQuantity() - 1);
                    System.out.println("You won a " + toy.getName());
                    showToys(toys);
                } else {
                    System.out.println("No toys left.");
                }
                return;
            }
        }

        System.out.println("The toy has not been found.");
    }




}
