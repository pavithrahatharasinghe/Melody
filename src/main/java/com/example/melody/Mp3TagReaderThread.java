package com.example.melody;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.RandomAccessFile;

import static com.example.melody.AppConfigs.*;


public class Mp3TagReaderThread implements Runnable {
    @Override
    public void run() {

        if (musicDataList.size() > 0) {
            musicDataList.clear();
        }

        File file = new File(AppConfigs.defaultFolder);
        File[] l = file.listFiles();

        for (File x : l) {
            if (x.getName().endsWith(".mp3")) {

                try {
                    Mp3File mp3file = new Mp3File(x.getPath());

                    if (mp3file.hasId3v2Tag()) {

                        ID3v2 id3v2Tag = mp3file.getId3v2Tag();


                        byte[] imageData = id3v2Tag.getAlbumImage();

                        Image image = new Image(new ByteArrayInputStream(imageData));
                        ImageView albumArt = new ImageView(image);

                        musicDataList.add(new LocalMp3File(x.getPath(), x.getName(), id3v2Tag.getTitle(), id3v2Tag.getArtist(), id3v2Tag.getAlbum(), id3v2Tag.getYear(), id3v2Tag.getGenreDescription(),id3v2Tag.getLyrics(),albumArt));


                    }


                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }

        }

    }

}
