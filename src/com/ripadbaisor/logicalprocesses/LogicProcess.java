package com.ripadbaisor.logicalprocesses;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import com.ripadbaisor.datamanagement.Management;
import com.ripadbaisor.restaurants.Restaurant;

public class LogicProcess {
    private boolean keepAsking;
    private ArrayList<Restaurant> restaurantList = new ArrayList<>();

    public boolean isKeepAsking() {
        return this.keepAsking;
    }

    public void setKeepAsking(boolean keepAsking) {
        this.keepAsking = keepAsking;
    }

    public void addRestaurant() {
        try {
            restaurantList.add(Management.restaurantData());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debes colocar un numero en el campo de la puntuación", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editRestaurant() {

        try {
            int index = Management.getRestaurantIndex(restaurantList);
            restaurantList.get(index).toString();
            int element = Management.restaurantElementsMenu();

            switch (element) {
                case 0:
                    return;
                case 1:
                    restaurantList.get(index).setName(Management.restaurantModifyElement());
                    break;
                case 2:
                    restaurantList.get(index).setLocalization(Management.restaurantModifyElement());
                    break;
                case 3:
                    restaurantList.get(index).setSchedule(Management.restaurantModifyElement());
                    break;
                case 4:
                    restaurantList.get(index).setPunctuation(Float.parseFloat(Management.restaurantModifyElement()));
                    break;
                default:
                    break;
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Debes introducir un valor valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debes colocar un numero valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showRestaurants() {
        ArrayList<Restaurant> orderedList = restaurantList;
        Collections.sort(orderedList);
        String message = "";

        for (Restaurant restaurant : orderedList) {
            message += restaurant.toString();
        }

        JOptionPane.showMessageDialog(null, message, "Lista de restaurantes", JOptionPane.INFORMATION_MESSAGE);
    }

    public void deleteRestaurant() {
        try {
            restaurantList.remove(Management.restaurantsToDelete(restaurantList));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debes colocar un numero valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Debes introducir un valor valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

}
