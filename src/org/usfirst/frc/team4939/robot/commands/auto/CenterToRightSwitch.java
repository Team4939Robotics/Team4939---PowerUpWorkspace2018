package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterToRightSwitch extends CommandGroup {

    public CenterToRightSwitch() {
    	addSequential(new PlatformDown());
    	addSequential(new PauseCommand(1));
    	
    	//addSequential(new DriveCommand(36, 0.5, 0, 1));
    	addSequential(new DriveCommand(0.67, 0.67, 0.38));
        addSequential(new TurnCommand(90, 0.5, 1));
        //addSequential(new DriveCommand(54, 0.5, 0, 2));
    	addSequential(new DriveCommand(0.67, 0.67, 0.56));
        addSequential(new TurnCommand(-90, 0.5, 1));
        
        addParallel(new PlatformUp());
        //addSequential(new DriveCommand(104, 0.5, 0, 2.5));
        addSequential(new DriveCommand(0.67, 0.67, 1.08));
        addParallel(new BoxOuttake());
        addSequential(new PauseCommand(1));
        
        addSequential(new BoxStopIntake());
        //addSequential(new DriveCommand(-20, 0.5, 0, 2.5));
        addSequential(new DriveCommand(0.67, 0.67, 0.2));
        addSequential(new PlatformDown());
    }
}
