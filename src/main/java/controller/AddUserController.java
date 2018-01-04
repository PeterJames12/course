package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lombok.SneakyThrows;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class AddUserController implements Initializable {

    @FXML
    private TextField txtName;
    @FXML
    private TextArea txtAbout;
    @FXML
    private Button btnSave;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnSave.setOnAction(event -> save());
    }

    @SneakyThrows
    private void save() {
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setName(txtName.getText());
        user.setAbout(txtAbout.getText());
        userService.save(user);
    }
}
