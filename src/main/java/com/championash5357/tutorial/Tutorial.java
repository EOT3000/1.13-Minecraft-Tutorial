package com.championash5357.tutorial;

import com.championash5357.tutorial.client.gui.GuiStorage;
import com.championash5357.tutorial.init.TutorialTab;
import com.championash5357.tutorial.init.TutorialTileEntities;
import com.championash5357.tutorial.tileentity.TileEntityStorage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Tutorial.MOD_ID)
public class Tutorial {
	
	public static final String MOD_ID = "tutorial";
	
	public static final ItemGroup TUTORIAL_TAB = new TutorialTab();
	
	public Tutorial() {
		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.GUIFACTORY, () -> {
			return (openContainer) -> {
				ResourceLocation location = openContainer.getId();
				if(location.toString().equals(MOD_ID + ":storage_gui")) {
					EntityPlayerSP player = Minecraft.getInstance().player;
					BlockPos pos = openContainer.getAdditionalData().readBlockPos();
					TileEntity tile = player.world.getTileEntity(pos);
					if(tile instanceof TileEntityStorage) return new GuiStorage(player.inventory, (TileEntityStorage) tile);
				}
				return null;
			};
		});
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void setup(final FMLCommonSetupEvent event) {
		
	}
	
	public void clientSetup(final FMLClientSetupEvent event) {
		TutorialTileEntities.renders();
	}
	
	public void enqueueIMC(final InterModEnqueueEvent event) {
		
	}
	
	public void processIMC(final InterModProcessEvent event) {
		
	}
	
	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
		
	}
}
