// package com.APIv2.restProjectv2.controller;

// import java.util.List;
// import java.util.Map;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
// import org.springframework.web.bind.annotation.RestController;

// import com.APIv2.restProjectv2.data.databaseService;
// import com.APIv2.restProjectv2.model.Song;
// import com.APIv2.restProjectv2.repository.MySqlRepository;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PostMapping;




// @RestController
// public class SongController {
// // @Autowired
// // private MySqlRepository mySqlRepository;
// @Autowired
// private MySqlRepository mySqlRepository;



// //    public SongController(@Autowired MySqlRepository mySqlRepository){
     
// //     this.mySqlRepository = mySqlRepository;
// //     System.out.println("in constructor");

// //    }


//     @GetMapping("/get-all-songs")
//     public List<Song> getAllSongs() {
//          return mySqlRepository.findAll();
      
//     }

//     @GetMapping("/get-song/{id}")
//     public Song getSongById(@PathVariable("id") Integer id) {
//         return mySqlRepository.findById(id).get();
//     }

//     @DeleteMapping("/remove/{id}")
//     public boolean deleteRow(@PathVariable("id") Integer id){
//         if(!mySqlRepository.findById(id).equals(Optional.empty())){
//             mySqlRepository.deleteById(id);
//             return true;
//         }

//         return false;
//     }
    
//     @PutMapping("update/{id}")
//     public Song updateSong(@PathVariable("id") Integer id,
//                              @RequestBody Map<String, String> body) {
//         //TODO: process PUT request
//          Song currentSong = mySqlRepository.findById(id).get();
//          currentSong.setLyrics(body.get("lyrics"));      
//          currentSong.setSongName(body.get("songName"));
         
//          return mySqlRepository.save(currentSong);

        
        
//     }

//     @PostMapping("/add")
//     public Song postSong(@RequestBody Song body) {
//         //TODO: process POST request

//         String songName = body.getSongName();
//         String lyrics = body.getLyrics();

//         Song newSong = new Song(songName, lyrics);
//         System.out.println(newSong.getSongName());
        
//         return mySqlRepository.save(newSong);
//     }
    
    

// }
