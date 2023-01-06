package com.example.melody;

import com.mpatric.mp3agic.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import static com.example.melody.AppConfigs.*;

public class SaveMp3TagThread implements Runnable {

    @Override
    public void run() {


        try {
            Mp3File mp3file = new Mp3File(currentMp3File.getPath());


            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            byte[] imageData = id3v2Tag.getAlbumImage();

            ID3v24Tag id3v24Tag = new ID3v24Tag();
            mp3file.setId3v2Tag(id3v24Tag);

            if (mp3file.hasId3v2Tag()) {
                LocalMp3File localMp3File = new LocalMp3File();

                id3v24Tag.setArtist(localMp3File.getArtist());
                id3v24Tag.setTitle(localMp3File.getTitle());
                id3v24Tag.setAlbum(localMp3File.getAlbum());
                id3v24Tag.setYear(localMp3File.getYear());
                id3v24Tag.setGenreDescription(localMp3File.getGenre());
                //id3v2s4Tag.setLyrics(localMp3File.getLyrics());


                mp3file.save(defaultOutputFolder + "\\Edited\\" + currentMp3File.getName());
                //getwebimage = false;

                File file = new File(currentMp3File.getPath());
                if (file.delete()) {
                    System.out.println("File deleted successfully");
                } else {
                    System.out.println("Failed to delete the file");
                }
            } else {
                id3v24Tag = new ID3v24Tag();
                mp3file.setId3v2Tag(id3v24Tag);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedTagException e) {
            throw new RuntimeException(e);
        } catch (InvalidDataException e) {
            throw new RuntimeException(e);
        } catch (NotSupportedException e) {
            throw new RuntimeException(e);
        }

    }
}
