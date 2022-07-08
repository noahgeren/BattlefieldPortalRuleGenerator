package com.noahgeren.bprg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Rule {

	private String name;
	private Event event;
	private Condition[] conditions;
	private List<Action> actions = new LinkedList<>();

	private static final List<Event> GLOBAL_EVENTS = Arrays.asList(Event.ONGOING_GLOBAL, Event.ONGOING_CAPTURE_POINT,
			Event.ONGOING_PLAYER, Event.ONGOING_TEAM, Event.ONGOING_VEHICLE);

	protected Rule(String name, Event event, Condition... conditions) {
		this.name = name;
		this.event = event;
		this.conditions = conditions;
	}

	public Rule addActions(Action... actions) {
		this.actions.addAll(Arrays.asList(actions));
		return this;
	}

	@Override
	public String toString() {
		// TODO
		return null;
	}

	public static enum Event {
		// TODO
		ONGOING_GLOBAL, ONGOING_CAPTURE_POINT, ONGOING_PLAYER, ONGOING_TEAM, ONGOING_VEHICLE, ON_PLAYER_DIED;
	}

}
