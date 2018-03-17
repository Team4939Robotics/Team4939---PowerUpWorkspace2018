package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.Robot;
import org.usfirst.frc.team4939.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TimedRighttAuto extends CommandGroup {

    public TimedRighttAuto(char direction) {
    	Robot.dt.resetGyroYaw();
    	addSequential(new DriveCommand(0.50, 0.50, 0.25));
    	addSequential(new PauseCommand(1));
    	addSequential(new PlatformDown());
    	//jerk forward
    	
    	addSequential(new DriveCommand (0.37, 0.35, 1.5));
        //addSequential(new DriveCommand(140, 0.5, 0 , 2.5));
    	addSequential(new PauseCommand (1));
    	//drive forward
    	
    	if(direction == 'R'){
    		addSequential (new BoxClose()); // reversed
    	addSequential(new AutoBoxOuttake());
        addSequential(new PauseCommand(1));
        addSequential(new BoxStopIntake());
        //release box
        
        addSequential(new DriveCommand (-0.35, -0.35, 0.6));
        addSequential(new PlatformUp());
        //back up and bring platform down
    	}
    }
}
