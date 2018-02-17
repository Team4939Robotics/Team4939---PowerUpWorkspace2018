package org.usfirst.frc.team4939.robot.subsystems;

import org.usfirst.frc.team4939.robot.RobotMap;
import org.usfirst.frc.team4939.robot.NumberConstants;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;


public class UltrasonicSubsystem extends Subsystem{

    public static Ultrasonic ultrasonicFront = new Ultrasonic(RobotMap.frontUltrasonicTrig, RobotMap.frontUltrasonicEcho);
    /**
     * @return Distance to the target, in inches
     */
    public double getDistance() {
    	return ultrasonicFront.getRangeInches() - NumberConstants.ultrasonicDepth;
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
