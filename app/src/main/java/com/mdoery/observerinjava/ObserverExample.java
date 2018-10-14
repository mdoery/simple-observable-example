package com.mdoery.observerinjava;

import java.util.Observable;
import java.util.Observer;

/**
 * A very simple example of the Observer / Observable pattern in Java.
 */
public class ObserverExample implements Observer {
    public static String SNICKERDOODLE = "Snickerdoodle";
    public static String CHOCOLATE_CHIP = "Chocolate chip";
    ObserverExample() {

    }

    /**
     * Prints a message about a hot beverage which is served with the cookie.
     * @param o the Observable which notified us of a change
     * @param arg the cookie String which was set on the ObservableExample
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o);
        System.out.println(arg);
        if (ObserverExample.SNICKERDOODLE.equals(arg)) {
            System.out.println("Served with a hot cocoa");
        } else if (ObserverExample.CHOCOLATE_CHIP.equals(arg)) {
            System.out.println("Served with a latte");
        } else {
            System.out.println("Which hot beverage would you prefer?");
        }
    }

    /**
     * Demo harness. To run, stand in the directory below "com" and compile the class by using
     * {@code javac com/mdoery/observerinjava/ObserverExample.java}
     * Then, run the class using
     * {@code java com.mdoery.observerinjava.ObserverExample}
     * Upon running the example, you'll see messages being printed from the {@code
     * ObserverExample.update} method. Notice that this method is never called directly by our code.
     * @param args none expected
     */
    public static void main(String[] args) {
        ObservableExample observable = new ObservableExample();
        ObserverExample observer = new ObserverExample();
        observable.addObserver(observer);
        observable.setCookie(ObserverExample.SNICKERDOODLE);
        observable.setCookie(ObserverExample.CHOCOLATE_CHIP);
        observable.setCookie(null);
    }
}

class ObservableExample extends Observable {
    private String cookie;
    ObservableExample() {
    }

    /**
     * Changes the "cookie" String for this Observable. After this is done, any Observers are
     * notified.
     * @param cookie
     */
    public void setCookie(String cookie) {
        this.cookie = cookie;
        // You have to call setChanged, otherwise notifyObservers will not trigger the Observable
        // .update method.
        setChanged(); // method of Observable superclass.
        notifyObservers(cookie); // causes update method to be called on any Observers
    }
}