package tnw.content;

import mindustry.world.meta.*;
import mindustry.type.*;
import mindustry.ctype.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.world.*;
import mindustry.world.draw.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import tnw.blocks.defense.*;

public class NWBlocks {
	public static Block 
	// start
	start,
	// wall
	maraniumWall, maraniumWallLarge;
	public static void load(){
		// start
		// code borrowed from project oblivion
		start = new Block("start"){{
			alwaysUnlocked = true;
			buildVisibility = BuildVisibility.debugOnly;
			inEditor = false;
		}};
		// wall
		maraniumWall = new BulletWall("maranium-wall"){{
			requirements(defense, with(maranium, 8));
			bullet(WBullets.maraniumWallBullet);
			shots = 4;
			scaledHealth = 105;
		}};
		maraniumWallLarge = new BulletWall("maranium-wall-large"){{
			requirements(defense, with(maranium, 8));
			bullet(WBullets.maraniumWallBullet);
			size = 2;
			shots = 4;
			scaledHealth = 105;
		}};
	}
}
