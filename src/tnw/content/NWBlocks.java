package tnw.content;

import mindustry.type.*;
import mindustry.ctype.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.meta.*;
import mindustry.content.*;
import mindustry.graphics.*;
import static mindustry.type.ItemStack.*;

public class NWBlocks {
	public static Block
	// turret
	root;

	public static void load(){
		root = new ItemTurret("root"){{
			requirements(Category.turret, with(Items.copper, 28, Items.lead, 15));
			// todo ammo(Items.copper, Items.lead, Items.graphite);
			shootCone = 15;
			inaccuracy = 2;
			rotateSpeed = 9;
			ammoUseEffect = Fx.casing1;
			recoil = 1.25f;
		}};
	}
}
