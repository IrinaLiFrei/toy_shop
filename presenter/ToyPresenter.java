package presenter;

import model.ToyDraw;
import view.ToyView;
import model.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ToyPresenter {
    private ToyView toyView;
    private ToyDraw toyDraw;

    public ToyPresenter(ToyView toyView, ToyDraw toyDraw) {
        this.toyView = toyView;
        this.toyDraw = toyDraw;
    }

    public List<Toy> getToys() {
        return toyDraw.getToys();
    }

    public void addToy(String name, int quantity, int frequency) {
        toyDraw.addToy(name, quantity, frequency);
    }

    public void changeFrequency(int id, int frequency) {
        toyDraw.changeFrequency(id, frequency);
        toyView.showSuccess("The frequency has been successfully changed");

    }

    public void drawToy() {
        toyDraw.drawToy();
    }


    public int getSize(List<Toy> toys) {
        return toyDraw.getSize(toys);
    }
}
