// package com.APIv2.restProjectv2.data;

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;

// import com.APIv2.restProjectv2.controller.SongControllerTest;
// import com.APIv2.restProjectv2.model.Song;

// public class dataFilter {
 
//     public dataFilter(){
    
        
//     }

//     public String filter(int numberOfLines, ArrayList<String> lyricsArray){

//         String randomLyrics = "";
//          //iterate through songList 
//          for(int i = 0; i < numberOfLines; i++){
      
//              //get random lyric line from lyric array and insert it into its own array 
//              randomLyrics = randomLyrics + lyricsArray.get(random) + "\n";
 
//          }
 
//          return randomLyrics; 
//      }
 
 
//     static ArrayList<String> filterBySize(ArrayList<String> lyricArray){
//         //cut off variable for minumum amount of words in a line 
//         int cutOff = 3;
//         //array to return
//         ArrayList<String> filteredArray = new ArrayList<>();
   
//         for(String line : lyricArray){
//             //TODO replace puncuation marks with blank space?
//         //    String newLine = line.replace(",", "");
//         String newLine = line;
           
//            String[] splitLine = newLine.split(" ");
            
//             //check for the cutoff and if line contains brackets indicating text that are not lyrics
//             if((splitLine.length > cutOff) && ((!newLine.contains("["))|| (!newLine.contains("]")) )){
//                 filteredArray.add(newLine);
//             }
           
//         }
//         return filteredArray;

//     }

//     static ArrayList<String> filterByRepeats(ArrayList<String> lyricArray){

//         ArrayList<String> copyArray = new ArrayList<>();
//            //map to use for finding repeats
//            Map<String, Integer> wordCount = new HashMap<String, Integer>();

//            for(String line : lyricArray){
//             String[] splitLine = line.split(" ");
//             System.out.println(splitLine.length);
          
//             // for(String word : splitLine){
//             //     System.out.println("INSIDE THE REPEAT LOOP CHECKER " + word);
//             // }

//            }
//         return null;
//     }
    
// }
