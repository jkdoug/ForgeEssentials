package com.ForgeEssentials.WorldControl;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class WandProxy {
	
	public boolean tryPlaceIntoWorld(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		FunctionHandler.instance.point2X.put(par2EntityPlayer.username, par4);
		FunctionHandler.instance.point2Y.put(par2EntityPlayer.username, par5);
		FunctionHandler.instance.point2Z.put(par2EntityPlayer.username, par6);
		return true;
    }
	
	public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player) 
    {
		FunctionHandler.instance.point1X.put(player.username, X);
		FunctionHandler.instance.point1Y.put(player.username, Y);
		FunctionHandler.instance.point1Z.put(player.username, Z);
    	return true;
    }
	
}
