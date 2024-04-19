import com.ripadbaisor.menus.Menu;

public class Main {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        menu.setKeepAsking(true);
        while (menu.isKeepAsking()) {
            menu.showMainMenu();
        }
    }
}
