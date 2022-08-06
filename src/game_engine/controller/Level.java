package game_engine.controller;

public abstract class Level {
    public static Level level1;
    public static Level level2;

    protected Entity_Manager em;

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
}
