package com.APIv2.restProjectv2;

import java.util.ArrayList;

import javax.sound.sampled.Line;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.APIv2.restProjectv2.FileManager;
// import com.APIv2.restProjectv2.controller.SongController;
import com.APIv2.restProjectv2.data.LineSelect;
// import com.APIv2.restProjectv2.data.dataService;
// import com.APIv2.restProjectv2.data.databaseService;
import com.APIv2.restProjectv2.model.Song;


@SpringBootApplication
public class LyricGameMain {
	private static final String FOLDER_PATH = "SwimmingLyrics";
	//original song container
	static ArrayList<Song> songContainer = new ArrayList();
	//copy of song container with chosen random lyrics 
	static ArrayList<Song> copyContainer = new ArrayList<>();
	// private SongController songController = new SongController();
	public static void main(String[] args) {
		
		SpringApplication.run(LyricGameMain.class, args);
		
		FileManager mainTest = new FileManager();
		songContainer = mainTest.fileStorageGetter(FOLDER_PATH);
	
	}

}
