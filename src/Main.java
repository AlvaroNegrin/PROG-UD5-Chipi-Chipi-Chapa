import com.ripadbaisor.logicalprocesses.LogicProcess;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        LogicProcess logic = new LogicProcess();

        logic.addRestaurant();
        logic.addRestaurant();
        logic.addRestaurant();
        logic.addRestaurant();

        logic.showRestaurants();
    }
}
