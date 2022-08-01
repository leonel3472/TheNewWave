package tnw.content;

import mindustry.entities.bullet.*;
import arc.graphics.*;

public class NWBullets {
	public static BulletType
	// empty bullet for placeholder
	empty, 
	// bullet wall bullets
	maraniumWallBullet;
	
	public static void load() {
		empty = new BasicBulletType(0,0){{
			width = height = 0;
		}};
		maraniumWallBullet = new BasicBulletType(6, 14){{
			width = height = 8.5f;
			frontColor = NWItems.maranium.color;
			backColor = Color.valueOf("8F665B");
		}};
	}
}
