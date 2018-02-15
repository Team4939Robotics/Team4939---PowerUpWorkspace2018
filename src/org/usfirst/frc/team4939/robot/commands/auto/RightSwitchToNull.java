package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.Robot;
import org.usfirst.frc.team4939.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSwitchToNull extends CommandGroup {

    public RightSwitchToNull() {

    	addSequential(new DriveCommand(168, 0.5, 0, 2.5));
    	addSequential(new TurnCommand(-90, 0.5, 2.5));
    	
    	//addSequential(new GetUltrasonicDistance());
    	addSequential(new DriveCommand(10, 0.5, 0, 2.5));
    	addSequential(new BoxOuttake());
    	addSequential(new DriveCommand(-10, 0.5, 0, 2.5));
    	addParallel(new BoxStopIntake());
    	
    	addSequential(new TurnCommand(90, 0.5, 2.5));
    	addSequential(new DriveCommand(132, 0.5, 0, 2.5));
    	
    }
}