package com.ripadbaisor.logicalprocesses;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import com.ripadbaisor.datamanagement.InputRequester;
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
            restaurantList.add(InputRequester.restaurantData());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debes colocar un numero en el campo de la puntuación", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editRestaurant() {

        try {
            int index = InputRequester.getRestaurantIndex(restaurantList);
            restaurantList.get(index).toString();
            int element = InputRequester.restaurantElementsMenu();

            switch (element) {
                case 0:
                    return;
                case 1:
                    restaurantList.get(index).setName(InputRequester.restaurantModifyElement());
                    break;
                case 2:
                    restaurantList.get(index).setLocalization(InputRequester.restaurantModifyElement());
                    break;
                case 3:
                    restaurantList.get(index).setSchedule(InputRequester.restaurantModifyElement());
                    break;
                case 4:
                    restaurantList.get(index)
                            .setPunctuation(Float.parseFloat(InputRequester.restaurantModifyElement()));
                    if (restaurantList.get(index).getPunctuation() > 10f) {
                        restaurantList.get(index).setPunctuation(10f);
                    } else if (restaurantList.get(index).getPunctuation() < 1f) {
                        restaurantList.get(index).setPunctuation(1f);
                    }
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
            restaurantList.remove(InputRequester.restaurantsToDelete(restaurantList));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debes colocar un numero valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Debes introducir un valor valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

}
