package ru.spb.aboutweb2.snake.gameengine.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 27.12.2013
 * Time: 3:14:32
 * To change this template use File | Settings | File Templates.
 */
public enum SnakeDirection {
    UP(3), DOWN(-3), LEFT(-5), RIGHT(5);

    int directionNum;

    SnakeDirection(int directionNum) {
        this.directionNum = directionNum;
    }

    private static Map<Integer, SnakeDirection> mapDirection;

    public static SnakeDirection getDirection(int directionNum) {
        if (mapDirection == null) {
            initMapping();
        }
        return mapDirection.get(directionNum);
    }

    private static void initMapping() {
        mapDirection = new HashMap<Integer, SnakeDirection>();
        for (SnakeDirection d : values()) {
            mapDirection.put(d.getDirectionNum(), d);
        }
    }

    public int getDirectionNum() {
        return directionNum;
    }

}
