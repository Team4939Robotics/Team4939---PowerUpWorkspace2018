package org.usfirst.frc.team4939.robot.commands;

import org.usfirst.frc.team4939.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BoxOuttake extends Command {

    public BoxOuttake() {
        requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

 // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!Robot.limitSwitch.get()){
    		Robot.intake.useIntake(0);
    	}
    	else {
    		Robot.intake.useIntake(0.85);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.limitSwitch.get() != true;
    	//return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.useIntake(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//    	Robot.intake.useIntake(0);
    	cancel();
    }
}