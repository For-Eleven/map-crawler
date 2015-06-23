package org.topteam.map.tile;

import org.topteam.map.Task;

public abstract class TileEvent {

	private int x;
	private int y;
	private int z;
	
	private Task task;
	
	public TileEvent(Task task) {
		this.task = task;
	}

	public TileEvent(int x, int y, int z,Task task) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.task = task;
	}
	
	public abstract String  getFileName();
	
	public abstract String getUrl();
	
	public abstract int getNewZoom();
	
	@Override
	public String toString() {
		return getFileName();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
	
}
