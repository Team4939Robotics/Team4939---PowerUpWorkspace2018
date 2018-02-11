package org.usfirst.frc.team4939.robot.subsystems;

import org.usfirst.frc.team4939.robot.RobotMap;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;


public class UltrasonicSubsystem extends Subsystem{

    public static Ultrasonic ultrasonicFront = new Ultrasonic(RobotMap.frontUltrasonicEcho, RobotMap.frontUltrasonicTrig);
    /**
     * @return Distance to the target, in feet
     */
    public double getDistance() {
    	return ultrasonicFront.getRangeInches();
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
