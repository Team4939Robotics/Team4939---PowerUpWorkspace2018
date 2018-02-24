package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StraightToSwitch extends CommandGroup {

    public StraightToSwitch() {
    	addSequential(new PlatformDown());
    	addSequential(new PauseCommand(1));
    	addParallel(new PlatformUp());
    	
        //addSequential(new DriveCommand(140, 0.5, 0 , 2.5));
    	addSequential(new DriveCommand(0.5, 0.5, 1.45));
        addSequential(new BoxOuttake());
        addSequential(new PauseCommand(1));
        addParallel(new BoxStopIntake());
        //addSequential(new DriveCommand(-15, 0.5, 0, 2.5));
        addSequential(new DriveCommand(-0.5, -0.5, 0.2));
        addSequential(new PlatformDown());
    }
}
