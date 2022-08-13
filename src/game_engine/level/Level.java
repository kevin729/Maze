package game_engine.level;

import game_engine.entities.Entity_Manager;
import game_engine.engine.I_Game_Manager;

import java.util.ArrayList;
import java.util.List;

public abstract class Level {
    protected static List<Level> levels;

    protected Entity_Manager em;
    protected int width = 600;
    protected int height = 600;


    public Level() {
        em = new Entity_Manager();
    }

    public void render() {
        em.render();
    }

    public Entity_Manager getEm() {
        return em;
    }

    public abstract void setupLevel(I_Game_Manager game);

    public static Level getInstance(I_Game_Manager game, int l) {
        if (levels == null) {
            levels = new ArrayList<>();
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.forEach(level -> level.setupLevel(game));
        }

        return levels.get(l);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
