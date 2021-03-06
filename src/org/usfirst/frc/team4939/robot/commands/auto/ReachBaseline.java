package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.Robot;
import org.usfirst.frc.team4939.robot.commands.PlatformDown;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ReachBaseline extends CommandGroup {

    public ReachBaseline() {
    	addSequential(new DriveCommand(0.50, 0.50, 0.25));
    	addSequential(new PauseCommand(1));
    	addSequential(new PlatformDown());
    	//jerk forward
    	
    	addSequential(new DriveCommand (0.37, 0.35, 1.5));
        //addSequential(new DriveCommand(140, 0.5, 0 , 2.5));
    	addSequential(new PauseCommand (1));
    	//drive forward
    }
}
