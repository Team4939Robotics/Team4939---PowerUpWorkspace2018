package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightAroundSwitch extends CommandGroup {

    public RightAroundSwitch() {
    	addParallel(new PlatformDown());
    	addSequential(new DriveCommand(0.67, 0.67, 0.4));
    	addSequential(new TurnCommand(32, 0.5, 1));
    	addSequential(new DriveCommand(0.67, 0.67, 0.97));
    	addSequential(new TurnCommand(-32, 0.5, 1));
    	addSequential(new DriveCommand(0.67, 0.67, 1.6));
    }
}
