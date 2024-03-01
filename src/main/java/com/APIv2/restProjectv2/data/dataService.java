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

// public class dataService {
 
//     public dataService(){
    
//         main();
//     }
    
//     public static Song main(){
//         ArrayList<String> lyricArray = new ArrayList<>();
//         ArrayList<String> filteredArray = new ArrayList<>();
//         Song newSong = new Song();

      



//         try {
            
//             BufferedReader reader = new BufferedReader(new FileReader("LyricQuizGame\\rest-Projectv2\\SwimmingLyrics\\So It Goes.txt"));
//             String line;
//             //assign next line to var in while statement since pointer moves with readLine()
//             while((line = reader.readLine()) != null){
//                lyricArray.add(line);
//                 // System.out.println(line);
//             }
//             reader.close();
//             filteredArray = filterBySize(lyricArray);
//             // filteredArray = filterByRepeats(filteredArray);
        
//         } catch (IOException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         }

//         for(int i = 0; i < filteredArray.size(); i++){
//             System.out.println(filteredArray.get(i));
//         }

//         //get text file name
//         newSong.setSongName("");
//         newSong.setLyrics("");
//         return newSong;
//     }


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
