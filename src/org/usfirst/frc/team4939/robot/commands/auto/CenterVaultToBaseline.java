package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterVaultToBaseline extends CommandGroup {

    public CenterVaultToBaseline() {
    	addParallel(new PlatformDown());
    	addSequential(new DriveCommand(36, 0.5, 0, 1));
    	addSequential(new TurnCommand(-90, 0.5, 1));
    	addSequential(new DriveCommand(20, 0.5, 0, 1));
    	addSequential(new TurnCommand(-90, 0.5, 1));
    	addSequential(new DriveCommand(36, 0.5, 0, 1));
    	
    	addParallel(new BoxOuttake());
    	addSequential(new PauseCommand(1));
    	addParallel(new BoxStopIntake());
    	addSequential(new DriveCommand(-140, 0.5, 0, 2.5));
        
    }
}
