/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4939.robot;

import org.usfirst.frc.team4939.robot.subsystems.*;
import org.usfirst.frc.team4939.robot.commands.auto.*;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	public static final DriveSubsystem dt = new DriveSubsystem();
	public static final PlatformSubsystem platform = new PlatformSubsystem();
	public static final IntakeSubsystem intake = new IntakeSubsystem();
	//public static final UltrasonicSubsystem ultrasonic = new UltrasonicSubsystem();
	//public static final ClimbSubsystem climber = new ClimbSubsystem();
	//public static final AutoChooserSubsystem auto = new AutoChooserSubsystem();
	public static OI oi;
	public static Compressor compressor;
	public static double ultrasonicDistance;
	public PowerDistributionPanel pdp;
	public static String gameData;
	public static char startPosition;
	public static char autoChoice;
	
	//CameraServer server;
	public static Command autonomousCommand;
	SendableChooser positionChooser = new SendableChooser();
	SendableChooser<Command> testAutoChooser = new SendableChooser<>();
	SendableChooser leftAutoChooser = new SendableChooser();
	SendableChooser centerAutoChooser = new SendableChooser();
	SendableChooser rightAutoChooser = new SendableChooser();
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		compressor = new Compressor (0);
	//	compressor.start();
        pdp = new PowerDistributionPanel();
	//	resetgyro();
		calibratesensors();
	//	Camera
//		CameraServer server = CameraServer.getInstance();
//		server.setQuality(50);
//		server.startAutomaticCapture("cam0");
		CameraServer.getInstance().startAutomaticCapture();
	updateSmartdashboard();
	

		

		///////////////////////////////////////////////////////////////////////////////////
		
		// chooser.addObject("My Auto", new MyAutoCommand());
		
		// You want to go to closest Switch based on start position. Could create a new parameter or new auto mode
		
		positionChooser.addDefault("Start on Left", 'L');
		positionChooser.addObject("Start on Right", 'R');
		positionChooser.addObject("Start in Center", 'C');
		SmartDashboard.putData("Starting Position", positionChooser);
		
		leftAutoChooser.addDefault("Do nothing", 'N');
		leftAutoChooser.addObject("Vault", 'V');
		leftAutoChooser.addObject("Reach Baseline", 'B');
		SmartDashboard.putData("Left Auto Choices", leftAutoChooser);
		
		rightAutoChooser.addDefault("Do nothing", 'N');
		rightAutoChooser.addObject("Vault", 'V');
		rightAutoChooser.addObject("Reach Baseline", 'B');
		SmartDashboard.putData("Right Auto Choices", rightAutoChooser);
		
		centerAutoChooser.addDefault("Do nothing", 'N');
		centerAutoChooser.addObject("Left Switch", 'L');
		centerAutoChooser.addObject("Right Switch", 'R');
		centerAutoChooser.addObject("Right Baseline", 'A');
		centerAutoChooser.addObject("Left Baseline", 'B');
		centerAutoChooser.addObject("Vault", 'V');
		SmartDashboard.putData("Center Auto Choices", centerAutoChooser);
		
		testAutoChooser.addDefault("Do nothing", new DoNothingAuto());
		testAutoChooser.addObject("Straight to Switch", new StraightToSwitch());
		testAutoChooser.addObject("Left Around Switch", new LeftAroundSwitch());
		testAutoChooser.addObject("Right Around Switch", new RightAroundSwitch());
		testAutoChooser.addObject("Center to Left Switch", new CenterToLeftSwitch());
		testAutoChooser.addObject("Center to Right Switch", new CenterToRightSwitch());
		SmartDashboard.putData("Auto Choice", testAutoChooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		compressor.stop();
	    updateSmartdashboard();
	    
	    
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		/*
		startPosition = (char) positionChooser.getSelected();
		if (startPosition == 'L'){
			autoChoice = (char) leftAutoChooser.getSelected();
		}
		else if (startPosition == 'R'){
			autoChoice = (char) rightAutoChooser.getSelected();
		}
		else if (startPosition == 'C'){
			autoChoice = (char) centerAutoChooser.getSelected();
		}
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		auto.selectAuto();
		auto.launchAuto();
		*/
		autonomousCommand = (Command) testAutoChooser.getSelected();
		resetgyro();
		//Robot.dt.resetEncoders();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		
		  if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		updateSmartdashboard();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		
		if(autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
        startCompressor();
        updateSmartdashboard();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	public void updateSmartdashboard(){
		SmartDashboard.putNumber("angle", Robot.dt.angle());
        SmartDashboard.putNumber("rate", Robot.dt.rate());
        SmartDashboard.putNumber("gyro yaw", Robot.dt.getGyroYaw());
        
        SmartDashboard.putNumber("Left Current", DriveSubsystem.getLeftCurrent());
        SmartDashboard.putNumber("Right Current", DriveSubsystem.getRightCurrent());
        
        /*
        SmartDashboard.putNumber("Left enc value", Robot.dt.getLeftEncoderDist());
        SmartDashboard.putNumber("Right enc value", Robot.dt.getRightEncoderDist());
        SmartDashboard.putNumber("Average enc value", Robot.dt.getAverageDistance());
        */
        
        SmartDashboard.putBoolean("Pressure Low?", Robot.compressor.getPressureSwitchValue());
        
   //     SmartDashboard.putString("Switch positions", gameData);
        
        //SmartDashboard.putNumber("Ultrasonic Distance", Robot.ultrasonic.getDistance());
	}
	
	public void calibratesensors(){
		Robot.dt.calibrate_gyro();
	}
	
	public void resetgyro(){
		Robot.dt.resetGyroYaw();
		Robot.dt.resetGyro();
	}
	
	public void startCompressor(){
		compressor.start();
	}
	
	public void stopCompressor(){
		compressor.stop();
	}
	
}
