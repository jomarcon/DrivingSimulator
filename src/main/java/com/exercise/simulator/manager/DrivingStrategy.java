package com.exercise.simulator.manager;

import com.exercise.simulator.model.Event;

public interface DrivingStrategy {
	int getDesiredSpeed(Event event, int currentSpeed);
}
