package ru.spb.aboutweb2.snake.gameengine.transformers;

import ru.spb.aboutweb2.snake.gameengine.LifeState;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 07.09.2012
 * Time: 23:14:08
 * To change this template use File | Settings | File Templates.
 */
public interface Transformer {

    LifeState getNextState(LifeState oldState);

}
