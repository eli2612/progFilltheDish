package home.home2.model;

import home.home2.beans.FridgeBean;

import java.util.ArrayList;
import java.util.List;

public class FridgeSubject {

    private static List<FridgeObserver> observers = new ArrayList<>();


    public static void attach(FridgeObserver observer){
        observers.add(observer);
    }

    public void dettach(FridgeObserver observer){
        observers.remove(observer);
    }

    public void notifyObserversNewIngredient(FridgeBean fridgebean){
        for(FridgeObserver observer : observers){
            observer.update(fridgebean);
        }

    }
}
