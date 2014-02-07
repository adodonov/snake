package ru.spb.aboutweb2.snake.UI.converter;

import ru.spb.aboutweb2.snake.UI.Coords;
import ru.spb.aboutweb2.snake.UI.GridProperties;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 07.02.2014
 * Time: 2:12:25
 * To change this template use File | Settings | File Templates.
 */
public class SquarePainter implements Painter {

    private Color defaultColor = new Color(51, 153, 51);

    @Override
    public void paint(Graphics g, Coords crd, GridProperties prp) {
                g.setColor(defaultColor);
                g.fillRect((crd.getCoordX() + prp.getFocusX()) * prp.getCellSize() + 1 ,
                        (prp.getFieldHeight() - prp.getResidue()) - ((crd.getCoordY() + prp.getFocusY()) * prp.getCellSize()) + 1 ,
                        prp.getCellSize()-1,
                        prp.getCellSize()-1);
    }
    
}
