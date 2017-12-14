package com.exercise.simulator.manager;

import com.exercise.simulator.model.Event;
import com.exercise.simulator.model.EventsStates;
import com.exercise.simulator.model.Mode;
import com.exercise.simulator.model.State;

public class DrivingAdvisor {
	
	private static final int INITIAL_SPEED = 20;
	private int currentSpeed;
	private Mode mode;
	private EventsStates eventsStates = new EventsStates();
	
	public DrivingAdvisor() {
		setCurrentSpeed(INITIAL_SPEED);
		setMode(Mode.NORMAL);
		printInitialMessage();
	}
	
	public DrivingAdvisor(int initialSpeed) {
		setCurrentSpeed(initialSpeed);
		setMode(Mode.NORMAL);
		printInitialMessage();
	}
	
	public DrivingAdvisor(Mode mode) {
		setCurrentSpeed(INITIAL_SPEED);
		setMode(mode);
		printInitialMessage();
	}
	
	public DrivingAdvisor(Mode mode, int initialSpeed) {
		setCurrentSpeed(initialSpeed);
		setMode(mode);
		printInitialMessage();
	}
	
	public void getDesiredSpeed(int eventNo) {
		
		Event newEvent = Event.valueOf(eventNo);
		
		if (isEventNumberValid(eventNo) && eventsStates.isNewEventValid(newEvent)) {
			
			switch (getMode()) {
				case NORMAL:
					int normalSpeed = getDesiredSpeed(new NormalDrivingStrategy(), newEvent, eventNo);
					if ( !isBelowMinimumSpeed(normalSpeed)) {
						printMessage(this.currentSpeed = normalSpeed);
					} else {
						printMessage("Invalid");
					}
					break;
				case SPORT:
					int sportSpeed = getDesiredSpeed(new SportDrivingStrategy(), newEvent, eventNo);
					if ( !isBelowMinimumSpeed(sportSpeed)) {
						printMessage(this.currentSpeed = sportSpeed);
					} else {
						printMessage("Invalid");
					}
					break;
				case SAFE:
					int safeSpeed = getDesiredSpeed(new SafeDrivingStrategy(), newEvent, eventNo);
					if ( !isBelowMinimumSpeed(safeSpeed)) {
						printMessage(this.currentSpeed = safeSpeed);
					} else {
						printMessage("Invalid");
					}
					break;
				default:
					printMessage(0);
					break;
			}
			
			eventsStates.setState(newEvent);
		} else {
			System.out.println("Invalid");
		}	
	}
	
	private boolean isEventNumberValid(int eventNo) {
		if ( 1 <= eventNo && eventNo <= 7) {
			return true;
		} else if ( isSpeedLimitNumber(eventNo) ) {
			eventsStates.setSpeedLimitState(State.ON);
			return true;
		} else if ( 100 < eventNo ) {
			return false;
		}
		return false;
	}
	
	private boolean isSpeedLimitNumber(int eventNo) {
		return 10 <= eventNo && eventNo <= 100;
	}
	
	private boolean isBelowMinimumSpeed(int newSpeed) {
		return newSpeed < 10;
	}
	
	public int getDesiredSpeed(DrivingStrategy drivingMode, Event event, int currentSpeed) {
		if ( isSpeedLimitNumber(currentSpeed)) {
			return drivingMode.getDesiredSpeed(event, currentSpeed);
		} else {
			return drivingMode.getDesiredSpeed(event, getCurrentSpeed());
		}
	}
	
	private void printInitialMessage() {
		System.out.println("Welcome. Driving mode is " + this.mode.toString());
		System.out.println(this.currentSpeed);
	}
	
	private void printMessage(String message) {
		System.out.println(message);
	}
	
	private void printMessage(int message) {
		System.out.println(message);
	}
	
	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}
}
