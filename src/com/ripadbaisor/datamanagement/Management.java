package com.ripadbaisor.datamanagement;

import javax.swing.JOptionPane;

import com.ripadbaisor.restaurants.Restaurant;

public class Management {

    public static Restaurant restaurantData() throws NumberFormatException {
        try {
            String name = JOptionPane.showInputDialog("Nombre del restaurante");
            String location = JOptionPane.showInputDialog("Localizacion");
            String schedule = JOptionPane.showInputDialog("Horario semanal");
            float punctuation = Float.parseFloat(JOptionPane.showInputDialog("Puntuacion 1/10"));
            Restaurant restaurant = new Restaurant(name, location, schedule, punctuation);
            return restaurant;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debes colocar un numero", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Debes colocar informacion valida", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static int getRestaurantIndex() throws NumberFormatException {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el indice del restaurante","SELECTOR", JOptionPane.QUESTION_MESSAGE));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debes colocar un numero valido", "ERROR", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    public static int restaurantElementsMenu() {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(null, """
            1- Nombre
            2- Localizacion
            3- Horarios
            4- Puntuacion
            """, "Menu de edición", JOptionPane.QUESTION_MESSAGE));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debes colocar un numero valido", "ERROR", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    public static String restaurantModifyElement()  {
        return JOptionPane.showInputDialog(null, "Introduzca el nuevo dato", "Introduccion", JOptionPane.QUESTION_MESSAGE);
    }
}
