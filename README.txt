This program mimics the black jack game based on selected user strategy using a text-based user interface (TUI). Once a strategy is selected, game is automatically played. 

Testing:

    JUnit 4.12 and Hamcrest 1.3

    Example on how to execute the JUnit Tests without IDE:
        javac TestPlayer.java
        java junit.textui.TestRunner TestPlayer

    NOTE: If JUnit CLASSPATH is not set up reference the following example for execution

    java -cp /usr/share/java/junit.jar junit.textui.TestRunner TestPlayer


