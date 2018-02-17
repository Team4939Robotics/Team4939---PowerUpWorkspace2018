package org.usfirst.frc.team4939.robot.subsystems;

import org.usfirst.frc.team4939.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbSubsystem extends Subsystem {
	public static Spark climbMotor1 = new Spark(RobotMap.climbMotor1);
	public static Spark climbMotor2 = new Spark(RobotMap.climbMotor2);
	
	public Solenoid lockMech = new Solenoid(RobotMap.lockPiston);
	public boolean climberLocked = false;
	
	public void useClimber(double speed) {
		climbMotor1.set(speed);
		climbMotor2.set(speed);
	}
	
	public void lockClimber() {
		this.lockMech.set(true);
		this.climberLocked = true;
	}
	
	public void unlockClimber() {
		this.lockMech.set(false);
		this.climberLocked = false;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

