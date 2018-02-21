package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.commands.BoxOuttake;
import org.usfirst.frc.team4939.robot.commands.BoxStopIntake;
import org.usfirst.frc.team4939.robot.commands.PlatformDown;
import org.usfirst.frc.team4939.robot.commands.PlatformUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterToLeftSwitch extends CommandGroup {

    public CenterToLeftSwitch() {
    	//addSequential(new DriveCommand(36, 0.5, 0, 1));
        addSequential(new TurnCommand(-90, 0.5, 1));
        //addSequential(new DriveCommand(54, 0.5, 0, 2));
        addSequential(new TurnCommand(90, 0.5, 1));
        
        addParallel(new PlatformUp());
        //addSequential(new DriveCommand(104, 0.5, 0, 2.5));
        addParallel(new BoxOuttake());
        addSequential(new PauseCommand(1));
        
        addParallel(new BoxStopIntake());
        addParallel(new PlatformDown());
        //addSequential(new DriveCommand(-20, 0.5, 0, 2.5));
    }
}
