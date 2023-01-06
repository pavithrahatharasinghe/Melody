package com.example.melody;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

import static com.example.melody.AppConfigs.currentMp3File;
import static com.example.melody.AppConfigs.musicDataList;

public class LoadMp3DataThread implements Runnable{
    @Override
    public void run() {


        try {
            Mp3File mp3file = new Mp3File(AppConfigs.currentMp3File.getPath());

            if (mp3file.hasId3v2Tag()) {

                ID3v2 id3v2Tag = mp3file.getId3v2Tag();

/*
                AppConfigs.selectedLocalMp3File.setFileName(currentMp3File.getName());
                AppConfigs.selectedLocalMp3File.setArtist();
                AppConfigs.selectedLocalMp3File.setArtist();
                AppConfigs.selectedLocalMp3File.setArtist();
                AppConfigs.selectedLocalMp3File.setArtist();
                AppConfigs.selectedLocalMp3File.setArtist();
                AppConfigs.selectedLocalMp3File.setArtist();

 */


            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
