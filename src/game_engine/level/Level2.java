package game_engine.level;

import game_engine.engine.I_Game_Manager;
import game_engine.entities.living.Enemy;
import game_engine.entities.living.Player;
import game_engine.entities.object.Door;
import game_engine.entities.object.MovingWall1;
import game_engine.entities.object.MovingWall2;

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

        em.add_entity(new Door(0, game.get_game_height()/4, 20, 100, Level.getInstance(game, 0)));
    }
}
