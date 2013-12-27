package ru.spb.aboutweb2.snake.gameengine.model;

import ru.spb.aboutweb2.snake.UI.Coords;

import java.awt.*;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 27.12.2013
 * Time: 2:19:13
 * To change this template use File | Settings | File Templates.
 */
public interface SnakeModel {

    Map<Coords, Color> getCells();

}
