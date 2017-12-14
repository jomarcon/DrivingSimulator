package com.exercise.simulator.model;

import static com.exercise.simulator.model.State.OFF;
import static com.exercise.simulator.model.State.ON;

public final class EventsStates {
	
	private static Event trafficState;
	private static Event weatherState;
	private static Event slipperyRoadState;
	private static Event emergencyTurboState;
	private static Event speedLimitState;
	
	public EventsStates() {
		trafficState = Event.TrafficClear;
		weatherState = Event.WeatherClear;
		slipperyRoadState = Event.SlipperyRoadClear;
		emergencyTurboState = Event.EmergencyTurboOff;
		speedLimitState = Event.SpeedLimitSignOff;
	}
	
	public boolean isNewEventValid(Event event) {
		
		if ( event == Event.TrafficClear && trafficState != Event.Traffic ) {
			return false;
		} 
		if ( event == Event.WeatherClear && weatherState != Event.WeatherRainy ) {
			return false;
		}
		if ( event == Event.SlipperyRoadClear && slipperyRoadState != Event.SlipperyRoad) {
			return false;
		}
		if ( (event == Event.EmergencyTurbo && slipperyRoadState == Event.SlipperyRoad) ||
				(event == Event.EmergencyTurbo && emergencyTurboState == Event.EmergencyTurbo)) {
			return false;
		}
		if ( event == Event.SpeedLimitSign && emergencyTurboState == Event.EmergencyTurbo) {
			setEmergencyTurboState(OFF);
			return true;
		}
		
		return true;
	}
	
	public void setState(Event event) {
		
		switch (event){
			case Traffic: 
				setTrafficState(ON);
				break;
			case TrafficClear:
				setTrafficState(OFF);
				break;
			case WeatherRainy:
				setWeatherState(ON);
				break;
			case WeatherClear:
				setWeatherState(OFF);
				break;
			case EmergencyTurbo:
				setEmergencyTurboState(ON);
				break;
			case EmergencyTurboOff:
				setEmergencyTurboState(OFF);
				break;
			case SlipperyRoad:
				setSlipperyRoadState(ON);
				break;
			case SlipperyRoadClear:
				setSlipperyRoadState(OFF);
				break;
			case SpeedLimitSign:
				setSpeedLimitState(ON);
				break;
			case SpeedLimitSignOff:
				setSpeedLimitState(OFF);
				break;
			default:
				break;
		}
		
	}

	public Event getTrafficState() {
		return trafficState;
	}

	public void setTrafficState(State state) {
		EventsStates.trafficState = (state == OFF) ? Event.TrafficClear : Event.Traffic;
	}
	
	public boolean isTrafficClear() {
		return EventsStates.trafficState == Event.TrafficClear;
	}

	public Event getWeatherState() {
		return weatherState;
	}

	public void setWeatherState(State state) {
		EventsStates.weatherState = (state == OFF) ? Event.WeatherClear : Event.WeatherRainy;
	}
	
	public boolean isWeatherClear() {
		return EventsStates.weatherState == Event.WeatherClear;
	}

	public Event getSlipperyRoadState() {
		return slipperyRoadState;
	}

	public void setSlipperyRoadState(State state) {
		EventsStates.slipperyRoadState = (state == OFF) ? Event.SlipperyRoadClear : Event.SlipperyRoad;
	}
	
	public boolean isSlipperyRoadClear() {
		return EventsStates.slipperyRoadState == Event.SlipperyRoadClear;
	}

	public Event getEmergencyTurboState() {
		return emergencyTurboState;
	}

	public void setEmergencyTurboState(State state) {
		EventsStates.emergencyTurboState = (state == OFF) ? Event.EmergencyTurboOff : Event.EmergencyTurbo;
	}
	
	public boolean isEmergencyTurboOn() {
		return EventsStates.emergencyTurboState == Event.EmergencyTurbo;
	}

	public Event getSpeedLimitState() {
		return speedLimitState;
	}

	public void setSpeedLimitState(State state) {
		EventsStates.speedLimitState = (state == OFF) ? Event.SpeedLimitSign : Event.SpeedLimitSignOff;
	}
	
	public boolean isSpeedLimitReached() {
		return EventsStates.speedLimitState == Event.SpeedLimitSign;
	}
	
}
