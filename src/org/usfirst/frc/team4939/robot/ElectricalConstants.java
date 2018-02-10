package org.usfirst.frc.team4939.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class ElectricalConstants {
	//***************************************************************************
	//****************************** DRIVE MOTORS *******************************
	//***************************************************************************     
	
	public static final int LEFT_DRIVE_FRONT                                = 10;
	public static final int LEFT_DRIVE_BACK                                 = 11;
	
	public static final int RIGHT_DRIVE_FRONT                               = 2;
	public static final int RIGHT_DRIVE_BACK                                = 1;
	
	//***************************************************************************
	//****************************** DRIVE ENCODERS *****************************
	//***************************************************************************
	
	public static final int LEFT_DRIVE_ENCODER_A                            = 9;
	public static final int LEFT_DRIVE_ENCODER_B                            = 8;
	
	public static final int RIGHT_DRIVE_ENCODER_A                           = 1;
	public static final int RIGHT_DRIVE_ENCODER_B                           = 0;

	//***************************************************************************
	//***************************** OPTICAL SENSORS *****************************
	//***************************************************************************

	public static final int SHOOTER_OPTICS									= 5;
	public static final int POPPER_OPTICS									= 4;
	
	//***************************************************************************
	//****************************** ANALOG SENSORS *****************************
	//***************************************************************************
	
	public static final int ARM_POTENTIOMETER								= 0;
	
	//***************************************************************************
	//******************************** PNEUMATICS *******************************
	//***************************************************************************

	public static final int PCM												= 12;

	public static final int POPPER_SHOOT_SOLENOID_A							= 6;
	public static final int POPPER_SHOOT_SOLENOID_B							= 1;
//	public static final int POPPER_SHOOT_SOLENOID_A							= 6;
//	public static final int POPPER_SHOOT_SOLENOID_B							= 4;
	
	public static final int POPPER_HOLD_SOLENOID_A							= 5;
	public static final int POPPER_HOLD_SOLENOID_B							= 2;
	
	public static final int SHOOTER_HOOD_SOLENOID_A							= 3;
	public static final int SHOOTER_HOOD_SOLENOID_B							= 4;
	
	//4 and 1 and 0 broken

	//***************************************************************************
	//************************* DRIVE ENCODER CONSTANTS *************************
	//***************************************************************************
	public static final int driveWheelRadius = 4;//wheel radius in inches
	public static final int drivePulsePerRotation = 128; //encoder pulse per rotation
	public static final double driveGearRatio = 1/1; //ratio between wheel and encoder
	public static final double driveEncoderPulsePerRot = drivePulsePerRotation*driveGearRatio; //pulse per rotation * gear ratio
	public static final double driveEncoderDistPerTick =(Math.PI*2*driveWheelRadius)/driveEncoderPulsePerRot;
	public static final boolean leftDriveTrainEncoderReverse = false;
	public static final boolean rightDriveTrainEncoderReverse = false;

