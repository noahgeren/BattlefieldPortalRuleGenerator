package com.noahgeren.bprg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Rule {

	private String name;
	private Event event;
	private Condition[] conditions;
	private List<Action> actions = new LinkedList<>();

	private static final List<Event> ONGOING_EVENTS = Arrays.asList(Event.ONGOING_GLOBAL, Event.ONGOING_CAPTURE_POINT,
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

	protected String toString(List<Rule> nextRules) {
		StringBuilder conditionXml = new StringBuilder();
		for (Condition condition : conditions) {
			conditionXml.append(condition.toString());
		}
		StringBuilder actionXml = new StringBuilder();
		actions.forEach(action -> actionXml.append(action.toString()));
		StringBuilder xml = new StringBuilder(String.format(
				"<block type=\\\"ruleBlock\\\"><mutation isOnGoingEvent=\\\"%b\\\"></mutation>"
						+ "<field name=\\\"NAME\\\">%s</field><field name=\\\"EVENTTYPE\\\">%s</field>"
						+ "<statement name=\\\"CONDITIONS\\\">%s</statement>"
						+ "<statement name=\\\"ACTIONS\\\">%s</statement>",
				ONGOING_EVENTS.contains(event), name, event.getName(), conditionXml.toString(), actionXml.toString()));
		if (nextRules != null && !nextRules.isEmpty()) {
			xml.append(String.format("<next>%s</next>",
					nextRules.get(0).toString(nextRules.subList(1, nextRules.size()))));
		}
		xml.append("</block>");
		return xml.toString();
	}

	public static enum Event {
		// TODO
		ONGOING_GLOBAL(""), ONGOING_CAPTURE_POINT(""), ONGOING_PLAYER(""), ONGOING_TEAM(""), ONGOING_VEHICLE(""),
		ON_GAME_MODE_ENDING("OnGameModeEnding"), ON_GAME_MODE_STARTED("OnGameModeStarted"), ON_MANDOWN("OnMandown"),
		ON_PLAYER_DEPLOYED("OnPlayerDeployed"), ON_PLAYER_DIED("OnPlayerDied"),
		ON_PLAYER_EARNED_KILL("OnPlayerEarnedKill"), ON_PLAYER_ENTER_VEHICLE("OnPlayerEnterVehicle"),
		ON_PLAYER_ENTER_VEHICLE_SEAT("OnPlayerEnterVehicleSeat"), ON_PLAYER_EXIT_VEHICLE("OnPlayerExitVehicle"),
		ON_PLAYER_EXIT_VEHICLE_SEAT("OnPlayerExitVehicleSeat"), ON_PLAYER_UNDEPLOY("OnPlayerUndeploy"),
		ON_PLAYER_JOIN_GAME("OnPlayerJoinGame"), ON_PLAYER_LEAVE_GAME("OnPlayerLeaveGame"), ON_REVIVED("OnRevived"),
		ON_TIME_LIMIT_REACHED("OnTimeLimitReached"), ON_VEHICLE_DESTROYED("OnVehicleDestroyed"),
		ON_VEHICLE_DEPLOYED("OnVehicleDeployed");

		private String name;

		private Event(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

}
