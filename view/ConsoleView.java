package view;

import model.Toy;
import presenter.ToyPresenter;

import java.util.List;
import java.util.Scanner;

public class ConsoleView implements ToyView {

    final Scanner scanner = new Scanner(System.in);
    private ToyPresenter toyPresenter;

    public void setToyPresenter(ToyPresenter toyPresenter) {
        this.toyPresenter = toyPresenter;
    }

    public void showSuccess(String message) {
        System.out.println(message);
    }

    public void showError(String message) {
        System.err.println(message);
    }

    public void start() {
        System.out.println("Welcome to the toy draw!");
        boolean loop = true;
        while (loop) {
            System.out.println("Select option:");
            System.out.println("1. Add a toy");
            System.out.println("2. Change drop frequency");
            System.out.println("3. Play");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addToy();
                case 2 -> changeFrequency();
                case 3 -> drawToy();
                case 0 -> loop = false;
                default -> showError("Unacceptable command.");
            }

            System.out.println();
        }
    }

    private void drawToy() {
        toyPresenter.drawToy();
    }

    private void changeFrequency() {
        int id;
        int frequency;
        System.out.print("Enter id: ");
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
            }
            id = scanner.nextInt();
            scanner.nextLine();
        } while (id > toyPresenter.getSize(toyPresenter.getToys()));

        System.out.print("Enter new draw frequency: ");
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
            }
            frequency = scanner.nextInt();
            scanner.nextLine();
        } while (frequency <= 0);
          toyPresenter.changeFrequency(id, frequency);
    }
    private void addToy() {
        System.out.print("Enter toy name: ");
        String name = scanner.nextLine();

        System.out.print("Enter toy quantity: ");
        int quantity;
        int frequency;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
            }
            quantity = scanner.nextInt();
            scanner.nextLine();
        } while (quantity <= 0);

        System.out.print("Enter draw frequency: ");
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
            }
            frequency = scanner.nextInt();
            scanner.nextLine();
        } while (frequency <= 0);

        toyPresenter.addToy(name, quantity, frequency);
        showSuccess(("The toy has been successfully added."));
    }
}
