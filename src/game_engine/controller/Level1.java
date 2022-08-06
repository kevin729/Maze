package game_engine.controller;

import game_engine.model.living.Enemy;
import game_engine.model.living.Player;
import game_engine.model.object.Door;
import game_engine.model.object.Wall;

public class Level1 extends Level {

    public Level1() {

    }

    @Override
    public void setupLevel(I_Game_Manager game) {
        em.add_entity(new Player(30, 100, 50, 50));
        em.add_entity(new Enemy(400, 100, 50, 50));

        em.add_entity(new Wall(0, -20, game.get_game_width(), 40));
        em.add_entity(new Wall(0, game.get_game_height()-20, game.get_game_width(), 1000));
        em.add_entity(new Wall(0, 0, 20, game.get_game_height()));
        em.add_entity(new Wall(game.get_game_width()-20, 0, 20, game.get_game_height()));

        em.add_entity(new Wall(game.get_game_width()/4, game.get_game_height()/2, 100, game.get_game_height()/2));
        em.add_entity(new Wall(game.get_game_width()/2, game.get_game_height()/2, 100, 20));
        em.add_entity(new Wall((int) (game.get_game_width()/1.3), game.get_game_height()/2, 100, 20));
        em.add_entity(new Door(game.get_game_width() - 50, game.get_game_height()/3, 20, 100, Level2.getInstance(game)));
    }

    public static Level getInstance(I_Game_Manager game) {
        if (level1 == null) {
            level1 = new Level1();
            level1.setupLevel(game);
        }

        return level1;
    }
}
