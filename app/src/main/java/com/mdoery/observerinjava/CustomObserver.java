package com.mdoery.observerinjava;

import java.util.ArrayList;

/**
 * This CustomObserver is designed to do the same thing as the ObserverExample, only without using
 * Observer and Observable.
 */
public class CustomObserver {
    public static String SNICKERDOODLE = "Snickerdoodle";
    public static String CHOCOLATE_CHIP = "Chocolate chip";
    CustomObserver() {
    }

    /**
     * Prints a message about a hot beverage which is served with the cookie.
     * @param o the Object which notified us of a change
     * @param arg the cookie String which was set on the ObservableExample
     */
    public void update(Object o, Object arg) {
        // If you needed to do something with the input Object o, then you'd need to cast that
        // Object or check its type to decide how to handle the inputs.
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
     * {@code javac com/mdoery/observerinjava/CustomObserver.java}
     * Then, run the class using
     * {@code java com.mdoery.observerinjava.CustomObserver}
     * Upon running the example, you'll see messages being printed from the {@code
     * CustomObserver.update} method. Notice that we *must call this method directly in our code*,
     * a key difference between this example and the ObserverExample.
     * @param args none expected
     */
    public static void main(String[] args) {
        CustomObservable observable = new CustomObservable();
        CustomObserver observer = new CustomObserver();
        observable.addObserver(observer);
        observable.setCookie(ObserverExample.SNICKERDOODLE);
        observable.setCookie(ObserverExample.CHOCOLATE_CHIP);
        observable.setCookie(null);
    }

}


/**
 * Like ObservableExample, only does not use the Observable class. It must implement all the
 * functionality itself.
 */
class CustomObservable {
    // New observers custom code stores all of the things that observe me.
    private ArrayList<Object> observers = new ArrayList<Object>();
    private String cookie;
    CustomObservable() {
    }

    /**
     * Changes the "cookie" String for this CustomObservable. After this is done, any "observers"
     * are notified directly by calling their .update method. But, the CustomObservable class
     * needs to know that the .update method is the method to call.
     * @param cookie
     */
    public void setCookie(String cookie) {
        this.cookie = cookie;
        // Notice that you no longer have to call "setChanged" because this CustomObservable
        // knows that something has changed and that observers need to be notified. So, that's a
        // little neater.
        notifyObservers(cookie); // causes update method to be called on any Observers
    }
    /**
     * New method! Since there's no superclass method to addObserver, a custom method needs to be
     * added.
     */
    public void addObserver(Object o) {
        observers.add(o);
    }

    private void notifyObservers(Object arg) {
        for (Object o : observers) {
            // Ah! Here's the hitch. You cannot call update on a generic Object. Instead, you
            // must cast your Object to CustomObserver and then call update. If you have multiple
            // different types of custom observers, you'll need to keep adding custom code to
            // handle each one.
            CustomObserver obs = (CustomObserver) o;
            obs.update(this, arg);
        }
    }
}