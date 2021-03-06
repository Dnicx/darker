package character;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import character.Enemy;
import exception.StageLoadingException;
import main.Main;

public class EnemyHolder {

	public static final int fireball = 1;
	public static final int skull = 2;
	public static final int cute = 3;
	public static final int tongue = 4;
	private static final EnemyHolder instance = new EnemyHolder();
	private List<Enemy> enemyPack;

	public EnemyHolder() {
		enemyPack = new ArrayList<>();
	}

	
	/**
	 * load mob from file mob.txt in stage folder
	 * @throws StageLoadingException
	 */
	public void loadMob() throws StageLoadingException {
		String source = "" + Main.level + Main.stage + "/" + Main.levelMonsterFile;

		try {
			Scanner mob = new Scanner(new File(source));
			int n = mob.nextInt();
			int mobType;
			for (int i = 0; i < n; i++) {
				mobType = mob.nextInt();
				if (mobType == EnemyHolder.fireball)
					new Fireball(mob.nextInt(), mob.nextInt(), mob.nextInt(), mob.nextInt(), mob.nextInt());
				else if (mobType == EnemyHolder.skull)
					new Skull(mob.nextInt(), mob.nextInt(), mob.nextInt(), mob.nextInt(), mob.nextInt());
				else if (mobType == EnemyHolder.tongue)
					new Tongue(mob.nextInt(), mob.nextInt(), mob.nextInt(), mob.nextInt(), mob.nextInt());
				else if (mobType == EnemyHolder.cute)
					new Cute(mob.nextInt(), mob.nextInt(), mob.nextInt(), mob.nextInt(), mob.nextInt());
				else {
					mobType = mob.nextInt();
					mobType = mob.nextInt();
					mobType = mob.nextInt();
					mobType = mob.nextInt();
					mobType = mob.nextInt();
				}
			}
			mob.close();
		} catch (NullPointerException e) {
			throw new StageLoadingException(StageLoadingException.MOB_NOTFOUND);
		} catch (Exception e) {
			throw new StageLoadingException(StageLoadingException.WRONG_FORMAT);
		}
	}

	/**
	 * @param e
	 *            : single enemy
	 */
	public synchronized void add(Enemy e) {
		enemyPack.add(e);
	}


	public synchronized void remove(Enemy e) {
		enemyPack.remove(enemyPack.indexOf(e));
	}

	public synchronized void remove(int e) {
		enemyPack.remove(e);
	}

	public void clear() {
		enemyPack.clear();
	}

	public List<Enemy> getEnemyPack() {
		return enemyPack;
	}

	public static EnemyHolder getInstance() {
		return instance;
	}
}
