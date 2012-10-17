/*
 * This file is part of Craftconomy3.
 *
 * Copyright (c) 2011-2012, Greatman <http://github.com/greatman/>
 *
 * Craftconomy3 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Craftconomy3 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Craftconomy3.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.greatmancode.craftconomy3.commands.money;

import java.util.Iterator;

import com.greatmancode.craftconomy3.Common;
import com.greatmancode.craftconomy3.account.Account;
import com.greatmancode.craftconomy3.account.Balance;
import com.greatmancode.craftconomy3.commands.interfaces.CraftconomyCommand;

public class BalanceCommand extends CraftconomyCommand {

	@Override
	public void execute(String sender, String[] args) {
		if (Common.getInstance().getAccountManager().exist(args[0])) {
			Common.getInstance().getServerCaller().sendMessage(sender, "{{WHITE}} " + args[0] + " {{DARK_GREEN}}Balance: ");
			Account account = Common.getInstance().getAccountManager().getAccount(args[0]);
			Iterator<Balance> balanceList = account.getAllBalance().iterator();
			while (balanceList.hasNext()) {
				Balance bl = balanceList.next();
				Common.getInstance().getServerCaller().sendMessage(sender, Common.getInstance().format(bl.getWorld(), bl.getCurrency(), bl.getBalance()));

			}
		} else {
			Common.getInstance().getServerCaller().sendMessage(sender, "{{DARK_RED}}Account not found!");
		}

	}

	@Override
	public String help() {
		return "/money balance <Player Name> - Display the balance of a player";
	}

	@Override
	public int maxArgs() {
		return 1;
	}

	@Override
	public int minArgs() {
		return 1;
	}

	@Override
	public boolean playerOnly() {
		return false;
	}

	@Override
	public String getPermissionNode() {
		return "craftconomy.money.balance.others";
	}

}
