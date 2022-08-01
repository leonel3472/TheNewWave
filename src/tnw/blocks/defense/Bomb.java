package tnw.blocks.defense;

import arc.*;
import arc.audio.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.util.*;
import mindustry.gen.*;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.entities.*;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.meta.*;

/**
  * a wall that can explode
  * @author Drifted Notes / 1237
  */
public class Bomb extends Wall {
	public Bomb(String name){
		super(name);
	}

	/** time needed to explode */
	public float explodeTime = 240f;
	/** the effect created when it explodes */
	public Effect explodeFx = Fx.massiveExplosion;
	/** the explosion damage */
	public int explosionDamage = 5;
	/** the explosion range (8 unit = 1 block) */
	public int explosionRange = 128;

	public class BombBuild extends Building {
		float time = explodeTime;
		@Override
		public void updateTile(){
			super.updateTile();
			time -= Time.delta;
			if(time <= 0){
		 	 	Damage.damage(this.team, x, y, explosionRange, explosionDamage);
				explodeFx.at(x,y);
				kill();
			}
		}
	}
}
