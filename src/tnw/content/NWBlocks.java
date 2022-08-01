package tnw.content;

import mindustry.world.*;

public class NWBlocks {
	public static Block start;
	public static void load(){
		start = new Block("start"){{
			alwaysUnlocked = true;
		}};
	}
}
