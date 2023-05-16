import model.ToyDraw;
import presenter.ToyPresenter;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
            ToyPresenter toyPresenter = new ToyPresenter(new ConsoleView(), new ToyDraw());
            ConsoleView toyView = new ConsoleView();
            toyView.setToyPresenter(toyPresenter);
//           toyView.showToys(toyPresenter.getToys());

        toyPresenter.addToy("Doll", 5, 2);
        toyPresenter.addToy("Car", 3, 1);

            toyView.start();
        }
}