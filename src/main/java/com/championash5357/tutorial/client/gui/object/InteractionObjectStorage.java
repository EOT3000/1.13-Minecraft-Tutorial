package com.championash5357.tutorial.client.gui.object;

import com.championash5357.tutorial.Tutorial;
import com.championash5357.tutorial.inventory.container.ContainerStorage;
import com.championash5357.tutorial.tileentity.TileEntityStorage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IInteractionObject;

public class InteractionObjectStorage implements IInteractionObject {
	
	private final TileEntityStorage storage;
	
	public InteractionObjectStorage(TileEntityStorage storage) {
		this.storage = storage;
	}
	
	@Override
	public ITextComponent getName() {
		return null;
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public ITextComponent getCustomName() {
		return null;
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerStorage(playerInventory, storage);
	}

	@Override
	public String getGuiID() {
		return Tutorial.MOD_ID + ":storage_gui";
	}

}
