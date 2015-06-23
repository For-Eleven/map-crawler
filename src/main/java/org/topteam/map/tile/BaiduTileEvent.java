package org.topteam.map.tile;

import org.topteam.map.Task;

public class BaiduTileEvent extends TileEvent {

	public BaiduTileEvent(int x, int y, int z, Task task) {
		super(x, y, z, task);
	}

	public String getUrl() {
		return "http://online1.map.bdimg.com/tile/?qt=tile&x=" + getX() + "&y="
				+ getY() + "&z=" + getZ() + "&styles=pl";
	}

	@Override
	public String getFileName() {
		
		int d = getZ() - getTask().getMinZ();
		d = (int) Math.pow(2, d);
		int _x = getX() - getTask().getX()*d;
		int _y = getTask().getTileSize()*d - getY();
		int _z = getZ()- (int)(Math.log(getTask().getTileSize())/Math.log(2));
		return "tile" + _x + "_" + _y + "_" + _z + ".png";
	}

	@Override
	public int getNewZoom() {
		int _z = getZ()- (int)(Math.log(getTask().getTileSize())/Math.log(2));
		return _z;
	}
}
