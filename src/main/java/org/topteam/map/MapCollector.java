package org.topteam.map;

import org.topteam.map.tile.TileEvent;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.RandomPool;

public class MapCollector extends UntypedActor {

	private ActorRef download;

	public MapCollector() {
		download = getContext().actorOf(
				new RandomPool(5).props(Props.create(DownloadActor.class)),
				"download");
	}

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof Task) {
			Task task = (Task) message;
			System.out.println(task);
			int minZ = task.getMinZ();
			int maxZ = task.getMaxZ();
			int x = task.getX();
			int y = task.getY();
			int tileSize = task.getTileSize();
			int maxX = x + tileSize;
			int maxY = y + tileSize;
			for (int i = 0; i <= maxZ - minZ; i++) {
				
				int _z = minZ + i;
				for (int j = 0; j < maxX - x; j++) {
					int _x = x + j;
					for (int k = 0; k < maxY - y; k++) {
						int _y = y + k;
						TileEvent event = task.getTileEvent(_x, _y, _z);
						download.tell(event, getSelf());
					}
				}
				x = x * 2;
				y = y * 2;
				maxX = maxX * 2;
				maxY = maxY * 2;
			}
		}
	}

}
