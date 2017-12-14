package com.exercise.simulator.manager;

import org.junit.Assert;
import org.junit.Test;

import com.exercise.simulator.model.Mode;


public class DrivingAdvisorTest {

	@Test
	public final void testGetDesiredSpeedForSportDriving() {
		DrivingAdvisor advisor = createDriverAdvisor(Mode.SPORT);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(1);
		Assert.assertEquals(15, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(2);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(3);
		Assert.assertEquals(15, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(4);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(5);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(6);
		Assert.assertEquals(35, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(7);
		Assert.assertEquals(65, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(50);
		Assert.assertEquals(55, advisor.getCurrentSpeed());
	}
	
	@Test
	public final void testGetDesiredSpeedForNormalDriving() {
		DrivingAdvisor advisor = createDriverAdvisor(Mode.NORMAL);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(1);
		Assert.assertEquals(10, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(2);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(3);
		Assert.assertEquals(15, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(4);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(5);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(6);
		Assert.assertEquals(35, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(7);
		Assert.assertEquals(55, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(50);
		Assert.assertEquals(50, advisor.getCurrentSpeed());
	}
	
	@Test
	public final void testGetDesiredSpeedForSafeDriving() {
		DrivingAdvisor advisor = createDriverAdvisor(Mode.SAFE);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(1);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(2);
		Assert.assertEquals(35, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(3);
		Assert.assertEquals(30, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(4);
		Assert.assertEquals(35, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(5);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(6);
		Assert.assertEquals(35, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(7);
		Assert.assertEquals(45, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(50);
		Assert.assertEquals(45, advisor.getCurrentSpeed());
	}
	
	@Test
	public final void testTrafficClearForNormalDriving() {
		DrivingAdvisor advisor = createDriverAdvisor(Mode.NORMAL);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(2);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(2);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(1);
		Assert.assertEquals(10, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(2);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
	}
	
	@Test
	public final void testTrafficClearForSportDriving() {
		DrivingAdvisor advisor = createDriverAdvisor(Mode.SPORT);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(2);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(2);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(1);
		Assert.assertEquals(15, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(2);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
	}
	
	@Test
	public final void testTrafficClearForSafeDriving() {
		DrivingAdvisor advisor = createDriverAdvisor(Mode.SAFE);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(2);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(2);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(1);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(2);
		Assert.assertEquals(35, advisor.getCurrentSpeed());
	}
	
	@Test
	public final void testWeatherClearForSafeDriving() {
		DrivingAdvisor advisor = createDriverAdvisor(Mode.SAFE);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(4);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(4);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(3);
		Assert.assertEquals(15, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(4);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
	}
	
	@Test
	public final void testSlipperyRoadClearForSafeDriving() {
		DrivingAdvisor advisor = createDriverAdvisor(Mode.SAFE);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(6);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(6);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(5);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(6);
		Assert.assertEquals(35, advisor.getCurrentSpeed());
	}
	
	@Test
	public final void testEmergencyTurboIfSlipperyRoadForSafeDriving() {
		DrivingAdvisor advisor = createDriverAdvisor(Mode.SAFE);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(40);
		Assert.assertEquals(35, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(5);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(7);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(6);
		Assert.assertEquals(35, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(7);
		Assert.assertEquals(45, advisor.getCurrentSpeed());
	}
	
	@Test
	public final void testEmergencyTurboOnlyOnceForSafeDriving() {
		DrivingAdvisor advisor = createDriverAdvisor(Mode.SAFE);
		Assert.assertEquals(20, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(40);
		Assert.assertEquals(35, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(7);
		Assert.assertEquals(45, advisor.getCurrentSpeed());
		
		advisor.getDesiredSpeed(7);
		Assert.assertEquals(45, advisor.getCurrentSpeed());
	}
	
	private DrivingAdvisor createDriverAdvisor(Mode mode) {
		return new DrivingAdvisor(mode);
	}

}
