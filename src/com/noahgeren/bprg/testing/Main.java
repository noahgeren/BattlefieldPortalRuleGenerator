package com.noahgeren.bprg.testing;

import com.noahgeren.bprg.BattlefieldPortalRuleGenerator;
import com.noahgeren.bprg.Condition;
import com.noahgeren.bprg.Mod;
import com.noahgeren.bprg.Rule;
import com.noahgeren.bprg.Rule.Event;
import com.noahgeren.bprg.Value;
import com.noahgeren.bprg.Variable;
import com.noahgeren.bprg.Variable.VariableType;

public class Main {

	public static void main(String[] args) {
		Mod mod = BattlefieldPortalRuleGenerator.startMod();
		
		Variable<Integer> points = mod.addVariable("points", VariableType.PLAYER); 
		
		Rule gunGame = mod.addRule("gungame", Event.ONGOING_GLOBAL, new Condition());
		gunGame.addActions(points.set(Value.getNumber(0)));
	}

}
