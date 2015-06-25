package org.topteam.map;

import org.topteam.map.tile.BaiduTileEvent;
import org.topteam.map.tile.MapAbcTileEvent;
import org.topteam.map.tile.TileEvent;

public class Task {

	private int x;
	private int y;
	private int tileSize;
	private int minZ;
	private int maxZ;

	private TaskType taskType = TaskType.BAIDU;

	public Task(int x, int y, int tileSize, int minZ, int maxZ) {
		super();
		this.x = x;
		this.y = y;
		this.tileSize = tileSize;
		this.minZ = minZ;
		this.maxZ = maxZ;
	}

	public Task(int x, int y, int tileSize, int minZ, int maxZ,
			TaskType taskType) {
		super();
		this.x = x;
		this.y = y;
		this.tileSize = tileSize;
		this.minZ = minZ;
		this.maxZ = maxZ;
		this.taskType = taskType;
	}

	public TileEvent getTileEvent(int x, int y, int z) {
		switch (taskType) {
		case BAIDU:
			return new BaiduTileEvent(x, y, z,this);
		case MAPABC:
			return new MapAbcTileEvent(x, y, z, this);
		default:
			break;
		}
		return null;
	}

	@Override
	public String toString() {
		return "Task[x="+x+",y="+y+",size="+tileSize+",minZ="+minZ+",maxZ="+maxZ+"]";
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

	public int getTileSize() {
		return tileSize;
	}

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}

	public int getMinZ() {
		return minZ;
	}

	public void setMinZ(int minZ) {
		this.minZ = minZ;
	}

	public int getMaxZ() {
		return maxZ;
	}

	public void setMaxZ(int maxZ) {
		this.maxZ = maxZ;
	}

}
