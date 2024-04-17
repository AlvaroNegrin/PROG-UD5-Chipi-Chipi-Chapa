package com.ripadbaisor.menus;

import javax.swing.JOptionPane;

import com.ripadbaisor.logicalprocesses.LogicProcess;

public class Menu {

    private boolean keepAsking;
    private LogicProcess programLogic = new LogicProcess();
    private String menuMessage = """
            1. Añadir Restaurante.
            2. Editar Restaurante.
            3. Mostrar Restaurantes.
            4. Eliminar Restaurantes.
            Q. Salir del programa.
            """;

    public boolean isKeepAsking() {
        return this.keepAsking;
    }

    public void setKeepAsking(boolean keepAsking) {
        this.keepAsking = keepAsking;
    }

    public void showMainMenu() {
        String message = JOptionPane.showInputDialog(null, menuMessage, "Menu Principal",
                JOptionPane.INFORMATION_MESSAGE);

        if (message != null) {

            switch (message.toUpperCase()) {
                case "1":
                    programLogic.addRestaurant();
                    break;
                case "2":
                    programLogic.editRestaurant();
                    break;
                case "3":
                    programLogic.showRestaurants();
                    break;
                case "4":
                    programLogic.deleteRestaurant();
                    break;
                case "Q":
                    this.setKeepAsking(false);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }

        if (message == null) {
            JOptionPane.showMessageDialog(null, "¡Adios, gracias por usar nuestro programa!", "Despedida",
                    JOptionPane.INFORMATION_MESSAGE);
            this.setKeepAsking(false);
        }

    }
}
