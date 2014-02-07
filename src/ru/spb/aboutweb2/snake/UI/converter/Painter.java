package ru.spb.aboutweb2.snake.UI.converter;

import ru.spb.aboutweb2.snake.UI.Coords;
import ru.spb.aboutweb2.snake.UI.GridProperties;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 07.02.2014
 * Time: 2:11:16
 * To change this template use File | Settings | File Templates.
 */
public interface Painter {

    public abstract void paint(Graphics g, Coords crd, GridProperties prp);

}
