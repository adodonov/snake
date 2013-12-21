package ru.spb.aboutweb2.snake.UI.listeners;

import ru.spb.aboutweb2.snake.Snake;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 14.09.2012
 * Time: 1:58:50
 * To change this template use File | Settings | File Templates.
 */
public class PauseMouseListener  extends MouseAdapter {

    private Snake lifeController;

    public PauseMouseListener(Snake lifeController) {
        this.lifeController = lifeController;
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            //lifeController.execute(command);
            new Thread(new Runnable() {
                public void run() {
                        lifeController.executeCommand("pause");
                }
            }).start();


        }    

    }

}
