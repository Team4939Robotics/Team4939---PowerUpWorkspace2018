package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.commands.BoxOuttake;
import org.usfirst.frc.team4939.robot.commands.BoxStopIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToVault extends CommandGroup {

    public LeftToVault() {
        //addSequential(new DriveCommand(36, 0.5, 0, 1));
        addSequential(new TurnCommand(90, 0.5, 1));
        //addSequential(new DriveCommand(110, 0.5, 0, 1));
        addSequential(new TurnCommand(90, 0.5, 1));
        //addSequential(new DriveCommand(36, 0.5, 0, 1));
        
        addParallel(new BoxOuttake());
    	addSequential(new PauseCommand(1));
    	addParallel(new BoxStopIntake());
    	//addSequential(new DriveCommand(-140, 0.5, 0, 2.5));
        
    }
}
