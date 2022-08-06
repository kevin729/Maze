package game_engine.controller;

import game_engine.model.living.Enemy;
import game_engine.model.living.Player;
import game_engine.model.object.Door;
import game_engine.model.object.MovingWall1;
import game_engine.model.object.MovingWall2;

public class Level2 extends Level {

    public Level2() {

    }

    @Override
    public void setupLevel(I_Game_Manager game) {
        em.add_entity(new Player(30, 100, 50, 50));
        em.add_entity(new Enemy(475, 100, 50, 50));

        em.add_entity(new MovingWall1(0, 150, 100, 100));
        em.add_entity(new MovingWall2((int) (game.get_game_width()/4), 150, 100, 100));
        em.add_entity(new MovingWall1(game.get_game_width()/2, 150, 100, 100));
        em.add_entity(new MovingWall2((int) (game.get_game_width()/1.3), 150, 100, 100));

        em.add_entity(new Door(0, game.get_game_height()/4, 20, 100, Level1.getInstance(game)));
    }

    public static Level getInstance(I_Game_Manager game) {
        if (level2 == null) {
            level2 = new Level2();
            level2.setupLevel(game);
        }

        return level2;
    }
}
