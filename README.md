## Simple Observer / Observable Pattern Example in Java ##

In this example, the Java Observer interface is implemented by a class which "serves" a beverage depending on what "cookie" is chosen by the Observable (the Observable is a stand-in for our user).

This is not an Android demo. I built it using Android Studio, so there's some extra unneeded boilerplate related to that. The example can be run very easily using standard Java tools, provided you have them installed.

To run, stand in the directory below "com" and compile the class by using ``javac com/mdoery/observerinjava/ObserverExample.java``
Then, run the class using ``java com.mdoery.observerinjava.ObserverExample``

Upon running the example, you'll see messages being printed from the ``ObserverExample.update`` method telling you what beverage was served. Notice that this method is never called directly by our code.

Expected output:

```
com.mdoery.observerinjava.ObservableExample@50dcdeae
Snickerdoodle
Served with a hot cocoa
com.mdoery.observerinjava.ObservableExample@50dcdeae
Chocolate chip
Served with a latte
com.mdoery.observerinjava.ObservableExample@50dcdeae
null
Which hot beverage would you prefer?
```

## Not using the Observer Pattern ##

This project includes a code sample, ``CustomObserver.java``, which does the same thing as the ``ObserverExample`` class, but without using the ``Observer`` interface and the ``Observable`` class.

You can run it and verify that the output is basically the same.

However, here, there's more code clutter involved in notifying the "observer". Using Java's built-in tools to implement the ``Observer`` pattern, as is done in the first example, keeps our code more maintainable and readable.