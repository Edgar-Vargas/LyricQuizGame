package com.APIv2.restProjectv2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.APIv2.restProjectv2.controller.SongController;
import com.APIv2.restProjectv2.data.LineSelect;
import com.APIv2.restProjectv2.data.SaveRandomFile;
import com.APIv2.restProjectv2.model.Song;

import org.apache.commons.lang3.StringUtils;


public class FileManager {

    private  Map<String, String> randomMap = new HashMap<String, String>();
  
    private static final int CUT_OFF = 3;
   
    //iterates through album folder and calls storeSongs to retrieve song with randomly selected lyrics
    public void fileStorageGetter(String folderPath) {
        //calls helper method to clear the RandomLyrics folder
        clearFolder();
        ArrayList<String> fileArray = new ArrayList<>();
        // ArrayList<Song> songArray = new ArrayList<>();

        File  folder = new File(folderPath);
        File[] files = folder.listFiles();

        for(File file : files){
            if(file.isFile()){
                fileArray.add(file.getName());
                storeSongs(file.getName(), folderPath);
                // songArray.add(songToAdd);
            }
            else{
                if(file.isDirectory()){
                    System.out.println("Folder = " + file.getName());
                    
                }
            }   
        }
        //calls writeToFile method to save the map of songs with their randomly selected lyrics to the RandomLyrics file in local directory
        SaveRandomFile saveRandomFile = new SaveRandomFile();
        saveRandomFile.writeToFile(randomMap);
        
    }

//TODO check for empty file 
/**
 * This method takes in the song name and the folderpath it belongs to.
 * It reads and adds all the lyric lines to a lyric array.
 * The lyric array is passed into the LineSelect class method that selects two random lines to return as the random lyrics and 
 * a the song name along with the passed over lyrics are stored to a song map to be used for the quiz portion. 
 * @param songFileName the filename is the song name
 * @param folderPath folderPath is RandomLyrics where the random lyric line are stored  
 */
 public void storeSongs(String songFileName, String folderPath){
        
        //arraylist for song lyrics in Song object
        ArrayList<String> lyricsArray = new ArrayList<>();
        //continous lyric string for storing to sql database
        String grabLyrics = "";
        Song newSong = new Song();      

        try {    
            BufferedReader reader = new BufferedReader(new FileReader(folderPath + "/" + songFileName));
            String line;
            //assign next line to var in while statement since pointer moves with readLine()
            while((line = reader.readLine()) != null){

                String[] splitLine = line.split(" ");
                //check for the cutoff and if line contains brackets indicating text that are not lyrics
                if((splitLine.length > CUT_OFF) && ((!line.contains("["))|| (!line.contains("]")) )){
                    //filter out accent marks on current line 
                    line = StringUtils.stripAccents(line);
                    //gets added to the lyric array that will be used for comparing 
                    lyricsArray.add(line);
                }
                //gets added to full set of lyrics 
               grabLyrics = grabLyrics + " " + line;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //set song properties
        newSong.setSongName(songFileName);
        newSong.setLyrics(grabLyrics);

        LineSelect lineSelect = new LineSelect();
        //calls line select with how many lines to select as a parameter and an array of lyrics for the individual songs since lyrics in songs are broken up in lines
        String randomLines = lineSelect.selectLines(2, lyricsArray);
        //adds the random lines to a map with the song name as key and the random lyric lines as values
        this.randomMap.put(newSong.getSongName(), randomLines);           
    }

//returns a map of file list to controller that uses getFiles helper method to retrieve a list to put into the map
public  Map<String, String> getFiles(String folderPath )throws IOException{
       
     Map<String, String> mapWithRandom = new HashMap<String, String>();

    ArrayList<String> fileArray = getFileArray(folderPath);
    mapWithRandom = getMap(fileArray);
    
    return mapWithRandom;  
}

//returns a map with the song names as keys and random lyrics as their value
public  Map<String, String> getMap( ArrayList<String> fileArray )throws IOException{ 
    
    Map<String, String> mapWithRandom = new HashMap<String, String>();
    for(String currentFile : fileArray){
        String currentLyrics = "";
        String currentLine;
        StringBuilder result = new StringBuilder();
        try {
            
            BufferedReader reader = new BufferedReader(new FileReader("RandomLyrics/" + currentFile));

            boolean firstLoop = true;
            //assign next line to var in while statement since pointer moves with readLine()
            while((currentLine = reader.readLine()) != null){
               currentLyrics = currentLyrics + " " + currentLine;
               result.append(currentLine);
               if(firstLoop){
                result.append(" | ");
               }
               
               firstLoop = false;
            }
            reader.close();
        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        currentFile = currentFile.substring(0, currentFile.indexOf("."));
        mapWithRandom.put(currentFile, result.toString());
    }
    return mapWithRandom;

    }

//helper method that gets all the files in a folder and returns it as an ArrayList
public ArrayList<String> getFileArray(String folderPath){
        String line = "";
        ArrayList<String> fileArray = new ArrayList();
        File  folder = new File(folderPath);
        File[] files = folder.listFiles();

    try{
        for(File file : files){
            if(file.isFile()){
                fileArray.add(file.getName());
            }
            else{
                if(file.isDirectory()){
                    System.out.println("Folder = " + file.getName());    
                }
            }
        }
    }catch(NullPointerException e){
        e.printStackTrace();
    }

        return fileArray;
    }
//returns a random file from the album folder and then deletes it from the folderpath to avoid repeat questions 
public String getRandomFileName(String folderPath){
        ArrayList<String> fileArray = new ArrayList<>();
        ArrayList<String> fileNames = new ArrayList<>();
        String randomSongName = "";

        fileArray = getFileArray(folderPath);

        for(String currentFile : fileArray){
            currentFile = currentFile.substring(0, currentFile.indexOf("."));
            fileNames.add(currentFile);

        }
        if(fileNames.size() > 0){
            int random = (int)(Math.random() * fileNames.size());
            randomSongName = fileNames.get(random);
        }
        

        //delete from folder after adding random song to not add repeats
        File fileToDelete = new File(folderPath + "/" + randomSongName + ".txt");
        if(fileToDelete.exists()){
            fileToDelete.delete();
        }

        return randomSongName;
    }

    //returns a full list of the songs in the album folder
    public ArrayList<String> getFullList(String folderPath){
        ArrayList<String> fileArray = new ArrayList<>();
        ArrayList<String> fileNames = new ArrayList<>();

        File fileToDelete = new File("");
        fileArray = getFileArray(folderPath);

        
        for(String currentFile : fileArray){
            currentFile = currentFile.substring(0, currentFile.indexOf("."));
            fileNames.add(currentFile);

        }

        return fileNames;

    }

    public void clearFolder(){
        String testFolder = "RandomLyrics";
        ArrayList<String> fileArray = new ArrayList<>();

        fileArray = getFileArray(testFolder);

        for(String currentFile : fileArray){
           
    
        File fileToDelete = new File(testFolder + "/" + currentFile);
        if(fileToDelete.exists()){
            fileToDelete.delete();
        }

        }
    }

    
}
