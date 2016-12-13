package character;

import render.Animation;
import render.RenderableHolder;

public class Fireball extends Enemy {

	/**
	 * create fireball with default status
	 * position = 0, 0
	 * hp = 5
	 * speed = 5
	 * damage = 2
	 */
	public Fireball() {
		super();
	}
	
	/**
	 * create fireball with default status but specific position
	 * hp = 5
	 * speed = 5
	 * damage = 2
	 * @param positionX : fireball init x position
	 * @param positionY : fireball init y position
	 */
	public Fireball(int positionX, int positionY) {
		super(positionX, positionY);
	}

	/**
	 * create fireball with custom status
	 * @param positionX : position x
	 * @param positionY : position y
	 * @param hp 
	 * @param speed
	 * @param damage
	 */
	public Fireball(int positionX, int positionY, int hp, int speed, int damage) {
		super(positionX, positionY, hp, speed, damage);
	}

	@Override
	protected void loadIdleLeft() {
		// TODO Auto-generated method stub
		this.idleLeft = new Animation(RenderableHolder.getInstance().fireballSprite, 128, 128, 4, 2, 0);
		this.idleLeft.setPosition(this.logicalX, this.logicalY);
	}

	@Override
	protected void loadIdleRight() {
		// TODO Auto-generated method stub
		this.idleRight = new Animation(RenderableHolder.getInstance().fireballSprite, 128, 128, 4, 2, 0);
		this.idleRight.setPosition(this.logicalX, this.logicalY);
	}

	@Override
	protected void loadWalkLeft() {
		// TODO Auto-generated method stub
		this.walkLeft = new Animation(RenderableHolder.getInstance().fireballSprite, 128, 128, 4, 2, 1);
		this.walkLeft.setPosition(this.logicalX, this.logicalY);
	}

	@Override
	protected void loadWalkRight() {
		// TODO Auto-generated method stub
		this.walkRight = new Animation(RenderableHolder.getInstance().fireballSprite, 128, 128, 4, 2, 1);
		this.walkRight.setPosition(this.logicalX, this.logicalY);

	}

	@Override
	protected void loadAttackLeft() {
		// TODO Auto-generated method stub
		this.attackLeft = new Animation(RenderableHolder.getInstance().fireballSprite, 128, 128, 8, 2, 2);
		this.attackLeft.setPosition(this.logicalX, this.logicalY);

	}

	@Override
	protected void loadAttackRight() {
		// TODO Auto-generated method stub
		this.attackRight = new Animation(RenderableHolder.getInstance().fireballSprite, 128, 128, 8, 2, 2);
		this.attackRight.setPosition(this.logicalX, this.logicalY);
	}

}
