package ru.spb.aboutweb2.snake.UI;

import ru.spb.aboutweb2.snake.Snake;
import ru.spb.aboutweb2.snake.UI.listeners.*;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 07.09.2012
 * Time: 12:10:48
 * To change this template use File | Settings | File Templates.
 */
public class LifeUIImpl implements LifeUI {

    private final static Integer WINDOW_WIDTH = 800;
    private final static Integer WINDOW_HEIGHT = 750;

    private UIMode mode;

    private LifePanel lifePanel;

    private Snake lifeController;

    private MenuBuilder mBuilder;

    public void setController(Snake lifeController) {
        this.lifeController = lifeController;
    }

    public void update(Map<Coords, Color> cells) {
        lifePanel.setSquares(cells);
        new Thread(new Runnable() {
            public void run() {
                    lifePanel.repaint();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
            }
        }).start();

    }

    public void showUI() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame lifeGUI = initLifeGUI();
                lifeGUI.setVisible(true);
            }
        });
    }

    private JFrame initLifeGUI() {
        LifeFrame lifeGUI = new LifeFrame();
        lifeGUI.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        lifeGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lifeGUI.setLocationRelativeTo(null);
        lifeGUI.setResizable(false);

        Integer fieldWidth = WINDOW_WIDTH;
        Integer fieldHeight = WINDOW_HEIGHT - 50;        
        LifePanel lifePanel = new LifePanel(fieldWidth, fieldHeight);
        lifePanel.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        LifePanelMouseWheelListener wheelListener = new LifePanelMouseWheelListener(lifePanel);
        lifePanel.addMouseWheelListener(wheelListener);
        LifePanelMouseListener mouseListener =  new LifePanelMouseListener(lifeController, lifePanel);

        lifePanel.addMouseListener(mouseListener);


        lifeGUI.setLayout(new BoxLayout(lifeGUI.getContentPane(), BoxLayout.PAGE_AXIS));

        lifeGUI.getContentPane().add(lifePanel);
        lifeGUI.setLifePanel(lifePanel);        

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(null);
        controlPanel.setPreferredSize(new Dimension(fieldWidth, 50));

        JButton startButton = new JButton(">>");
        JButton stepButton = new JButton(">");
        JButton pauseButton = new JButton("||");
        JButton stopButton = new JButton("cls");

        startButton.setBounds(270, 10, 50, 30);
        stepButton.setBounds(330, 10, 50, 30);
        pauseButton.setBounds(390, 10, 50, 30);
        stopButton.setBounds(450, 10, 50, 30);

        StartMouseListener startMouseListener = new StartMouseListener(lifeController);
        startButton.addMouseListener(startMouseListener);

        PauseMouseListener pauseMouseListener = new PauseMouseListener(lifeController);
        pauseButton.addMouseListener(pauseMouseListener);

        StepMouseListener stepMouseListener = new StepMouseListener(lifeController);
        stepButton.addMouseListener(stepMouseListener);

        StopMouseListener stopMouseListener = new StopMouseListener(lifeController);
        stopButton.addMouseListener(stopMouseListener);

        controlPanel.add(startButton);
        controlPanel.add(stepButton);
        controlPanel.add(pauseButton);
        controlPanel.add(stopButton);

        JCheckBox showOrigin = new JCheckBox("Show origin border");
        showOrigin.setBounds(510, 10, 150, 30);
        showOrigin.setSelected(lifePanel.isShowOriginBorder());
        controlPanel.add(showOrigin);
        ShowOriginListener showListener = new ShowOriginListener(lifePanel);
        showOrigin.addActionListener(showListener);

        mBuilder = new MenuBuilder(lifeGUI, lifeController);
        mBuilder.build();

        lifeGUI.getContentPane().add(controlPanel);

        setLifePanel(lifePanel);

        setMode(UIMode.INIT);

        return lifeGUI; 
    }



    public LifePanel getLifePanel() {
        return lifePanel;
    }

    public void setLifePanel(LifePanel lifePanel) {
        this.lifePanel = lifePanel;
    }


    public void calculateOriginBorder() {
        lifePanel.getOriginBorder().clear();
        Set<Coords> squares = lifePanel.getSquares().keySet();
        for(Coords square : squares) {
            if(!squares.contains(new Coords(square.getCoordX()-1, square.getCoordY()))) {
                lifePanel.getOriginBorder().addSegment(new Coords(square.getCoordX(), square.getCoordY()), 
                        new Coords(square.getCoordX(), square.getCoordY()+1));
            }
            if(!squares.contains(new Coords(square.getCoordX()+1, square.getCoordY()))) {
                lifePanel.getOriginBorder().addSegment(new Coords(square.getCoordX()+1, square.getCoordY()),
                        new Coords(square.getCoordX()+1, square.getCoordY()+1));
            }
            if(!squares.contains(new Coords(square.getCoordX(), square.getCoordY()-1))) {
                lifePanel.getOriginBorder().addSegment(new Coords(square.getCoordX(), square.getCoordY()),
                        new Coords(square.getCoordX() + 1, square.getCoordY()));
            }
            if(!squares.contains(new Coords(square.getCoordX(), square.getCoordY()+1))) {
                lifePanel.getOriginBorder().addSegment(new Coords(square.getCoordX(), square.getCoordY()+1),
                        new Coords(square.getCoordX() + 1, square.getCoordY()+1));
            }
        }


    }

    public Set<Coords> getSquares() {
        return (lifePanel != null && lifePanel.getSquares() != null ? lifePanel.getSquares().keySet() : null);
    }

    public void initViewSettings() {
        lifePanel.initSettings(1 + lifePanel.getWidth()/2 - (lifePanel.getWidth()/2) % lifePanel.getCellSize(),
                1 + lifePanel.getHeight()/2 - (lifePanel.getHeight()/2) % lifePanel.getCellSize());
    }

    public void clear() {
        lifePanel.getOriginBorder().getSegments().clear();
        mBuilder.setSelectedFileName(null);
    }

    public UIMode getMode() {
        return mode;
    }

    public void setMode(UIMode mode) {
        this.mode = mode;
    }

    public UIState getUIState() {
        return lifePanel.getUiState();        
    }

    public void setUIState(UIState uiState) {
        lifePanel.setUiState(uiState);
    }

    public boolean isInitState() {
        return UIMode.INIT.equals(getMode());
    }

    public boolean isRunning() {
        return UIMode.RUNNING.equals(getMode());
    }
}
