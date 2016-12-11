package scene;

import java.io.File;
import java.util.Scanner;

import character.Hero;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import logic.GameLogic;
import logic.InputUtility;
import render.Background;
import render.Renderable;
import render.RenderableHolder;

public class GameScreen extends StackPane {

	private Canvas canvas;
	private Hero knight;
	private GraphicsContext gc;
	public Background background;
	public GameLogic gameLogic;
	public String file;
	
	public int heroStartX = 450;
	public int heroStartY = 0;

	public GameScreen(int width, int height, String file) {
		this.file = file;
		
		canvas = new Canvas(width, height);
		gc = canvas.getGraphicsContext2D();
		this.getChildren().add(canvas);
		RenderableHolder.getInstance().loadResource();
		knight = new Hero(heroStartX, heroStartY);
		background = new Background(RenderableHolder.getInstance().testStageFar, RenderableHolder.getInstance().testStageNear);
		background.setFarPosition(0, 0);
		background.setNearPosition(0, 0);
		gameLogic = new GameLogic(this);
		
		
		new AnimationTimer() {
			long start = 1;
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				if (start == 1) start = now;
				long dif = now - start;
				if (dif >= 30000000) {
					start = now;
					for (Renderable r : RenderableHolder.getInstance().getEntity()) {
						r.render(gc);
					}
					gameLogic.updateLogic();
					InputUtility.update();	
				}
			}
		}.start();
		
	}

	public GraphicsContext getGraphicContext() {
		return gc;
	}
	
	public Hero getHero() {
		return knight;
	}

}
