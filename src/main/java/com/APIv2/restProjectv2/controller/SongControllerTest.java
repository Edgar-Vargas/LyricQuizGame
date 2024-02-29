package com.APIv2.restProjectv2.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.APIv2.restProjectv2.FileManager;
import com.APIv2.restProjectv2.Service.SongService;
import com.APIv2.restProjectv2.data.LineSelect;
import com.APIv2.restProjectv2.model.Song;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class SongControllerTest {
    private static final String FOLDER_PATH = "LyricQuizGame\\rest-Projectv2\\SwimmingLyrics";
    private static String RANDOMLYRICS_PATH = "LyricQuizGame\\rest-Projectv2\\RandomLyrics";
    static ArrayList<Song> songContainer = new ArrayList();
	//copy of song container with chosen random lyrics 
	static ArrayList<Song> copyContainer = new ArrayList<>();

    @Autowired
    private SongService songService;
    @GetMapping("/tester")
    public String viewHomePage(Model model ){
        model.addAttribute("listSongs", songService.getAllSongs());
        // Song controlSong = new Song("controller tester", "these are the lyrics today");
        ArrayList<Song> copyContainer = dataHelper(); 
        for(int i = 0; i < copyContainer.size(); i++){
            Song newSong = copyContainer.get(i);
            //TODO readd 100%
            // songService.saveSong(newSong);
        }
        // songService.saveSong(controlSong);
        return "tester";
        
    }

    @GetMapping("/home")
    public String viewMacPage() {
        FileManager mainTest = new FileManager();
		songContainer = mainTest.fileStorageGetter(FOLDER_PATH);
        songContainer = mainTest.fileStorageGetter(FOLDER_PATH);

       

        return "home";
    }

    @GetMapping("/score")
    public String viewScore(){

        return "score";
    }
    
    @GetMapping("/quiz2")
    public String viewQuestion2(Model model, Model array, Model fullSongList ){
        FileManager maintest = new FileManager();
        Map<String, String> data = new HashMap<>();
        ArrayList<String> arrayNames = new ArrayList<>();
        ArrayList<String> fullList = new ArrayList<>();

        String songName = "";
        try {
            data = maintest.getFiles(RANDOMLYRICS_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fullList = maintest.getFullList(FOLDER_PATH);
        songName = maintest.getRandomFileName(RANDOMLYRICS_PATH);
        arrayNames.add(songName);
        
        array.addAttribute("nameArray", arrayNames);
        model.addAttribute("data", data);
        fullSongList.addAttribute("fullList", fullList);
        
       
        return "quiz2";
    }
  

    @GetMapping("/showSongForm") 
    public String showNewSongForm(Model model){
        Song song = new Song();
        model.addAttribute("song", song);
        return "new_song";
        

    }

    @PostMapping("/saveSong")
    public String saveSong(@ModelAttribute("song") Song song) {
        //TODO: process POST request
        songService.saveSong(song);
        
        return "redirect:tester";
    }

    public static ArrayList<Song> dataHelper(){
        Song controlSong = new Song("controller tester", "these are the lyrics today");
        FileManager mainTest = new FileManager();
		songContainer = mainTest.fileStorageGetter(FOLDER_PATH);
		
		System.out.println(songContainer.size());



        return songContainer;
    }
    
}
