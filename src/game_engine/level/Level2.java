package game_engine.level;

import game_engine.engine.I_Game_Manager;
import game_engine.entities.living.Enemy;
import game_engine.entities.living.Player;
import game_engine.entities.object.Door;
import game_engine.entities.object.MovingWall1;
import game_engine.entities.object.MovingWall2;
import game_engine.entities.object.Wall;

public class Level2 extends Level {

    @Override
    public void setupLevel(I_Game_Manager game) {
        em.add_entity(new Player(30, 100, 50, 50));
        em.add_entity(new Enemy(475, 100, 50, 50));

        em.add_entity(new Wall(0, 0, 20, height));
        em.add_entity(new Wall(width-20, 0, 20, height));

        em.add_entity(new MovingWall1(40, 300, 70, 70));
        em.add_entity(new MovingWall2( 190, 300, 70, 70));
        em.add_entity(new MovingWall1(340, 300, 70, 70));
        em.add_entity(new MovingWall2(490, 300, 70, 70));

        em.add_entity(new Door(1, height/4, 20, 100, Level.getInstance(game, 0)));
        em.add_entity(new Door(width-20, height/4, 20, 100, Level.getInstance(game, 2)));
    }
}
