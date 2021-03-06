package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PauseCommand extends Command {
	private double time;

    public PauseCommand(double time) {
        this.time = time;
        requires(Robot.dt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.dt.pause(time);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
