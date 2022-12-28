package com.example.melody;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.*;

public class CoreOperations implements Initializable {


    public static ArrayList <Mp3File> musicDataList = new ArrayList<>();

    public ArrayList<Mp3File> getMusicDataList() {
        return musicDataList;
    }

    public void setMusicDataList(ArrayList<Mp3File> musicDataList) {
        this.musicDataList = musicDataList;
    }
    static ObservableList<Mp3File> observableMusicList = new ObservableList<Mp3File>() {
        @Override
        public void addListener(ListChangeListener<? super Mp3File> listChangeListener) {

        }

        @Override
        public void removeListener(ListChangeListener<? super Mp3File> listChangeListener) {

        }

        @Override
        public boolean addAll(Mp3File... mp3Files) {
            return false;
        }

        @Override
        public boolean setAll(Mp3File... mp3Files) {
            return false;
        }

        @Override
        public boolean setAll(Collection<? extends Mp3File> collection) {
            return false;
        }

        @Override
        public boolean removeAll(Mp3File... mp3Files) {
            return false;
        }

        @Override
        public boolean retainAll(Mp3File... mp3Files) {
            return false;
        }

        @Override
        public void remove(int i, int i1) {

        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Mp3File> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Mp3File mp3File) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Mp3File> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Mp3File> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Mp3File get(int index) {
            return null;
        }

        @Override
        public Mp3File set(int index, Mp3File element) {
            return null;
        }

        @Override
        public void add(int index, Mp3File element) {

        }

        @Override
        public Mp3File remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Mp3File> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Mp3File> listIterator(int index) {
            return null;
        }

        @Override
        public List<Mp3File> subList(int fromIndex, int toIndex) {
            return null;
        }

        @Override
        public void addListener(InvalidationListener invalidationListener) {

        }

        @Override
        public void removeListener(InvalidationListener invalidationListener) {

        }
    };
    public static void AddToTableList(){
       observableMusicList = FXCollections.<Mp3File>observableArrayList( musicDataList );
    }

    /*
        private void readTags(String Filepath) {

            try {
                Mp3File mp3file = new Mp3File(currentMp3File.getFilepath());

                if (mp3file.hasId3v2Tag()) {

                    ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                    lblTitle.setText(id3v2Tag.getTitle());
                    lblArtist.setText(id3v2Tag.getArtist());
                    lblAlbum.setText(id3v2Tag.getAlbum());
                    lblYear.setText(id3v2Tag.getYear());
                    lblGenre.setText(id3v2Tag.getGenreDescription());
                    lblLyrics.setText(id3v2Tag.getLyrics());

                }

                if (mp3file.hasId3v2Tag()) {
                    ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                    byte[] imageData = id3v2Tag.getAlbumImage();
                    if (imageData != null) {
                        String mimeType = id3v2Tag.getAlbumImageMimeType();
                        //System.out.println("Mime type: " + mimeType);
                        // Write image to file - can determine appropriate file extension from the mime type
                        RandomAccessFile file = new RandomAccessFile("album-artwork", "rw");
                        file.write(imageData);
                        file.close();
                    }

                    ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                    BufferedImage bImage2 = ImageIO.read(bis);

                    ImageIcon icon = new ImageIcon(bImage2);

                    //Image scaleImage = icon.getImage();
                    Image img = new Image(new ByteArrayInputStream(imageData));
                    albumArt.setImage(img);


                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }

        private void savenewTags() {

            try {
                Mp3File mp3file = new Mp3File(currentMp3File.getFilepath());


                ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                byte[] imageData = id3v2Tag.getAlbumImage();

                ID3v24Tag id3v24Tag = new ID3v24Tag();
                mp3file.setId3v2Tag(id3v24Tag);

                if (mp3file.hasId3v2Tag()) {
                    //id3v24Tag = mp3file.getId3v2Tag();
                } else {
                    id3v24Tag = new ID3v24Tag();
                    mp3file.setId3v2Tag(id3v24Tag);
                }
                if (mp3file.hasId3v2Tag()) {

                    id3v24Tag.setArtist(lblArtist.getText());
                    id3v24Tag.setTitle(lblTitle.getText());
                    id3v24Tag.setAlbum(lblAlbum.getText());
                    id3v24Tag.setYear(lblYear.getText());
                    id3v24Tag.setGenreDescription(lblGenre.getText());
                    id3v24Tag.setLyrics(lblLyrics.getText());


                    if (getwebimage) {
                        GLA gla = new GLA();
                        byte[] data;
                        try {
                            URL url = new URL(gla.search(tfSrcField.getText()).getHits().get(0).getImageUrl());
                            BufferedImage bImage = ImageIO.read(url);
                            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            ImageIO.write(bImage, "jpg", bos);
                            data = bos.toByteArray();
                            id3v24Tag.setAlbumImage(data, "image/jpeg");
                        } catch (IOException e) {
                        }
                    } else {


                        id3v24Tag.setAlbumImage(imageData, "image/jpeg");


                    }


                    mp3file.save(slectedFile + "\\Edited\\" + currentMp3File.getFilename());
                    getwebimage=false;

                    File file = new File(currentMp3File.getFilepath());
                    if (file.delete()) {
                        System.out.println("File deleted successfully");
                    }
                    else {
                        System.out.println("Failed to delete the file");
                    }
                }
                //mp3file.save(currentMp3File.getFilepath());


            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
