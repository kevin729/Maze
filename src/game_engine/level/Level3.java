package game_engine.level;

import game_engine.engine.I_Game_Manager;
import game_engine.entities.living.Player;
import game_engine.entities.object.Door;
import game_engine.entities.object.Wall;

public class Level3 extends Level {

    public Level3() {
        super(600, 600);
    }

    @Override
    public void setupLevel(I_Game_Manager game) {
        super.setupLevel(game);

        em.add_entity(new Player(50, 50));
        em.add_entity(new Wall(0, height-20, width, 40));
        em.add_entity(new Wall(0, 0, 20, height));
        em.add_entity(new Wall(width-20, 0, 20, height));
        em.add_entity(new Wall(0, 0, width, 20));

        em.add_entity(new Wall(width/4, 0, 100, height - 100));
        em.add_entity(new Wall(width/4 + 170, 100, 100, height));

        em.add_entity(new Door(width-20, height-120, 20, 100, Level.getInstance(game, 0)));
    }
}