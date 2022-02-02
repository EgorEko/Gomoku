package academy.devonline.tictactoe.model;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */

public enum Sign {

    X,

    O,

    EMPTY;

    @Override
    public String toString() {
        if (this == EMPTY) {
            return " ";
        } else {
            return name();
        }
    }
}

