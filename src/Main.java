import com.ripadbaisor.logicalprocesses.LogicProcess;

public class Main {
    public static void main(String[] args) throws Exception {
        LogicProcess logic = new LogicProcess();
        logic.setKeepAsking(true);
        while (logic.isKeepAsking()) {
            logic.mainMenu();
        }
    }
}
