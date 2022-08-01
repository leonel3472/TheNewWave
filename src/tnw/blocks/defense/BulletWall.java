package tnw.blocks.defense;

import arc.struct.*;
import arc.audio.Sound;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.Building;
import mindustry.gen.Sounds;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.meta.BlockGroup;

/**
 * @author 1237
 * a wall that shoots bullets when destroyed. a hybrid wall turret.
 */
public class BulletWall extends Wall {
	public BulletWall(String name){
		super(name);
		group = BlockGroup.walls;
	}
	protected Seq<BulletType> bullets = new Seq<>();

	public void bullet(BulletType... bulletTypes){
		bullets.set(bulletTypes);
	}
	
	public int shots = 3;
	public Sound shootSound = Sounds.shoot;
	
	public class BulletWallBuild extends Building {
		public void onDestroyed() {
			super.onDestroyed();
			for(int j = 0;j<shots;j++) {
				for(BulletType i : bullets){
					i.create(this, x, y, j * (360f / shots));
					shootSound.at(x,y,1);
				}
			}
		}
	}
}
