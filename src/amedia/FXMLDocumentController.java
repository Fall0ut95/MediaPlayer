package amedia;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

public class FXMLDocumentController implements Initializable {
    
    private MediaPlayer mediaPlayer;
    private String filePath;
    
    /* The @FXML are connecting the code to the SceneBuilder Objects */
    @FXML
    private MediaView mediaView;
    @FXML
    private Label label;
    @FXML
    private Button button;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a File", "*.mp4");//this decides which type of media can be played
            fileChooser.getExtensionFilters().add(filter);//tells the fileChooser which file types are allowed
            File file = fileChooser.showOpenDialog(null);//sets the default media to null
            filePath = file.toURI().toString();//convert the file to a string name
            
            if(filePath != null){
                Media media = new Media(filePath);//get the file that the user wants to play and store it in media
                mediaPlayer = new MediaPlayer(media);//add the file into the player object
                mediaView.setMediaPlayer(mediaPlayer);//sets the mediaView to hold the mediaPlayer
                    DoubleProperty width = mediaView.fitWidthProperty();//set width to width of the media player
                    DoubleProperty height = mediaView.fitHeightProperty();//set height to height of the media player
                    width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
                    height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
                mediaPlayer.play();//plays the media player if something is loaded into it
            }
    }
    
    @FXML
    private void pauseVideo(ActionEvent event){
        mediaPlayer.pause();
    }
    
    @FXML
    private void playVideo(ActionEvent event){
        mediaPlayer.play();
        mediaPlayer.setRate(1);
    }
    
    @FXML
    private void stopVideo(ActionEvent event){
        mediaPlayer.stop();
    }
    
    @FXML
    private void fastVideo(ActionEvent event){
        mediaPlayer.setRate(1.5);
    }
    
    @FXML
    private void fasterVideo(ActionEvent event){
        mediaPlayer.setRate(2);
    }
    
    @FXML
    private void slowVideo(ActionEvent event){
        mediaPlayer.setRate(.75);
    }
    
    @FXML
    private void slowerVideo(ActionEvent event){
        mediaPlayer.setRate(.5);
    }
    
    @FXML
    private void exitVideo(ActionEvent event){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
