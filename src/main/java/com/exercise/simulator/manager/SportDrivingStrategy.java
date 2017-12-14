package com.exercise.simulator.manager;

public class SportDrivingStrategy extends DrivingEventActions implements DrivingStrategy {

	@Override
	public int getTrafficSpeed(int currentSpeed) {
		return currentSpeed - 5;
	}

	@Override
	public int getTrafficClearSpeed(int currentSpeed) {
		return currentSpeed + 5;
	}

	@Override
	public int getEmergencyTurboSpeed(int currentSpeed) {
		return currentSpeed + 30;
	}

	@Override
	public int getSpeedLimitSignSpeed(int speed) {
		return speed + 5;
	}

}
