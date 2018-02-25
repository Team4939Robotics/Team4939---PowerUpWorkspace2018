package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StraightToSwitch extends CommandGroup {

    public StraightToSwitch() {
    addSequential(new DriveCommand(0.50, 0.50, 0.25));
    	addSequential(new PauseCommand(1));
    	addSequential(new PlatformDown());
    	addSequential(new DriveCommand (0.35, 0.30, 1.4));
        //addSequential(new DriveCommand(140, 0.5, 0 , 2.5));
    	addSequential(new PauseCommand (1));
    	addSequential (new BoxClose());
    	addSequential(new AutoBoxOuttake());
        addSequential(new PauseCommand(1));
        addSequential(new BoxStopIntake());
        addSequential(new DriveCommand (-0.35, -0.35, 1.25));
        addSequential(new PlatformUp());
        //addSequential(new DriveCommand(-15, 0.5, 0, 2.5));
    //(new DriveCommand(-0.67, -0.67, 0.2));
     //   addSequential(new PlatformDown());
    }
}
