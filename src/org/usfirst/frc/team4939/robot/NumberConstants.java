package org.usfirst.frc.team4939.robot;

/**
 *
 */
public class NumberConstants {
	//**************************************************************************
  //*************************** PID VALUES (DRIVE) ***************************
  //**************************************************************************
	
	//Competition
	public static double pDrive 									 = 0.05;	
	public static double iDrive 									 = 0.00;
	public static double dDrive 									 = 0.008;
	
	public static final double Drive_Scale 								 = 0.6;

	//**************************************************************************
    //**************************** PID VALUES (GYRO) ***************************
    //**************************************************************************
	
	//Competition
	public static double pGyro 									 = 0.006;
	public static double iGyro 									 = 0.0;
	public static double dGyro 									 = 0.00001;
	
	//**************************************************************************
    //*************************** PID VALUES (CAMERA) **************************
    //****
	//Competition
	public static final double pCamera 									 = 0.07;
	public static final double iCamera 									 = 0.00;
	public static final double dCamera 									 = 0.000;
		
	public static final double cameraOffset								= 2.5;
	
	
	
	//******MISC******
	public static final double ultrasonicDepth = 5; //Distance between ultrasonic and front edge of bumper
	
}
		
	