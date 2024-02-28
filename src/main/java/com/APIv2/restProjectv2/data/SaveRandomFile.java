package com.APIv2.restProjectv2.data;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class SaveRandomFile {
    File dir = new File("C:\\workspace\\rest-Projectv2\\RandomLyrics");
    public void writeToFile(Map<String, String> randomMap){
        System.out.println("SIZE OF MAP: " + randomMap.size());
        try{
            for (Map.Entry<String,String> entry : randomMap.entrySet()){
                
                String songName = entry.getKey();
                BufferedWriter writer = new BufferedWriter(new FileWriter(new File(dir,songName)));

                writer.write(entry.getValue());
                writer.close();
            }
          
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    
}

