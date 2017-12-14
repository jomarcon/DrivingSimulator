package com.exercise.simulator.manager;

public class SafeDrivingStrategy extends DrivingEventActions implements DrivingStrategy {

	@Override
	public int getTrafficSpeed(int currentSpeed) {
		return currentSpeed - 15;
	}

	@Override
	public int getTrafficClearSpeed(int currentSpeed) {
		return currentSpeed + 15;
	}

	@Override
	public int getEmergencyTurboSpeed(int currentSpeed) {
		return currentSpeed + 10;
	}

	@Override
	public int getSpeedLimitSignSpeed(int speed) {
		return speed - 5;
	}

}
