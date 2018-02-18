package org.usfirst.frc.team4939.robot.commands.auto;

import org.usfirst.frc.team4939.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterVaultToBaseline extends CommandGroup {

    public CenterVaultToBaseline() {
    	addParallel(new PlatformDown());
    	//put more here
        
    }
}
