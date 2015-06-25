package org.topteam.map;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.topteam.map.tile.TileEvent;

import akka.actor.UntypedActor;

public class DownloadActor extends UntypedActor {

	private String baseFolder = "/Users/jf/Desktop/temp/Map/NanTong";

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof TileEvent) {
			TileEvent event = (TileEvent) message;
			String fileName = event.getFileName();

			
			File zoom = new File(baseFolder + File.separatorChar + event.getNewZoom());
			if(!zoom.exists()){
				zoom.mkdir();
			}
			
			File file = new File(zoom.getAbsolutePath() + File.separatorChar
					+ fileName);
			System.out.println(file.getAbsolutePath());
			if (!file.exists() || file.length() == 0) {
                System.out.println("Downloading>>>>>" + fileName);
                URL url = new URL(event.getUrl());
                InputStream is = url.openStream();
				file.createNewFile();
                OutputStream os = new FileOutputStream(file);
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                while((bytesRead = is.read(buffer,0,8192))!=-1){
                    os.write(buffer,0,bytesRead);
                }
                is.close();
                os.close();
                System.out.println("===========Downloaded " + event);
			}else{
                System.out.println("****Skip**** " + event);
            }

		}
	}

}
