package game_engine.controller;

import java.util.ArrayList;

import game_engine.model.Entity;

public class Entity_Manager {
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public Entity_Manager() {
		
	}
	
	public ArrayList<Entity> get_entities() {
		return entities;
	}
	
	public void add_entity(Entity e) {
		entities.add(e);
	}
	
	public void remove_entities() {
		entities.removeAll(entities);
	}
	
	public void update() {
		for (Entity entity : entities) {
			entity.update();
		}
	}
	
	public void render() {
		for (Entity entity : entities) {
			entity.render();
		}
	}
}
