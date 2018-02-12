/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4939.robot;

import org.usfirst.frc.team4939.robot.subsystems.*;
import org.usfirst.frc.team4939.robot.commands.auto.*;
import org.usfirst.frc.team4939.robot.Camera;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
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
	public static final UltrasonicSubsystem ultrasonic = new UltrasonicSubsystem();
	public static OI oi;
	public static Compressor compressor; 
	public static CameraServer server;
	Camera camera = new Camera();
	Command autonomousCommand;
	public static double ultrasonicDistance;
	public PowerDistributionPanel pdp;
	
	//CameraServer server;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		compressor = new Compressor (0);
		compressor.start();
        pdp = new PowerDistributionPanel();
		dt.resetGyro();
		dt.resetGyroYaw();
		dt.calibrate_gyro();
		 SmartDashboard.putNumber("gyro yaw", Robot.dt.getGyroYaw());

		// Camera Server
		CameraServer.getInstance().startAutomaticCapture();
       // server.setQuality(50);
        //server.startAutomaticCapture("cam0");
		
		new Thread(() -> {
            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
            camera.setResolution(640, 480);
            
            CvSink cvSink = CameraServer.getInstance().getVideo();
            CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
            
            Mat source = new Mat();
            Mat output = new Mat();
            
            while(!Thread.interrupted()) {
                cvSink.grabFrame(source);
                Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
                outputStream.putFrame(output);
            }
        }).start();

		///////////////////////////////////////////////////////////////////////////////////
		
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		chooser.addObject("Reach Baseline", new ReachBaseline());
		chooser.addObject("Do Nothing Auto", new DoNothingAuto());
		chooser.addObject("LeftSwitch", new LeftSwitch());
		chooser.addObject("RightSwitch", new RightSwitch());
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
	       SmartDashboard.putNumber("angle", Robot.dt.angle());
	        SmartDashboard.putNumber("rate", Robot.dt.rate());
	        SmartDashboard.putNumber("gyro yaw", Robot.dt.getGyroYaw());
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
		autonomousCommand = chooser.getSelected();
		dt.resetGyroYaw();
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
		SmartDashboard.putNumber("angle", Robot.dt.angle());
        SmartDashboard.putNumber("rate", Robot.dt.rate());
        SmartDashboard.putNumber("gyro yaw", Robot.dt.getGyroYaw());
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		camera.control();
        compressor.start();
        
        SmartDashboard.putNumber("angle", Robot.dt.angle());
        SmartDashboard.putNumber("rate", Robot.dt.rate());
        
        SmartDashboard.putNumber("gyro yaw", Robot.dt.getGyroYaw());
        
        SmartDashboard.putNumber("Left Current", DriveSubsystem.getLeftCurrent());
        SmartDashboard.putNumber("Right Current", DriveSubsystem.getRightCurrent());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
