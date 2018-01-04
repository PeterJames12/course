package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import lombok.SneakyThrows;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    @FXML
    private TableView<User> usersTable;
    @FXML
    private TableColumn<User, Integer> columnId;
    @FXML
    private TableColumn<User, String> columnName;
    @FXML
    private TableColumn<User, String> columnAbout;
    @FXML
    private Button btnAdd;

    private ObservableList<User> usersList = FXCollections.observableArrayList();

    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        List<User> all = userService.findAll();
        all.forEach(System.out::println);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
        btnAdd.setOnAction(this::add);

        usersTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                System.out.println(usersTable.getSelectionModel()
                        .getSelectedItem());
            }
        });
    }

    private void init() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAbout.setCellValueFactory(new PropertyValueFactory<>("about"));
        load();
    }

    @SneakyThrows
    private void load() {
        usersList.clear();
        UserService userService = new UserServiceImpl();
        List<User> users = userService.findAll();
        usersList.addAll(users);
        usersTable.setItems(usersList);
    }

    @SneakyThrows
    private void add(ActionEvent event) {
        final FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/view/add_user.fxml"));
        Parent parent = fxmlLoader.load();

        final Stage stage = new Stage();
        Scene value = new Scene(parent);
        value.getStylesheets().add("css/main.css");
        stage.setScene(value);
        stage.initModality(Modality.WINDOW_MODAL);
        Window window = ((Node) event.getSource()).getScene().getWindow();
        stage.initOwner(window);
        stage.show();

        stage.setOnHiding(e -> load());
    }
}
