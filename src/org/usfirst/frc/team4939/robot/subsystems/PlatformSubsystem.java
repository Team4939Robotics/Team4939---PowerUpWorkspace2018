package org.usfirst.frc.team4939.robot.subsystems;

import org.usfirst.frc.team4939.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PlatformSubsystem extends Subsystem{

	public DoubleSolenoid platformLiftingPiston = new DoubleSolenoid(RobotMap.LeftPlatformPiston, RobotMap.RightPlatformPiston);
	public boolean platformUP = false;
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	public void dropPlatform ()
	{
		this.platformLiftingPiston.set(DoubleSolenoid.Value.kForward);
		this.platformUP = false;
	}
	
	public void liftPlatform()
	{
		this.platformLiftingPiston.set(DoubleSolenoid.Value.kReverse);
		this.platformUP = true;
	}
	
}
