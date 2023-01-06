package com.example.melody;

import java.io.File;
import java.util.ArrayList;

public class AppConfigs {
    public static  String defaultFolder = null, defaultOutputFolder = defaultFolder;
    public static ArrayList<LocalMp3File> musicDataList = new ArrayList<>();

    public static File currentMp3File = null;
    public static LocalMp3File selectedLocalMp3File = new LocalMp3File();





    public static ArrayList<LocalMp3File> getMusicDataList() {
        return musicDataList;
    }

    public void setMusicDataList(ArrayList<LocalMp3File> musicDataList) {
        this.musicDataList = musicDataList;
    }

    public AppConfigs(String defaultFolder) {
        this.defaultFolder = defaultFolder;
    }
    public AppConfigs() {

    }


    public String getDefaultFolder() {
        return defaultFolder;
    }

    public  void setDefaultFolder(String defaultFolder) {
        this.defaultFolder = defaultFolder;
    }

    public String getDefaultOutputFolder() {
        return defaultOutputFolder;
    }

    public void setDefaultOutputFolder(String defaultOutputFolder) {
        this.defaultOutputFolder = defaultOutputFolder;
    }

    public static File getCurrentMp3File() {
        return currentMp3File;
    }

    public static void setCurrentMp3File(File currentMp3File) {
        AppConfigs.currentMp3File = currentMp3File;
    }
}
