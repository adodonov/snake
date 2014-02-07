package ru.spb.aboutweb2.snake.UI;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 07.02.2014
 * Time: 2:23:08
 * To change this template use File | Settings | File Templates.
 */
public class GridProperties {
    private int fieldHeight;
    private int focusX;
    private int focusY;
    private int cellSize;
    private int residue;

    public GridProperties(int fieldHeight, int focusX, int focusY, int cellSize, int residue) {
        this.fieldHeight = fieldHeight;
        this.focusX = focusX;
        this.focusY = focusY;
        this.cellSize = cellSize;
        this.residue = residue;
    }

    public int getFieldHeight() {
        return fieldHeight;
    }

    public int getFocusX() {
        return focusX;
    }

    public int getFocusY() {
        return focusY;
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getResidue() {
        return residue;
    }
}
