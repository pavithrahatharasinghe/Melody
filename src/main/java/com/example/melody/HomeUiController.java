package com.example.melody;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.net.URL;

import java.util.ResourceBundle;

import static com.example.melody.AppConfigs.*;


public class HomeUiController implements Initializable {

    @FXML
    private TextField txtFieldArtist, txtFieldTitle, txtFieldAlbum, txtFieldYear, txtFieldGenre;

    @FXML
    private TextArea txtFieldLyrics;

    @FXML
    ImageView albumArtLocal;
    AppConfigs appConfigs = new AppConfigs();
    @FXML
    private TableView<LocalMp3File> musicTable;

    @FXML
    private TableColumn<LocalMp3File, String> tblFileNameColumn;
    @FXML
    private TableColumn<LocalMp3File, String> tblArtistColumn;
    @FXML
    private TableColumn<LocalMp3File, String> tblTitleColumn;
    @FXML
    private TableColumn<LocalMp3File, String> tblAlbumColumn;
    @FXML
    private TableColumn<LocalMp3File, String> tblYearColumn;
    @FXML
    private TableColumn<LocalMp3File, String> tblGenreColumn;
    @FXML
    private TableColumn<LocalMp3File, ImageView> tblAlbumArtColumn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //musicTable.setFixedCellSize(60.0);

       // tblAlbumArtColumn.setCellValueFactory(new PropertyValueFactory<>("albumArt"));

       // tblAlbumArtColumn.height

        tblFileNameColumn.setCellValueFactory(new PropertyValueFactory<LocalMp3File, String>("fileName"));
        tblTitleColumn.setCellValueFactory(new PropertyValueFactory<LocalMp3File, String>("title"));
        tblArtistColumn.setCellValueFactory(new PropertyValueFactory<LocalMp3File, String>("artist"));
        tblAlbumColumn.setCellValueFactory(new PropertyValueFactory<LocalMp3File, String>("album"));
        tblYearColumn.setCellValueFactory(new PropertyValueFactory<LocalMp3File, String>("year"));
        tblGenreColumn.setCellValueFactory(new PropertyValueFactory<LocalMp3File, String>("genre"));

        musicTable.setEditable(true);

        tblFileNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tblArtistColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tblTitleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tblAlbumColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tblYearColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tblGenreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tblGenreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }


    public void ChgangeCurrrentMp3File() {

        if (musicTable.getSelectionModel().getSelectedItem() == null) {

        } else {
            //Set current mp3 file
            LocalMp3File selectedMp3File = musicTable.getSelectionModel().getSelectedItem();
            setCurrentMp3File(new File(selectedMp3File.getFilePath()));
        }
        UpdateSidePanel();


    }


    public void choosefile() {

        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(new Stage());


        //save selected file path in configs
        AppConfigs appConfigs = new AppConfigs();
        appConfigs.setDefaultFolder(selectedDirectory.getAbsolutePath());


        //Read File Tags Using A Background Thread
        Mp3TagReaderThread mp3TagReaderThread = new Mp3TagReaderThread();
        Thread readThread = new Thread(mp3TagReaderThread);
        readThread.start();


        ObservableList ObList = FXCollections.observableList(appConfigs.musicDataList);

        ObList.addListener(new ListChangeListener() { //add an event listener for the observable list
            @Override
            public void onChanged(ListChangeListener.Change c) { //Method that will execute when any changes occurred
                System.out.println("Changes found ...  "); // Show a message that a change occurred
            }
        });


        musicTable.setItems(ObList);
        musicTable.refresh();

    }


    public void EditTableFileNameField(TableColumn.CellEditEvent edittedCell) {
        LocalMp3File selectedMp3File = musicTable.getSelectionModel().getSelectedItem();
        selectedMp3File.setFileName(edittedCell.getNewValue().toString());
    }

    public void EditTableArtistField(TableColumn.CellEditEvent edittedCell) {
        LocalMp3File selectedMp3File = musicTable.getSelectionModel().getSelectedItem();
        selectedMp3File.setArtist(edittedCell.getNewValue().toString());
    }

    public void EditTableTitleField(TableColumn.CellEditEvent edittedCell) {
        LocalMp3File selectedMp3File = musicTable.getSelectionModel().getSelectedItem();
        selectedMp3File.setArtist(edittedCell.getNewValue().toString());
    }

    public void EditTableAlbumField(TableColumn.CellEditEvent edittedCell) {
        LocalMp3File selectedMp3File = musicTable.getSelectionModel().getSelectedItem();
        selectedMp3File.setArtist(edittedCell.getNewValue().toString());
    }

    public void EditTableYearField(TableColumn.CellEditEvent edittedCell) {
        LocalMp3File selectedMp3File = musicTable.getSelectionModel().getSelectedItem();
        selectedMp3File.setArtist(edittedCell.getNewValue().toString());
    }

    public void EditTableGenreField(TableColumn.CellEditEvent edittedCell) {
        LocalMp3File selectedMp3File = musicTable.getSelectionModel().getSelectedItem();
        selectedMp3File.setArtist(edittedCell.getNewValue().toString());
    }

    public void UpdateSidePanel() {

        LocalMp3File selectedMp3File = musicTable.getSelectionModel().getSelectedItem();
        txtFieldArtist.setText(selectedMp3File.getArtist());
        txtFieldTitle.setText(selectedMp3File.getTitle());
        txtFieldAlbum.setText(selectedMp3File.getAlbum());
        txtFieldYear.setText(selectedMp3File.getYear());
        txtFieldGenre.setText(selectedMp3File.getGenre());
        txtFieldLyrics.setText(selectedMp3File.getLyrics());

        albumArtLocal.setImage(selectedMp3File.getAlbumArt().getImage());

    }


}
