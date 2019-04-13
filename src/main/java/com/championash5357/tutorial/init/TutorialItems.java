package com.championash5357.tutorial.init;

import com.championash5357.tutorial.client.Tutorial;
import com.championash5357.tutorial.item.ItemRuby;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Tutorial.MOD_ID)
public class TutorialItems {
	
	public static final Item RUBY = new ItemRuby();
	
	@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			final Item[] item = {
					RUBY
			};
			
			event.getRegistry().registerAll(item);
		}
	}
}
