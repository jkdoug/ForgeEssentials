package com.forgeessentials.commands;

import java.util.List;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;

import com.forgeessentials.api.permissions.RegGroup;
import com.forgeessentials.commands.util.FEcmdModuleCommands;
import com.forgeessentials.util.FunctionHelper;
import com.forgeessentials.util.OutputHandler;

import cpw.mods.fml.common.FMLCommonHandler;

public class CommandLocate extends FEcmdModuleCommands
{
	@Override
	public String getCommandName()
	{
		return "locate";
	}

	@Override
	public String[] getDefaultAliases()
	{
		return new String[]
		{ "gps", "loc", "playerinfo"};
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args)
	{
		if (args.length != 1)
		{
			OutputHandler.chatError(sender, "Improper syntax. Please try this instead: " + getSyntaxConsole());
		}
		else
		{
			EntityPlayerMP player = FunctionHelper.getPlayerForName(sender, username);
			if (player == null)
			{
				OutputHandler.chatError(sender, String.format("Player %s does not exist, or is not online.", username));
			}
			else
			{
				OutputHandler.chatConfirmation(sender, Localization.format("command.locate.msg", player.username, (int) player.posX, (int) player.posY, (int) player.posZ, player.dimension, player.theItemInWorldManager.getGameType().getName()));
			}
		}
	}

	@Override
	public boolean canConsoleUseCommand()
	{
		return true;
	}

	@Override
	public String getCommandPerm()
	{
		return "ForgeEssentials.BasicCommands." + getCommandName();
	}

	@Override
	public List<String> addTabCompletionOptions(ICommandSender sender, String[] args)
	{
		if (args.length == 1)
			return getListOfStringsMatchingLastWord(args, FMLCommonHandler.instance().getMinecraftServerInstance().getAllUsernames());
		else
			return null;
	}

	@Override
	public RegGroup getReggroup()
	{
		return RegGroup.OWNERS;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/locate <player> Locates a player.";
	}
}
