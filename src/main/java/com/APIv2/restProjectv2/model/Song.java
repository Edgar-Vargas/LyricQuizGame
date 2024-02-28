package com.APIv2.restProjectv2.model;

import java.util.ArrayList;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "song_name")
    private String songName;
    private String lyrics;
    // private ArrayList<String> randomLyrics;

    //default contructor
    public Song(){
        this.songName = "";
        this.lyrics = "";
    }
    
    public Song(String songName, String lyrics){
        this.songName = songName;
        this.lyrics = lyrics;
    }

    public Integer getId(){
        return id;
    }



    public String getSongName(){
        return songName;
    }

    public void setSongName(String songName){
        this.songName = songName;
    }

    public String getLyrics(){
        return lyrics;
    }

    // public ArrayList<String> getRandomyLyrics(){
    //     return randomLyrics;
    // }
    // public void setRandomLyrics(ArrayList<String> randomLyrics){
    //     this.randomLyrics = randomLyrics;
    // }

    public void setLyrics(String lyrics){
        this.lyrics = lyrics;
    }

}
