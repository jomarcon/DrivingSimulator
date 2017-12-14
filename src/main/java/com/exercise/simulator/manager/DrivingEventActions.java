package com.exercise.simulator.manager;

import com.exercise.simulator.model.Event;

public abstract class DrivingEventActions implements DrivingStrategy {
	
	public int getDesiredSpeed(Event event, int currentSpeed) {
		switch (event) {
			case Traffic:
				return getTrafficSpeed(currentSpeed);
			case TrafficClear:
				return getTrafficClearSpeed(currentSpeed);
			case WeatherRainy:
				return getWeatherRainySpeed(currentSpeed);
			case WeatherClear:
				return getWeatherClearSpeed(currentSpeed);
			case SlipperyRoad:
				return getSlipperyRoadSpeed(currentSpeed);
			case SlipperyRoadClear:
				return getSlipperyRoadClearSpeed(currentSpeed);
			case EmergencyTurbo:
				return getEmergencyTurboSpeed(currentSpeed);
			case SpeedLimitSign:
				return getSpeedLimitSignSpeed(currentSpeed);
			default:
				return currentSpeed;
		}
	}

	public abstract int getTrafficSpeed(int currentSpeed);

	public abstract int getTrafficClearSpeed(int currentSpeed);

	public int getWeatherRainySpeed(int currentSpeed) {
		return currentSpeed - 5;
	}

	public int getWeatherClearSpeed(int currentSpeed) {
		return currentSpeed + 5;
	}

	public int getSlipperyRoadSpeed(int currentSpeed) {
		return currentSpeed - 15;
	}

	public int getSlipperyRoadClearSpeed(int currentSpeed) {
		return currentSpeed + 15;
	}

	public abstract int getEmergencyTurboSpeed(int currentSpeed);

	public abstract int getSpeedLimitSignSpeed(int speed);

}
