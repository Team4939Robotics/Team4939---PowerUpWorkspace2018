package org.usfirst.frc.team4939.robot.subsystems;

import org.usfirst.frc.team4939.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class AutoChooserSubsystem extends Subsystem {
	private String gameData;
	private char startPosition;
	private char switchSide;
	private int chosen;
	
	public boolean nearRight;
	public boolean nearLeft;

    public void selectAuto() {
    	this.gameData = Robot.gameData;
    	this.startPosition = Robot.startPosition;

		switchSide = gameData.charAt(0);
		
		if(switchSide == 'L'){
			if(startPosition == 'R'){
				chosen = 1;
			}
			else if(startPosition == 'L') {
				chosen = 2;
			}
		}
    	
		else if(switchSide == 'R'){
			if(startPosition == 'R'){
				chosen = 1;
		}
			else if(startPosition == 'L') {
				chosen = 3;
			}
		}
		else {
			chosen = 0;
		}
    }
    
    public void launchAuto() {
    	switch (chosen){
    	case 1:
    		
    		
    	}
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}