package com.example.melody;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeUiController implements Initializable {
    @FXML
    private TableView<Mp3File> musicTable;

    @FXML
    private TableColumn<Mp3File, String> tblFileNameColumn, tblArtistColumn, tblTitleColumn, tblAlbumColumn, tblYearColumn, tblGenreColumn;
    private String folderPath;
    private ArrayList<Mp3File> musicDataList = new ArrayList<Mp3File>();
    private CoreOperations coreOperations = new CoreOperations();
    private ObservableList<Mp3File> musicListForTable = FXCollections.observableArrayList();
    private Mp3File mp3File = new Mp3File();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tblFileNameColumn.setCellValueFactory(new PropertyValueFactory<Mp3File, String>("fileName"));
        tblTitleColumn.setCellValueFactory(new PropertyValueFactory<Mp3File, String>("title"));
        tblArtistColumn.setCellValueFactory(new PropertyValueFactory<Mp3File, String>("artist"));
        tblAlbumColumn.setCellValueFactory(new PropertyValueFactory<Mp3File, String>("album"));
        tblYearColumn.setCellValueFactory(new PropertyValueFactory<Mp3File, String>("year"));
        tblGenreColumn.setCellValueFactory(new PropertyValueFactory<Mp3File, String>("genre"));


    }

    public void choosefile() {

        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(new Stage());

        folderPath = selectedDirectory.getAbsolutePath();

        //System.out.println(folderPath);
        File file = new File(selectedDirectory.getAbsolutePath());
        File l[] = file.listFiles();

        for (File x : l) {
            if (x.getName().endsWith(".mp3")) {


                coreOperations.musicDataList.add(new Mp3File(x.getPath(), x.getName(), x.getPath(), x.getName(), x.getPath(), x.getName(), x.getPath()));
                //musicListForTable.add(new Mp3File(x.getPath(), x.getName(), x.getPath(), x.getName(), x.getPath(), x.getName(), x.getPath()));
            }

        }
        ObservableList ObList = FXCollections.observableList(coreOperations.musicDataList);

        ObList.addListener(new ListChangeListener() { //add an event listerer for the observable list
            @Override
            public void onChanged(ListChangeListener.Change c) { //Method that will execute when any changes occured
                System.out.println("Changes found ...  "); // Show a message that a change occured
            }
        });


        musicTable.setItems(ObList);


    }


}
