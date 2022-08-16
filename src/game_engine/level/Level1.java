package game_engine.level;

import game_engine.engine.I_Game_Manager;
import game_engine.entities.living.enemies.Enemy;
import game_engine.entities.living.Player;
import game_engine.entities.object.Door;
import game_engine.entities.object.Wall;

public class Level1 extends Level {

    public Level1() {
        super(300, 300);
    }

    @Override
    public void setupLevel(I_Game_Manager game) {
        super.setupLevel(game);

        em.add_entity(new Player(30, 100));
        em.add_entity(new Enemy(400, 100));

        em.add_entity(new Wall(0, -20, width, 40));
        em.add_entity(new Wall(0, height-20, width, 1000));
        em.add_entity(new Wall(0, 0, 20, height));
        em.add_entity(new Wall(width-20, 0, 20, height));

        em.add_entity(new Wall(0, (int)(height/1.4), 120, height/2));
        em.add_entity(new Wall(width/5, height/3, 100, height));

        em.add_entity(new Wall(width/2, height/3, 100, 20));
        em.add_entity(new Wall(width - 100, height/3, 100, 20));
        em.add_entity(new Door(width - 20, (height/3) - 100, 20, 100, Level.getInstance(game, 1)));
    }
}
