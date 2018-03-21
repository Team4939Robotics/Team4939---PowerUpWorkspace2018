package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.Robot;
import org.usfirst.frc.team4939.robot.commands.BoxClose;
import org.usfirst.frc.team4939.robot.commands.BoxStopIntake;
import org.usfirst.frc.team4939.robot.commands.PlatformDown;
import org.usfirst.frc.team4939.robot.commands.PlatformUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TimedAutoLeftTwoCube extends CommandGroup {

    public TimedAutoLeftTwoCube(char direction) {
    	//addSequential(new TurnCommand(90, 1, 3));
    	Robot.dt.resetGyroYaw();
    	addSequential(new DriveCommand(0.50, 0.50, 0.25));
    	addSequential(new PauseCommand(1));
    	addSequential(new PlatformDown());
    	//jerk forward
    	
    	addSequential(new DriveCommand (0.39, 0.35, 1.5));
        //addSequential(new DriveCommand(140, 0.5, 0 , 2.5));
    	addSequential(new PauseCommand (1));
    	//drive forward
    	
    	if(direction == 'L'){
    		addSequential (new BoxClose()); // reversed
    	addSequential(new AutoBoxOuttake());
        addSequential(new PauseCommand(1));
        addSequential(new BoxStopIntake());
        //release box
        Robot.dt.resetGyroYaw();
    //    addSequential(new PauseCommand(1));
        addSequential(new DriveCommand (-0.45, -0.45, 1));
        addSequential(new PlatformUp());
    	addSequential(new TurnCommand(-45, 0.5, 2));
    	addSequential(new DriveCommand(-0.60, -0.60, 1));

        //back up and bring platform down
       // addSequential(new DriveCommand (-0.75, -0.10, 0.50));
      //  addSequential(new PauseCommand (1));
     //   addSequential(new DriveCommand (-0.1, -0.75, 0.85));*/
    	}
    }
}