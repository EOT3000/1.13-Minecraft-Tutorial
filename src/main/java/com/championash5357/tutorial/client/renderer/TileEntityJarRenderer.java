package com.championash5357.tutorial.client.renderer;

import com.championash5357.tutorial.tileentity.TileEntityJar;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TileEntityJarRenderer extends TileEntityRenderer<TileEntityJar> {

	@Override
	public void render(TileEntityJar tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage) {
		super.render(tileEntityIn, x, y, z, partialTicks, destroyStage);
		
		EntityItem cookie = new EntityItem(Minecraft.getInstance().world, 0, 0, 0, new ItemStack(Items.COOKIE));
		cookie.hoverStart = 0F;
		
		GlStateManager.pushMatrix();
		GlStateManager.translated(x, y, z);
		GlStateManager.rotatef(90F, 1, 0, 0);
		GlStateManager.translatef(0.5F, 0.1F, -0.08F);
		for(int i = 0; i < tileEntityIn.amount(); i++) {
			GlStateManager.pushMatrix();
			GlStateManager.translatef(0.0F, i % 2 == 1 ? 0.1F : 0.0F, (float) (-0.0625/2 * i));
			Minecraft.getInstance().getRenderManager().renderEntity(cookie, 0, 0, 0, 0F, 0F, false);
			GlStateManager.popMatrix();
		}
		GlStateManager.popMatrix();
	}
}
