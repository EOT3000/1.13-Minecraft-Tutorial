package com.championash5357.tutorial.init;

import com.championash5357.tutorial.client.Tutorial;
import com.championash5357.tutorial.client.renderer.TileEntityJarRenderer;
import com.championash5357.tutorial.tileentity.TileEntityJar;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import static com.championash5357.tutorial.util.InjectionUtil.Null;
@ObjectHolder(Tutorial.MOD_ID)
public class TutorialTileEntities {

	public static final TileEntityType<?> JAR = Null();

	@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event) {
			final TileEntityType<?>[] tile_entities = {
					TileEntityType.Builder.create(TileEntityJar::new).build(null).setRegistryName(Tutorial.MOD_ID, "jar")
			};
			
			event.getRegistry().registerAll(tile_entities);
		}
	}
	
	public static void renders() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJar.class, new TileEntityJarRenderer());
	}
}