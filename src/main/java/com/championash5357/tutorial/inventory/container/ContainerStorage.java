package com.championash5357.tutorial.inventory.container;

import com.championash5357.tutorial.tileentity.TileEntityStorage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerStorage extends Container {

	private final TileEntityStorage storage;
	
	public ContainerStorage(InventoryPlayer player, TileEntityStorage storage) {
		this.storage = storage;
		ItemStackHandler inventory = storage.getInventory();
		
		for(int y = 0; y < 3; ++y)
			for(int x = 0; x < 3; ++x)
				this.addSlot(new SlotItemHandler(inventory, x + y * 3, 62 + x * 18, 17 + y * 18) {
					@Override
					public void onSlotChanged() {
						storage.save();
					}
				});
		
		for(int y = 0; y < 3; ++y)
			for(int x = 0; x < 9; ++x)
				this.addSlot(new Slot(player, 9 + x + y * 9, 8 + x * 18, 84 + y * 18));
		
		for(int x = 0; x < 9; ++x)
			this.addSlot(new Slot(player, x, 8 + x * 18, 142));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.storage.interact(playerIn);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack previous = ItemStack.EMPTY;
		Slot slot = (Slot) this.inventorySlots.get(index);
		
		if(slot != null && slot.getHasStack()) {
			ItemStack current = slot.getStack();
			previous = current.copy();
			
			if(index < 9) {
				if(!this.mergeItemStack(current, 9, 45, true))
					return ItemStack.EMPTY;
			} else {
				if(!this.mergeItemStack(current, 0, 9, false))
					return ItemStack.EMPTY;
			}
			
			if(current.getCount() == 0)
				slot.putStack((ItemStack) ItemStack.EMPTY);
			else
				slot.onSlotChanged();
			
			if(current.getCount() == previous.getCount())
				return ItemStack.EMPTY;
			slot.onTake(playerIn, current);
		}
		
		return previous;
	}
}
