package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DoNothingAuto extends Command {

	public DoNothingAuto()
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
		Robot.dt.runleftsidedrive(0);
		Robot.dt.runrightsidedrive(0);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.dt.stop();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
    cancel();
	}

}
