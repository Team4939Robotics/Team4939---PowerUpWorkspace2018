package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftAroundSwitch extends CommandGroup {

    public LeftAroundSwitch() {
    	addParallel(new PlatformDown());
    	addSequential(new DriveCommand(0.5, 0.5, 0.4));
    	addSequential(new TurnCommand(-32, 0.5, 1));
    	addSequential(new DriveCommand(0.5, 0.5, 0.97));
    	addSequential(new TurnCommand(32, 0.5, 1));
    	addSequential(new DriveCommand(0.5, 0.5, 1.6));
    	
    	
    }
}
