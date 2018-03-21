package org.usfirst.frc.team4939.robot.subsystems;

import org.usfirst.frc.team4939.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class ClimbSubsystem extends Subsystem {
	public static WPI_TalonSRX climbMotor1 = new WPI_TalonSRX(RobotMap.climbMotor1);
	public static WPI_TalonSRX climbMotor2 = new WPI_TalonSRX(RobotMap.climbMotor2);
	
	public void useClimber(double speed) {
		climbMotor1.set(speed);
		climbMotor2.set(speed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}