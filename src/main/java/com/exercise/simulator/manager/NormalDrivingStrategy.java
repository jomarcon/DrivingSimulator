package com.exercise.simulator.manager;

import com.exercise.simulator.model.Event;

public class NormalDrivingStrategy extends DrivingEventActions implements DrivingStrategy {
	
	@Override
	public int getTrafficSpeed(int currentSpeed) {
		return currentSpeed - 10;
	}

	@Override
	public int getTrafficClearSpeed(int currentSpeed) {
		return currentSpeed + 10;
	}

	@Override
	public int getEmergencyTurboSpeed(int currentSpeed) {
		return currentSpeed + 20;
	}

	@Override
	public int getSpeedLimitSignSpeed(int speed) {
		return speed;
	}
}
