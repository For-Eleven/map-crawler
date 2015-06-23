package org.topteam.map.tile;

import org.topteam.map.Task;

public class MapAbcTileEvent extends TileEvent {

	public MapAbcTileEvent(int x, int y, int z, Task task) {
		super(x, y, z, task);
	}

	@Override
	public String getFileName() {

		int d = getZ() - getTask().getMinZ();
		d = (int) Math.pow(2, d);
		int _x = getX() - getTask().getX() * d;
		int _y = getY() - getTask().getY() * d;
		int _z = getZ() - getTask().getMinZ()
				+ (int) (Math.log(getTask().getTileSize()) / Math.log(2));
		return "tile" + _x + "_" + _y + "_" + _z + ".png";
	}

	@Override
	public int getNewZoom() {
		int _z = getZ() - getTask().getMinZ()
				+ (int) (Math.log(getTask().getTileSize()) / Math.log(2));
		return _z;
	}
	@Override
	public String getUrl() {
		return "http://emap0.mapabc.com/mapabc/maptile?x=" + getX() + "&y="
				+ getY() + "&z=" + getZ();
	}


}
