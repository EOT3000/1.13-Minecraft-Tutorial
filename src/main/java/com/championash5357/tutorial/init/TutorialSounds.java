package com.championash5357.tutorial.init;

import com.championash5357.tutorial.Tutorial;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
@ObjectHolder(Tutorial.MOD_ID)
public class TutorialSounds {
	
	public static final SoundEvent PERSPECTIVES = new SoundEvent(new ResourceLocation(Tutorial.MOD_ID, "perspectives")).setRegistryName(new ResourceLocation(Tutorial.MOD_ID, "perspectives"));
	
	@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void register(final RegistryEvent.Register<SoundEvent> event) {
			final SoundEvent[] sounds = {
					PERSPECTIVES
			};
			
			event.getRegistry().registerAll(sounds);
		}
	}
}
