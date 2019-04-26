package com.championash5357.tutorial.init;

import com.championash5357.tutorial.client.Tutorial;
import com.championash5357.tutorial.item.ItemRuby;
import com.championash5357.tutorial.item.ItemTutorialRecord;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Tutorial.MOD_ID)
public class TutorialItems {
	
	public static final Item RUBY = new ItemRuby();
	public static final ItemTutorialRecord PERSPECTIVES_RECORD = new ItemTutorialRecord(8, TutorialSounds.PERSPECTIVES, new Properties().maxStackSize(1).group(Tutorial.TUTORIAL_TAB).rarity(EnumRarity.EPIC), "perspectives_record");
	
	@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			final Item[] item = {
					RUBY,
					PERSPECTIVES_RECORD
			};
			
			event.getRegistry().registerAll(item);
		}
	}
}
