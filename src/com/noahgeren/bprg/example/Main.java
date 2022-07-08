package com.noahgeren.bprg.example;

import java.io.File;
import java.io.IOException;

import com.noahgeren.bprg.BattlefieldPortalRuleGenerator;
import com.noahgeren.bprg.Condition;
import com.noahgeren.bprg.EventPayloads;
import com.noahgeren.bprg.Mod;
import com.noahgeren.bprg.Rule;
import com.noahgeren.bprg.Rule.Event;
import com.noahgeren.bprg.Value;
import com.noahgeren.bprg.Variable.PlayerVariable;

public class Main {

	public static void main(String[] args) throws IOException {
		Mod mod = BattlefieldPortalRuleGenerator.startMod();
		
		PlayerVariable<Integer> points = mod.addPlayerVariable("points"); 
		
		Rule gunGame = mod.addRule("reset", Event.ON_PLAYER_DIED, new Condition());
		gunGame.addActions(points.set(Value.getNumber(0), EventPayloads.EVENT_PLAYER));
		
		mod.export(new File("test.json"));
	}

}
