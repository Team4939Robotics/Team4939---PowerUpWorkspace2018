package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.commands.*;
import org.usfirst.frc.team4939.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSwitchTurnToCubes extends CommandGroup{
	public LeftSwitchTurnToCubes() {
        
    	addSequential(new DriveCommand(168, 0.5, 0, 2.5));
    	addSequential(new TurnCommand(90, 0.5, 2.5));
    	
    	addSequential(new GetUltrasonicDistance());
    	addSequential(new DriveCommand(Robot.ultrasonicDistance, 0.5, 0, 2.5));
    	addSequential(new BoxOuttake());
    	addSequential(new DriveCommand(-Robot.ultrasonicDistance, 0.5, 0, 2.5));
    	addParallel(new BoxStopIntake());
    	
    	addSequential(new TurnCommand(-90, 0.5, 2.5));
    	addSequential(new DriveCommand(36, 0.5, 0, 2.5));
    	addSequential(new TurnCommand(90, 0.5, 2.5));
    }
}
