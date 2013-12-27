package ru.spb.aboutweb2.snake.UI.listeners;

import ru.spb.aboutweb2.snake.SnakeGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 14.09.2012
 * Time: 3:56:58
 * To change this template use File | Settings | File Templates.
 */
public class StopMouseListener  extends MouseAdapter {

    private SnakeGame lifeController;

    public StopMouseListener(SnakeGame lifeController) {
        this.lifeController = lifeController;
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            new Thread(new Runnable() {
                public void run() {
                    lifeController.executeCommand("stop");
                }
            }).start();
        }
    }

}