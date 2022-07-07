package com.noahgeren.bprg.testing;

import com.noahgeren.bprg.Mod;
import com.noahgeren.bprg.Rule;
import com.noahgeren.bprg.Value;
import com.noahgeren.bprg.Variable;
import com.noahgeren.bprg.Variable.VariableType;
import com.noahgeren.bprg.rules.Condition;
import com.noahgeren.bprg.rules.Event;

public class Main {

	public static void main(String[] args) {
		Mod mod = new Mod();
		
		Variable<Integer> points = mod.addVariable("points", VariableType.PLAYER); 
		
		Rule gunGame = mod.addRule("Gungame", Event.ONGOING_GLOBAL, new Condition());
		gunGame.addActions(points.set(Value.getNumber(0)));
	}

}
