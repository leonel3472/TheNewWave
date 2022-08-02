package tnw.blocks.defense;

import arc.struct.*;
import arc.audio.Sound;
import arc.math.Mathf;
import arc.scene.ui.layout.Table;
import arc.util.Time;
import mindustry.content.Items;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.*;
import mindustry.world.*;
import mindustry.type.ItemStack;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;
import mindustry.world.meta.StatValues;

import static mindustry.type.ItemStack.*;

public class FactoryScatter extends Block {
	/**
	 * a multi-functional turret.
	 * it can shoot bullets and produce items at the same time.
	 * @author 1237, Drifted Notes 
	 */
	public FactoryScatter(String name) {
		super(name);
		itemCapacity = 20;
		solid = destructible = sync = update = breakable = rebuildable = hasItems = acceptsItems = configurable = true;
	}
	public Sound shootSound = Sounds.wind3;
	public ItemStack[] outputItems = with(Items.copper, 1);
	public int shots = 4;
	public int shootMultiplier = 1;
	public int reload = 30;

	protected Seq<BulletType> bullets = new Seq<>();

	public void setStats(){
		super.setStats();
		stats.add(Stat.shots, shots);
		stats.add(Stat.reload, reload);
		stats.add(Stat.output, StatValues.items(reload, outputItems));
	}

	public void bullets(BulletType... bulletTypes){
		bullets.set(bulletTypes);
	}

	public class FactoryScatterBuild extends Building {
		float cooldown = 0;
		@Override
		public void updateTile(){
			if(cooldown >= 0){
				cooldown -= Time.delta;
			}
		}
		public void shoot(){
			if(efficiency == 1 && cooldown <= 0){
				for (int j = 1; j <= shots; j++) {
					for(int k = 0; k < shootMultiplier;k++){
						for(BulletType l : bullets){
							l.create(this, x, y, j * (360f / shots) + Mathf.random(-2f, 2f));
						}
						shootSound.at(x, y, Mathf.random(-1,1));
					}
				}

				if(outputItems != null){
					for(ItemStack output : outputItems){
						for(int i = 0; i < output.amount; i++){
							offload(output.item);
						}
					}
				}
			}
		}

		public void dumpOutputs() {
			if (outputItems != null && timer(timerDump, dumpTime / timeScale)) {
				for (ItemStack output : outputItems) {
					dump(output.item);
				}
			}
		}
		@Override
		public void buildConfiguration(Table table){
			table.button(Icon.commandAttack, () -> {
				if(cooldown <= 0){
					consume();
					shoot();
					dumpOutputs();
					cooldown = reload;
				}
			});
		}
	}
}
