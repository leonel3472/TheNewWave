package tnw.content;

import mindustry.world.blocks.*;
import mindustry.world.consumers.*;
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
import static mindustry.type.ItemStack.*;

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
			requirements(Category.defense, with(NWItems.maranium, 8));
			bullet(WBullets.maraniumWallBullet);
			shots = 4;
			scaledHealth = 105;
		}};
		maraniumWallLarge = new BulletWall("maranium-wall-large"){{
			requirements(Category.defense, with(NWItems.maranium, 32));
			bullet(WBullets.maraniumWallBullet);
			size = 2;
			shots = 4;
			scaledHealth = 105;
		}};
	}
}
