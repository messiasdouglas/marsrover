package br.com.tw.marsrover.exploration.rover;

import br.com.tw.marsrover.exploration.Position;

import java.util.Collections;
import java.util.List;

public class Rover {

    private final Position position;
    private final CardinalPoint cardinalPoint;
    private final List<String> moviments;

    public Rover(Position position, CardinalPoint cardinalPoint, List<String> moviments) {
        this.position = position;
        this.cardinalPoint = cardinalPoint;
        this.moviments = moviments;
    }

    public Rover move() {
        CardinalPoint cardinalPoint = CardinalPoint.nextCardinalPoint(this.cardinalPoint, moviments);
        Position position = nextPosition();

        return new Rover(position, cardinalPoint, Collections.emptyList());
    }

    private Position nextPosition() {
        Position actualPosition = position;
        for (String moviment : moviments) {
            String[] moves = moviment.split("");
            if ("L".equals(moves[0]) && CardinalPoint.N.equals(cardinalPoint)) {
                actualPosition = actualPosition.moveWidthMinus();
            }
            if ("L".equals(moves[0]) && CardinalPoint.L.equals(cardinalPoint)) {
                actualPosition = actualPosition.moveHeightMore();
            }
            if ("L".equals(moves[0]) && CardinalPoint.S.equals(cardinalPoint)) {
                actualPosition = actualPosition.moveWidthMore();
            }
            if ("L".equals(moves[0]) && CardinalPoint.O.equals(cardinalPoint)) {
                actualPosition = actualPosition.moveHeightMinus();
            }

            if ("R".equals(moves[0]) && CardinalPoint.N.equals(cardinalPoint)) {
                actualPosition = actualPosition.moveWidthMore();
            }
            if ("R".equals(moves[0]) && CardinalPoint.L.equals(cardinalPoint)) {
                actualPosition = actualPosition.moveHeightMinus();
            }
            if ("R".equals(moves[0]) && CardinalPoint.S.equals(cardinalPoint)) {
                actualPosition = actualPosition.moveWidthMinus();
            }
            if ("R".equals(moves[0]) && CardinalPoint.O.equals(cardinalPoint)) {
                actualPosition = actualPosition.moveHeightMore();
            }
        }
        return actualPosition;
    }

    public Position initialPosition() {
        return position;
    }

    public CardinalPoint cardinalPoint() {
        return cardinalPoint;
    }

    public List<String> moviments() {
        return moviments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (position != null ? !position.equals(rover.position) : rover.position != null) return false;
        if (cardinalPoint != rover.cardinalPoint) return false;
        return moviments != null ? moviments.equals(rover.moviments) : rover.moviments == null;
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (cardinalPoint != null ? cardinalPoint.hashCode() : 0);
        result = 31 * result + (moviments != null ? moviments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "position=" + position +
                ", cardinalPoint=" + cardinalPoint +
                ", moviments=" + moviments +
                '}';
    }

}