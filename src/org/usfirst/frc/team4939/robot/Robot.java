/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4939.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4939.robot.commands.auto.*;
import org.usfirst.frc.team4939.robot.subsystems.*;

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
	public static final DigitalInput limitSwitch = new DigitalInput(1);
	public static OI m_oi;
	public static Compressor compressor;
	public String gameData;
	public char direction;
	
	Preferences pref;

	Command m_autonomousCommand;
	SendableChooser<Integer> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		CameraServer.getInstance().startAutomaticCapture();
		pref= Preferences.getInstance();
//		m_chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		
//		m_chooser.addDefault("Reach Baseline", new ReachBaseline());
//		m_chooser.addObject("Right Start", new RightStartAuto(direction));
//		m_chooser.addObject("Center Start", new CenterStartAuto(direction));
//		m_chooser.addObject("Left Start", new LeftStartAuto(direction));
		m_chooser.addDefault("Left Start Timed :(", 0);
		m_chooser.addObject("Right Start Timed :(", 1);
		m_chooser.addObject("Center Start Timed :(", 2);
		m_chooser.addObject("Turn Test :(", 3);
		m_chooser.addObject("Left Two Cube :(", 4);

		//SmartDashboard.putData("Auto modes", m_chooser);
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
		SmartDashboard.putData("Auto mode(s)", m_chooser);
		updateSmartDashboard();
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

	int automode = 0;
	@Override
	public void autonomousInit() {
		//while(gameData.length() < 3) {
			gameData = DriverStation.getInstance().getGameSpecificMessage();
		//}
		direction = gameData.charAt(0);
		Robot.dt.resetGyroYaw();
		automode = 0;
		automode = (int) m_chooser.getSelected();
		switch(automode){
			case 0:
				m_autonomousCommand = new TimedLeftAuto(direction);
				break;
			case 1:
				m_autonomousCommand = new TimedRighttAuto(direction);
				break;
			case 2:
				m_autonomousCommand = new TimedCenterAuto(direction);
				break;
			case 3:
				m_autonomousCommand = new TurnCommand(90, 1, 3);
				break;
			case 4:
				m_autonomousCommand = new TimedAutoLeftTwoCube(direction);

		}
//		m_autonomousCommand = new ReachBaseline();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		updateSmartDashboard();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		updateSmartDashboard();
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		updateSmartDashboard();
	}
	
	@Override
	public void robotPeriodic() {
		updateSmartDashboard();
	}
	
	public void updateSmartDashboard(){
		automode = m_chooser.getSelected();
		SmartDashboard.putBoolean("Limit Switch State", limitSwitch.get());
		SmartDashboard.putNumber("angle", Robot.dt.getGyroYaw());
		SmartDashboard.putNumber("autoNum", automode);
	
	//	SmartDashboard.putString("GameData", gameData);
		NumberConstants.pGyro = pref.getDouble("pGyro", 0.0);
		NumberConstants.iGyro = pref.getDouble("iGyro", 0.0);
		NumberConstants.dGyro = pref.getDouble("dGyro", 0.0);
		
		NumberConstants.pDrive = pref.getDouble("pDrive", 0.0);
		NumberConstants.iDrive = pref.getDouble("iDrive", 0.0);
		NumberConstants.dDrive = pref.getDouble("dDrive", 0.0);
		
		Robot.dt.updatePID();
	}
}
