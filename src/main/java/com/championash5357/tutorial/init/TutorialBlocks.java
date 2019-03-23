package com.championash5357.tutorial.init;

import com.championash5357.tutorial.block.BlockRubyOre;
import com.championash5357.tutorial.client.Tutorial;
import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Tutorial.MOD_ID)
public class TutorialBlocks {
	
	public static final Block RUBY_ORE = new BlockRubyOre();
	
	@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerBlock(final RegistryEvent.Register<Block> event) {
			final Block[] blocks = {
					RUBY_ORE
			};
			
			event.getRegistry().registerAll(blocks);
		}
		
		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
			final ItemBlock[] items = {
					new ItemBlock(RUBY_ORE, new Item.Properties().maxStackSize(32).rarity(EnumRarity.UNCOMMON).group(ItemGroup.BUILDING_BLOCKS))
			};
			
			for(final ItemBlock item : items) {
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has a null registry name", block);
				event.getRegistry().register(item.setRegistryName(registryName));
			}
			
			registerTileEntities();
		}
		
		private static void registerTileEntities() {
			
		}
	}
}
