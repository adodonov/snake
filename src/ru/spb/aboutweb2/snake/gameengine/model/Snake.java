package ru.spb.aboutweb2.snake.gameengine.model;

import ru.spb.aboutweb2.snake.UI.Coords;

import java.awt.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 27.12.2013
 * Time: 2:06:54
 * To change this template use File | Settings | File Templates.
 */
public class Snake implements SnakeModel {

    private static Color GREEN = new Color(51, 153, 51);

    private LinkedList<Coords> snakeBody = new LinkedList<Coords>();
    SnakeDirection direction = null;


    public Snake() {
        buildDefaultBody();
    }

    public void step() {
        doStep();
        snakeBody.removeLast();
    }

    public void growUp() {
        doStep();
    }

    private void doStep() {
        if(direction == null) {direction = calculateDefaultDirection();}
        Coords head = snakeBody.get(0);
        int x = head.getCoordX();
        int y = head.getCoordY();
        if(direction == SnakeDirection.UP || direction == SnakeDirection.DOWN) {
            y += (direction.getDirectionNum()/3);
        } else {
            x += (direction.getDirectionNum()/5);
        }
        Coords newSegment = new Coords(x, y);
        snakeBody.add(0, newSegment);
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        if(directionIsNotOpposite(direction)) {
            this.direction = direction;
        } else {
            System.out.println("The snake can not be reversed!");
        }
    }

    private boolean directionIsNotOpposite(SnakeDirection newDirection) {
        return direction == null || newDirection == null || newDirection.getDirectionNum() != -direction.getDirectionNum();
    }

    @Override
    public Map<Coords, Color> getCells() {
        Map<Coords, Color> snakeCells = new HashMap<Coords, Color>();
        for(Coords segment : snakeBody) {
            snakeCells.put(segment, GREEN);
        }
        return snakeCells;
    }

    private void buildDefaultBody() {
        snakeBody.add(new Coords(1,1));
        snakeBody.add(new Coords(2,1));
        snakeBody.add(new Coords(3,1));
    }

    private SnakeDirection calculateDefaultDirection() {
        Coords headCoords = snakeBody.getFirst();
        Coords secondSegment = snakeBody.get(1);
        int directionNum = (headCoords.getCoordY() - secondSegment.getCoordY()) * 3
                + (headCoords.getCoordX() - secondSegment.getCoordX()) * 5;
        return SnakeDirection.getDirection(directionNum);
    }

    public static void main(String[] vars) {
        Snake snake = new Snake();
        for(int i = 0; i<= 7; i++) {
            snake.setDirection(SnakeDirection.UP);
            snake.step();
            System.out.println(snake);
            if(snake.isSelfIntersected()) {
                System.out.println("intersect!");
                System.exit(10);
            }
        }
        snake.growUp();
        System.out.println(snake);        
        for(int i = 0; i < 1; i++) {
            snake.setDirection(SnakeDirection.LEFT);
            snake.step();
            System.out.println(snake);
            if(snake.isSelfIntersected()) {
                System.out.println("intersect!");
                System.exit(10);
            }
        }
        for(int i = 0; i < 1; i++) {
            snake.setDirection(SnakeDirection.RIGHT);
            snake.step();
            System.out.println(snake);
            if(snake.isSelfIntersected()) {
                System.out.println("intersect!");
                System.exit(10);
            }
        }
        for(int i = 0; i < 1; i++) {
            snake.setDirection(SnakeDirection.DOWN);
            snake.growUp();
            System.out.println(snake);
            if(snake.isSelfIntersected()) {
                System.out.println("intersect!");
                System.exit(10);
            }
        }
        for(int i = 0; i<= 5; i++) {
            snake.setDirection(SnakeDirection.RIGHT);
            snake.step();
            System.out.println(snake);
            if(snake.isSelfIntersected()) {
                System.out.println("intersect!");
                System.exit(10);
            }
        }
    }

    public Coords intersect(Coords coords) {
        if(snakeBody.contains(coords)) {
            return coords;
        }
        return null;
    }

    public boolean isSelfIntersected() {
        Set<Coords> bodySet = new HashSet<Coords>(snakeBody);
        return bodySet.size() < snakeBody.size();

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Snake");
        sb.append("{snakeBody=").append(snakeBody);
        sb.append(", direction=").append(direction);
        sb.append('}');
        return sb.toString();
    }
}
