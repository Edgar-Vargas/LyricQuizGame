// package com.APIv2.restProjectv2.data;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayList;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.RestController;

// import com.APIv2.restProjectv2.model.Song;
// import com.APIv2.restProjectv2.repository.MySqlRepository;
// import com.APIv2.restProjectv2.controller.SongController;

// @RestController
// @Component
// public class databaseService {

    
//     public Song storeSongs(){
        
//         String grabLyrics = "";
//         Song newSong = new Song();

//         try {
            
//             BufferedReader reader = new BufferedReader(new FileReader("C:\\workspace\\rest-Projectv2\\SwimmingLyrics\\So It Goes.txt"));
//             String line;
//             //assign next line to var in while statement since pointer moves with readLine()
//             while((line = reader.readLine()) != null){
//                grabLyrics = grabLyrics + " " + line;
//             }
//             reader.close();
        
//         } catch (IOException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         }
        
//         System.out.println(grabLyrics);
//         //get text file name
//         newSong.setSongName("Placeholder");
//         newSong.setLyrics(grabLyrics);
//         try{
//         //    Song postedSong =  songController.postSong(newSong);
//         }catch(Exception e){
//             e.printStackTrace();
//         }
        
//         return newSong;
//     }
// }
    

