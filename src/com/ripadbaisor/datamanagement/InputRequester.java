package com.ripadbaisor.datamanagement;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.ripadbaisor.restaurants.Restaurant;

public class InputRequester {

    public static Restaurant restaurantData() throws NumberFormatException {
        String name = JOptionPane.showInputDialog("Nombre del restaurante");
        String location = JOptionPane.showInputDialog("Localizacion");
        String schedule = JOptionPane.showInputDialog("Horario semanal");
        float punctuation = Float.parseFloat(JOptionPane.showInputDialog("Puntuacion 1/10"));
        Restaurant restaurant = new Restaurant(name, location, schedule, punctuation);
        return restaurant;
    }

    public static int getRestaurantIndex(ArrayList<Restaurant> restaurants) throws NumberFormatException {
        String message = "";
        for (int i = 0; i < restaurants.size(); i++) {
            message += (i + 1) + ".- " + restaurants.get(i).getName() + "\n";
        }

        return (Integer.parseInt(JOptionPane.showInputDialog(null,
                message, "SELECTOR", JOptionPane.QUESTION_MESSAGE)) - 1);
    }

    public static int restaurantElementsMenu() throws NumberFormatException {
        return Integer.parseInt(JOptionPane.showInputDialog(null, """
                1- Nombre
                2- Localizacion
                3- Horarios
                4- Puntuacion
                """, "Menu de edición", JOptionPane.QUESTION_MESSAGE));
    }

    public static String restaurantModifyElement() {
        return JOptionPane.showInputDialog(null, "Introduzca el nuevo dato", "Introduccion",
                JOptionPane.QUESTION_MESSAGE);
    }

    public static int restaurantsToDelete(ArrayList<Restaurant> restaurants)
            throws NumberFormatException, IndexOutOfBoundsException {
        String message = "";
        for (int i = 0; i < restaurants.size(); i++) {
            message += (i + 1) + ".- " + restaurants.get(i).getName() + "\n";
        }

        return (Integer.parseInt(JOptionPane.showInputDialog(null, message, "Lista de restaurantes a eliminar",
                JOptionPane.INFORMATION_MESSAGE)) - 1);
    }
}
