package com.noahgeren.bprg.example;

import java.io.File;
import java.io.IOException;

import com.noahgeren.bprg.Condition;
import com.noahgeren.bprg.EventPayloads;
import com.noahgeren.bprg.Mod;
import com.noahgeren.bprg.Rule.Event;
import com.noahgeren.bprg.Value;
import com.noahgeren.bprg.Variable.PlayerVariable;
import com.noahgeren.bprg.Math;

public class Example {

	public static void main(String[] args) throws IOException {
		Mod mod = new Mod();

		PlayerVariable<Number> points = mod.addPlayerVariable("points");

		mod.addRule("resetPlayerPoints", Event.ON_PLAYER_DEPLOYED, Condition.alwaysTrue())
				.addActions(points.set(Value.getNumber(0), EventPayloads.EVENT_PLAYER));

		mod.addRule("incrementPlayerPoints", Event.ON_PLAYER_EARNED_KILL, Condition.alwaysTrue()).addActions(points
				.set(Math.add(points.get(EventPayloads.EVENT_PLAYER), Value.getNumber(1)), EventPayloads.EVENT_PLAYER));

		mod.export(new File("test.json"));
	}

}
