package ru.spb.aboutweb2.snake.UI.listeners;

import ru.spb.aboutweb2.snake.Snake;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 08.09.2012
 * Time: 1:26:49
 * To change this template use File | Settings | File Templates.
 */
public class StartMouseListener extends MouseAdapter {

    private Snake lifeController;

    public StartMouseListener(Snake lifeController) {
        this.lifeController = lifeController;
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
                new Thread(new Runnable() {
                    public void run() {
                        lifeController.executeCommand("run");
                    }
                }).start();
        }
    }


}
