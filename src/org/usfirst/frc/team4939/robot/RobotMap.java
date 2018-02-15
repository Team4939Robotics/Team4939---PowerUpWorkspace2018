/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4939.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	 // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	//CAN 
		public static final int leftDriveFront = 3;
		public static final int leftDriveBack = 1;
		public static final int rightDriveBack = 2;
		public static final int rightDriveFront = 4;
		
		public static final int leftArmIntake = 7;
		public static final int rightArmIntake = 8;
		
		public static final int CIMTop = 5;
		public static final int CIMBottom = 6;
		
		public static final int climbMotor = 9;
		
	// Solenoids 
		public static final int LeftPlatformPiston = 0;
		public static final int RightPlatformPiston = 1;
		
		public static final int leftIntakePiston = 2;
		public static final int rightIntakePiston = 3;
		
		public static final int lockPiston = 4;
		
	//PWM
		public static final int intake775 = 0;
//		public static final int lights = 1;
		
	// SPI Gyro
		public static final int gyro = 0;
		
	// DIO 
		public static final int frontUltrasonicEcho = 1;
		public static final int frontUltrasonicTrig = 1;
		
		
}
