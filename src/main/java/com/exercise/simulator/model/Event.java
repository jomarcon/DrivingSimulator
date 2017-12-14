package com.exercise.simulator.model;

public enum Event {
	
	Traffic(1, "Traffic"),
	TrafficClear(2, "Traffic Clear"),
	WeatherRainy(3, "Weather Rainy"),
	WeatherClear(4, "Weather Clear"),
	SlipperyRoad(5, "Slippery Road"),
	SlipperyRoadClear(6, "Slippery Road Clear"),
	EmergencyTurbo(7, "Emergency Turbo"),
	EmergencyTurboOff,
	SpeedLimitSign(10, "Speed Limit Sign X"),
	SpeedLimitSignOff;
	
	Integer id;
	String description;
	
	Event()
	{
		
	}
	
	Event(int id, String description)
	{
		this.id = id;
		this.description = description;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public static Event valueOf(int value) {
	
		if (value == Event.Traffic.getId()) 
			return Event.Traffic;
		else if (value == Event.TrafficClear.getId())
			return Event.TrafficClear;
		else if (value == Event.WeatherRainy.getId())
			return Event.WeatherRainy;
		else if (value == Event.WeatherClear.getId())
			return Event.WeatherClear;
		else if (value == Event.SlipperyRoad.getId())
			return Event.SlipperyRoad;
		else if (value == Event.SlipperyRoadClear.getId())
			return Event.SlipperyRoadClear;
		else if (value == Event.EmergencyTurbo.getId())
			return Event.EmergencyTurbo;
		else if (value >= 10)
			return Event.SpeedLimitSign;
		else 
			return null;
		
	}

	 
}
