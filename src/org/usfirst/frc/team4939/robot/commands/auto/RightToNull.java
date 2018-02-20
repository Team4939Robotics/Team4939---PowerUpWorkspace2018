package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.Robot;
import org.usfirst.frc.team4939.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightToNull extends CommandGroup{
	
	public RightToNull(){
		
	addSequential(new DriveCommand(300, 0.5, 0, 2.5));
	
	}
}