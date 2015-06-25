package org.topteam.map.main;

import org.topteam.map.MapCollector;
import org.topteam.map.Task;
import org.topteam.map.TaskType;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class CollectMain {

	public static void main(String[] args) {
		ActorSystem actorSystem = ActorSystem.create("MapCollector");

		ActorRef map = actorSystem.actorOf(Props.create(MapCollector.class));
		// Task task = new Task(7, 0, 8, 6, 14);

		Task task = new Task(427, 206, 3 , 9, 15, TaskType.MAPABC);
		map.tell(task, map);
	}
}
