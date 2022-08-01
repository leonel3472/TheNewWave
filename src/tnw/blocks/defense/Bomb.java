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
import mindustry.world.*;

/**
  * a wall that can explode
  * @author Drifted Notes / 1237
  */
public class Bomb extends Block {
	public Bomb(String name){
		super(name);
		solid = destructible = sync = update = breakable = rebuildable = true;
		scaledHealth = 100;
	}
	public float explodeTime = 30, explosionDamage = 10, explosionRange = 32;
	public Effect explodeFx = Fx.none;
	public class BombBuild extends Building {
		public void updateTile(){
			time -= Time.delta;
			if(time <= 0){
				Damage.damage(this.team, x,y,explosionRange,explosionDamage);
				explodeFx.at(x,y);
				kill();
			}
		}
	}
}
