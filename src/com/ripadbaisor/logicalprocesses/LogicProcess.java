package com.ripadbaisor.logicalprocesses;

import java.util.ArrayList;

import com.ripadbaisor.datamanagement.Management;
import com.ripadbaisor.restaurants.Restaurant;

public class LogicProcess {

    private ArrayList<Restaurant> restaurantList = new ArrayList<>();

    public void addRestaurant() {
        restaurantList.add(Management.restaurantData());
    }

    public void editRestaurant() {

        int index = Management.getRestaurantIndex();

        restaurantList.get(index).toString();

        int element = Management.restaurantElementsMenu();

        switch (element) {
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
    }

    /*
     * public void showRestaurants() {
     * ArrayList<Restaurant> orderedList = restaurantList;
     * ArrayList<Restaurant> resultList = new ArrayList<>();
     * 
     * for (int i = 0; i < orderedList.size(); i++) {
     * for (int j = i + 1; j < orderedList.size(); j++) {
     * if (orderedList.get(i).getPunctuation() <
     * orderedList.get(j).getPunctuation()) {
     * resultList.add(orderedList.get(j));
     * }
     * }
     * }
     * for (Restaurant restaurant : resultList) {
     * System.out.println(restaurant.toString());
     * }
     * }
     */

    public void deleteRestaurant() {
        int index = Management.getRestaurantIndex();
        restaurantList.remove(index);
    }

}
