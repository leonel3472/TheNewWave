package tnw.content;

import mindustry.world.meta.*;
import mindustry.type.*;
import mindustry.ctype.*;
import mindustry.world.*;

public class NWBlocks {
	public static Block start;
	public static void load(){
		// code borrowed from project oblivion
		start = new Block("start"){{
			alwaysUnlocked = true;
			buildVisibility = BuildVisibility.debugOnly;
			inEditor = false;
		}};
	}
}
