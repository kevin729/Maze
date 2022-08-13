package game_engine.level;

import game_engine.engine.I_Game_Manager;
import game_engine.entities.living.Enemy;
import game_engine.entities.living.Player;
import game_engine.entities.object.Door;
import game_engine.entities.object.Wall;

public class Level1 extends Level {

    public Level1() {
        width = 600;
        height = 600;
    }

    @Override
    public void setupLevel(I_Game_Manager game) {
        em.add_entity(new Player(30, 100, 50, 50));
        em.add_entity(new Enemy(400, 100, 50, 50));

        em.add_entity(new Wall(0, -20, width, 40));
        em.add_entity(new Wall(0, height-20, width, 1000));
        em.add_entity(new Wall(0, 0, 20, height));
        em.add_entity(new Wall(width-20, 0, 20, height));

        em.add_entity(new Wall(width/5, height/2, 100, height/2));
        em.add_entity(new Wall(width/2, height/2, 100, 20));
        em.add_entity(new Wall(width - 100, height/2, 100, 20));
        em.add_entity(new Door(width - 20, (height/2) - 100, 20, 100, Level.getInstance(game, 1)));
    }
}
