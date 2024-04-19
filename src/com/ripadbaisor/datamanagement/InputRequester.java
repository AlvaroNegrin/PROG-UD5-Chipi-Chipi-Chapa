package com.ripadbaisor.datamanagement;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.ripadbaisor.restaurants.Restaurant;

public class InputRequester {

    public static Restaurant restaurantData() throws NumberFormatException {
        String name = JOptionPane.showInputDialog("Nombre del restaurante");
        name = checkIfStringIsNotNull(name);
        String location = JOptionPane.showInputDialog("Localizacion");
        location = checkIfStringIsNotNull(location);
        String schedule = JOptionPane.showInputDialog("Horario semanal");
        schedule = checkIfStringIsNotNull(schedule);
        float punctuation = Float.parseFloat(JOptionPane.showInputDialog("Puntuacion 1/10"));

        while (punctuation < 1 || punctuation > 10) {
            punctuation = Float.parseFloat(JOptionPane.showInputDialog(null,
                    "Debe introducir un numero valido entre 1-10", "ERROR", JOptionPane.ERROR_MESSAGE));
        }

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
        String newElement = JOptionPane.showInputDialog(null, "Introduzca el nuevo dato", "Introduccion",
                JOptionPane.QUESTION_MESSAGE);
        newElement = checkIfStringIsNotNull(newElement);
        return newElement;
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

    public static String checkIfStringIsNotNull(String message) {

        if (message == null || message.length() == 0) {
            do {
                message = JOptionPane.showInputDialog(null, """
                        El campo no puede estar vacio.
                        Introduzca un nuevo dato.
                            """, "ERROR", JOptionPane.ERROR_MESSAGE);
            } while (message == null || message.length() == 0); // Asegúrate de que la cadena no sea null o vacía
        }
        return message;
    }
}
