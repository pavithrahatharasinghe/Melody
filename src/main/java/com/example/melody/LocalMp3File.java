package com.example.melody;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class LocalMp3File {


    public SimpleStringProperty filePath,fileName,title,artist,album,year,genre,lyrics;

    public ImageView albumArt;



    public LocalMp3File(String filePath, String fileName, String title, String artist, String album, String year, String genre,String lyrics,ImageView albumArt) {
        this.filePath = new SimpleStringProperty(filePath);
        this.fileName = new SimpleStringProperty(fileName);
        this.title = new SimpleStringProperty(title);
        this.artist = new SimpleStringProperty(artist);
        this.album = new SimpleStringProperty(album);
        this.year = new SimpleStringProperty(year);
        this.genre = new SimpleStringProperty(genre);
        this.lyrics =  new SimpleStringProperty(lyrics);
        this.albumArt = albumArt;
    }







    public LocalMp3File() {

    }

    public String getFilePath() {
        return filePath.get();
    }

    public SimpleStringProperty filePathProperty() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath.set(filePath);
    }

    public String getFileName() {
        return fileName.get();
    }

    public SimpleStringProperty fileNameProperty() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName.set(fileName);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getArtist() {
        return artist.get();
    }

    public SimpleStringProperty artistProperty() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
    }

    public String getAlbum() {
        return album.get();
    }

    public SimpleStringProperty albumProperty() {
        return album;
    }

    public void setAlbum(String album) {
        this.album.set(album);
    }

    public String getYear() {
        return year.get();
    }

    public SimpleStringProperty yearProperty() {
        return year;
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    public String getGenre() {
        return genre.get();
    }

    public SimpleStringProperty genreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public String getLyrics() {
        return lyrics.get();
    }

    public SimpleStringProperty lyricsProperty() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics.set(lyrics);
    }

    public ImageView getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(ImageView albumArt) {
        this.albumArt = albumArt;
    }
}
