package ru.spb.aboutweb2.snake.gameengine;

import ru.spb.aboutweb2.snake.Snake;
import ru.spb.aboutweb2.snake.UI.Coords;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 07.09.2012
 * Time: 12:09:28
 * To change this template use File | Settings | File Templates.
 */
public interface GameEngine {
    void setController(Snake life);

    void initLifeState(Set<Coords> coords);

    LifeState getNextState(LifeState lifeState);

    LifeState getLifeState();

    void setLifeState(LifeState lifeState); 

    void run();

    void pause();

    void stop();

    void step();

    boolean isRun();    
}
