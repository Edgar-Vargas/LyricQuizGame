package com.APIv2.restProjectv2.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.APIv2.restProjectv2.FileManager;
import com.APIv2.restProjectv2.model.Song;

import org.springframework.ui.Model;




@Controller
public class SongControllerTest {
    private static final String FOLDER_PATH = "SwimmingLyrics";
    private static String RANDOMLYRICS_PATH = "RandomLyrics";
    static ArrayList<Song> songContainer = new ArrayList();
	//copy of song container with chosen random lyrics 
	static ArrayList<Song> copyContainer = new ArrayList<>();

    @GetMapping("/home")
    public String viewMacPage() {
        FileManager mainTest = new FileManager();
        mainTest.clearFolder();
        // songContainer = mainTest.fileStorageGetter(FOLDER_PATH);

        return "home";
    }
    @GetMapping("/")
    public String viewMacPageAlt() {
        FileManager mainTest = new FileManager();
        mainTest.clearFolder();

        return "home";
    }
    @GetMapping("/score")
    public String viewScore(){
        
        return "score";
    }
    @GetMapping("/quiz1")
    public String viewQuestion1(Model model, Model array, Model fullSongList ){
        String cirlcesPath = "Circles_Lyrics";
        FileManager maintest = new FileManager();
        Map<String, String> data = new HashMap<>();
        ArrayList<String> arrayNames = new ArrayList<>();
        ArrayList<String> fullList = new ArrayList<>();

        String songName = "";

        File f= new File(RANDOMLYRICS_PATH);
        File check = new File(cirlcesPath);
        File[] listOfFiles = f.listFiles(); 
        File[] checkAgainstAlbum = check.listFiles(); 

        if(listOfFiles.length == 0){
            maintest.fileStorageGetter(cirlcesPath);
        }
        try {
            
            data = maintest.getFiles(RANDOMLYRICS_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //get full list of songs in album folder
        fullList = maintest.getFullList(cirlcesPath);
        //get a random file to pull for the lyrics
        songName = maintest.getRandomFileName(RANDOMLYRICS_PATH);
        //get the song name that the current random lyrics belong to
        arrayNames.add(songName);
        
        array.addAttribute("nameArray", arrayNames);
        model.addAttribute("data", data);
        fullSongList.addAttribute("fullList", fullList);
        
       
        return "quiz1";
    }
  
    
    @GetMapping("/quiz2")
    public String viewQuestion2(Model model, Model array, Model fullSongList ){
        FileManager maintest = new FileManager();
        Map<String, String> data = new HashMap<>();
        ArrayList<String> arrayNames = new ArrayList<>();
        ArrayList<String> fullList = new ArrayList<>();

        String songName = "";
        File f= new File(RANDOMLYRICS_PATH);
        File check = new File(FOLDER_PATH);
        File[] listOfFiles = f.listFiles(); 
        File[] checkAgainstAlbum = check.listFiles(); 

        if(listOfFiles.length == 0){
            maintest.fileStorageGetter(FOLDER_PATH);
        }
        try {
            data = maintest.getFiles(RANDOMLYRICS_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //get full list of songs in album folder
        fullList = maintest.getFullList(FOLDER_PATH);
        //get a random file to pull for the lyrics
        songName = maintest.getRandomFileName(RANDOMLYRICS_PATH);
        //get the song name that the current random lyrics belong to
        arrayNames.add(songName);
        
        array.addAttribute("nameArray", arrayNames);
        model.addAttribute("data", data);
        fullSongList.addAttribute("fullList", fullList);
        
       
        return "quiz2";
    }

}
