package com.championash5357.tutorial.client.gui;

import com.championash5357.tutorial.Tutorial;
import com.championash5357.tutorial.inventory.container.ContainerStorage;
import com.championash5357.tutorial.tileentity.TileEntityStorage;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiStorage extends GuiContainer {

	private static final ResourceLocation INVENTORY = new ResourceLocation(Tutorial.MOD_ID, "textures/gui/container/storage_gui.png");
	
	public GuiStorage(InventoryPlayer player, TileEntityStorage storage) {
		super(new ContainerStorage(player, storage));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(INVENTORY);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}

}
