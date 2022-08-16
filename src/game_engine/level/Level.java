package game_engine.level;

import game_engine.Runner;
import game_engine.engine.Game_Manager;
import game_engine.entities.Entity_Manager;
import game_engine.engine.I_Game_Manager;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.List;

public abstract class Level {
    protected static List<Level> levels;

    private BufferedImage image;
    private int[] pixels;

    protected Entity_Manager em;
    protected int width = 600;
    protected int height = 600;
    protected int viewWidth;
    protected int viewHeight;

    public Level(int viewWidth, int viewHeight) {
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;

        em = new Entity_Manager();
        image = new BufferedImage(viewWidth, viewHeight, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    }

    public void render() {
        em.render();
    }

    public Entity_Manager getEm() {
        return em;
    }

    public void setupLevel(I_Game_Manager game) {
        em.remove_entities();
    }

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

    public int getViewWidth() {
        return viewWidth;
    }

    public int getViewHeight() {
        return viewHeight;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int[] getPixels() {
        return pixels;
    }
}
