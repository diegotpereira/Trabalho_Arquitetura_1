package br.edu.qi.view.component;

//import br.edu.qi.control.IController;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import br.edu.qi.controller.IController;

public class BotaoExcluir implements Callback<TableColumn<Object, Integer>, TableCell<Object, Integer>> {

    private IController controller;

    public BotaoExcluir(IController controller) {
        this.controller = controller;
    }

    @Override
    public TableCell<Object, Integer> call(TableColumn<Object, Integer> param) {
        TableCell<Object, Integer> cell = new TableCell<Object, Integer>() {

            @Override
            public void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                    setText(null);
                    return;
                }

                Button btn = new Button();
                Image img = new Image(getClass().getResourceAsStream("/com/jdenner/view/img/Excluir.png"));
                btn.setGraphic(new ImageView(img));
                btn.setStyle("-fx-background-color: transparent;");
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        controller.excluir(item);
                    }
                });
                if (item == 0) {
                    btn.setDisable(true);
                }
                setGraphic(btn);
                setText(null);
            }
        };
        return cell;
    }

}
