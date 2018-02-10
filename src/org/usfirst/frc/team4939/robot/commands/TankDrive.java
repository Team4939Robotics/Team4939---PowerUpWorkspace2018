package org.usfirst.frc.team4939.robot.commands;

import org.usfirst.frc.team4939.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TankDrive extends CommandGroup {

	/** The Constant DELTA_LIMIT. */
	private static final double DELTA_LIMIT = 0.75;
	
	/** The Constant RAMP_UP_CONSTANT. */
	private static final double RAMP_UP_CONSTANT = 0.05;
	
	/** The Constant RAMP_DOWN_CONSTANT. */
	private static final double RAMP_DOWN_CONSTANT = 0.05;
	
	/** Variables used for joystick ramping*/
	double deltaL = 0;
	double deltaR = 0;
	double prevInputL = 0;
	double inputL = 0;
	double prevInputR = 0;
	double inputR = 0;
	
	public TankDrive()
	{
		requires(Robot.dt);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		inputL = Robot.oi.left()*-1;
		inputR = Robot.oi.right();
		deltaL = inputL - prevInputL;
		deltaR = inputR - prevInputR;
		
		if(deltaL >= DELTA_LIMIT)
			inputL += RAMP_UP_CONSTANT;
		else if(deltaL <= -DELTA_LIMIT)
			inputL -= RAMP_DOWN_CONSTANT;
		
		if(deltaR >= DELTA_LIMIT)
			inputR += RAMP_UP_CONSTANT;
		else if(deltaR <= -DELTA_LIMIT)
			inputR -= RAMP_DOWN_CONSTANT;
		
		
//		if (Robot.oi.reversedirection())
//		{
//	Robot.dt.runleftsidedrive(inputR);
//	Robot.dt.runrightsidedrive(inputL);
//		}
		
		Robot.dt.runleftsidedrive(inputL);
		Robot.dt.runrightsidedrive(inputR);
		
		prevInputL = inputL;
		prevInputR = inputR;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}
}
