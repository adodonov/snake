package ru.spb.aboutweb2.snake.gameengine.model;

import ru.spb.aboutweb2.snake.UI.Coords;

import java.awt.*;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 27.12.2013
 * Time: 1:55:11
 * To change this template use File | Settings | File Templates.
 */
public class Playground implements SnakeModel {
    private Snake snake;
    private Stones stones;
    private Rabbit rabbit;

    private int scores;

    @Override
    public Map<Coords, Color> getCells() {
        Map<Coords, Color> result = new HashMap<Coords, Color>();
        result.putAll(snake.getCells());
        result.putAll(stones.getCells());
        result.putAll(rabbit.getCells());
        return result;
    }
}
