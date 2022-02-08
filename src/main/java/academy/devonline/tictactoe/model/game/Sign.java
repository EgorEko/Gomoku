package academy.devonline.tictactoe.model.game;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */

public enum Sign {

    X,

    O,

    EMPTY;

    public Sign oppositeSign() {
        if (this == X) {
            return O;
        } else if (this == O) {
            return X;
        } else {
            throw new IllegalStateException("Empty value does not have an opposite one!");
        }
    }

    @Override
    public String toString() {
        if (this == EMPTY) {
            return " ";
        } else {
            return name();
        }
    }
}

