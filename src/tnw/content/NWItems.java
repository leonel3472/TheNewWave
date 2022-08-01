package tnw.content;

import arc.graphics.*;
import arc.struct.Seq;
import mindustry.type.*;

public class NWItems {
	public static Item maranium;
	public static void load(){
		maranium = new Item("maranium", Color.valueOf("EBB778FF")){{
			cost = 0.01f;
		}};
	}
}
