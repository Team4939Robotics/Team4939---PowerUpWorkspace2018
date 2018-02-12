package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.Robot;
import org.usfirst.frc.team4939.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSwitch extends CommandGroup {

    public RightSwitch() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new DriveCommand(168, 0.5, 0, 2.5));
    	addSequential(new TurnCommand(-90, 0.5, 2.5));
    	addSequential(new GetUltrasonicDistance());
    	addSequential(new DriveCommand(Robot.ultrasonicDistance, 0.5, 0, 2.5));
    	addSequential(new BoxOuttake());
    	addSequential(new DriveCommand(-Robot.ultrasonicDistance, 0.5, 0, 2.5));
    	addParallel(new BoxStopIntake());
    	addSequential(new TurnCommand(0, 0.5, 2.5));
    	addSequential(new DriveCommand(40, 0.5, 0, 2.5));
    }
}
