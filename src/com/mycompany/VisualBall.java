import com.mycompany.classes.Ball;
import com.mycompany.classes.Container;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VisualBall extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Ball ball = new Ball(150,150,50,50,45);
        Container container = new Container(100,100,100,100);

        HBox bigBox = new HBox();
        bigBox.setPadding(new Insets(10,10,10,10));
        bigBox.setSpacing(20);
        bigBox.setAlignment(Pos.CENTER);

        VBox buttonBox = new VBox();
        buttonBox.setPadding(new Insets(10,10,10,10));
        buttonBox.setSpacing(20);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);

        final Canvas canvas = new Canvas(400,400);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.setLineWidth(2);
        graphicsContext.strokeRect(0, 0, 400, 400);
        drawBall(graphicsContext, ball, container);
//        graphicsContext.strokeRect(container.getX(),container.getY(), container.getWidth(),
//                container.getHeight());
//        graphicsContext.strokeOval(ball.getX() - ball.getRadius(),ball.getY() - ball.getRadius(), ball.getRadius()*2, ball.getRadius()*2);
//        graphicsContext.strokeLine(ball.getX(), ball.getY(), ball.getX() + ball.getXDelta(), ball.getYDelta() + ball.getY());


        Button moveButton = new Button("Move");

        moveButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ball.move();
                drawBall(graphicsContext, ball, container);
            }
        });

        Button reflectHButton = new Button("Reflect horizontally");

        reflectHButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ball.reflectHorizontal();
                drawBall(graphicsContext, ball, container);
            }
        });

        Button reflectVButton = new Button("Reflect vertically");

        reflectVButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ball.reflectVertical();
                drawBall(graphicsContext, ball, container);
            }
        });

        Group root = new Group();
        buttonBox.getChildren().addAll(moveButton, reflectHButton, reflectVButton);
        bigBox.getChildren().addAll(canvas, buttonBox);
        root.getChildren().add(bigBox);

        Scene scene = new Scene(root, 600, 500);

        stage.setTitle("Sample application");

        stage.setScene(scene);

        stage.show();
    }

    public static void drawBall(GraphicsContext graphicsContext, Ball ball, Container container) {
        graphicsContext.clearRect(0,0,400,400);
        graphicsContext.strokeRect(container.getX(),container.getY(), container.getWidth(),
                container.getHeight());
        graphicsContext.strokeOval(ball.getX() - ball.getRadius(),ball.getY() - ball.getRadius(), ball.getRadius()*2, ball.getRadius()*2);
        double finalPointX = ball.getX() + ball.getXDelta();
        double finalPointY = ball.getYDelta() + ball.getY();
        double arrowCenterX = ball.getX() + ball.getXDelta()*0.9;
        double arrowCenterY = ball.getY() + ball.getYDelta()*0.9;
        double arrowLength = 4;
        double dx = finalPointX - arrowCenterX;
        double dy = finalPointY - arrowCenterY;
        double LineLenght =  Math.sqrt(dx * dx + dy * dy);
        double arrowPoint1X = arrowCenterX + dy * (arrowLength/LineLenght);
        double arrowPoint1Y = arrowCenterY - dx*(arrowLength/LineLenght);
        double arrowPoint2X = arrowCenterX - dy * (arrowLength/LineLenght);
        double arrowPoint2Y = arrowCenterY + dx * (arrowLength/LineLenght);
        graphicsContext.strokeLine(ball.getX(), ball.getY(), ball.getX() + ball.getXDelta(), ball.getYDelta() + ball.getY());
        graphicsContext.strokeLine(arrowPoint1X, arrowPoint1Y, finalPointX, finalPointY);
        graphicsContext.strokeLine(arrowPoint2X, arrowPoint2Y, finalPointX, finalPointY);
    }

}
