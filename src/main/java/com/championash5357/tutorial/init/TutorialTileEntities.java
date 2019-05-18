package com.championash5357.tutorial.init;

import com.championash5357.tutorial.client.renderer.TileEntityJarRenderer;
import com.championash5357.tutorial.tileentity.TileEntityJar;
import com.championash5357.tutorial.tileentity.TileEntityStorage;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import static com.championash5357.tutorial.util.InjectionUtil.Null;

import com.championash5357.tutorial.Tutorial;
@ObjectHolder(Tutorial.MOD_ID)
public class TutorialTileEntities {

	public static final TileEntityType<?> JAR = Null();
	public static final TileEntityType<?> STORAGE = Null();

	@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event) {
			final TileEntityType<?>[] tile_entities = {
					TileEntityType.Builder.create(TileEntityJar::new).build(null).setRegistryName(Tutorial.MOD_ID, "jar"),
					TileEntityType.Builder.create(TileEntityStorage::new).build(null).setRegistryName(Tutorial.MOD_ID, "storage")
			};
			
			event.getRegistry().registerAll(tile_entities);
		}
	}
	
	public static void renders() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJar.class, new TileEntityJarRenderer());
	}
}