package com.exercise.simulator;

import java.util.Scanner;

import com.exercise.simulator.manager.DrivingAdvisor;
import com.exercise.simulator.model.Mode;

public class AutonomousDriving 
{
    public static void main( String[] args )
    {
        System.out.print( "Enter Driving Mode: " );
        
        Scanner scanner = new Scanner(System.in);
        
        String mode = scanner.nextLine();
        
        DrivingAdvisor advisor = new DrivingAdvisor(Mode.valueOf(mode));
        
        do
        {
        	System.out.print("Enter Event: ");
        	int event = scanner.nextInt();
        	advisor.getDesiredSpeed(event);
        }
        while (true);
    }
}
