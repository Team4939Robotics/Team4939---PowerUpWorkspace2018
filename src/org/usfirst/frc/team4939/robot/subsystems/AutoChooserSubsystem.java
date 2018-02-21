package org.usfirst.frc.team4939.robot.subsystems;

import org.usfirst.frc.team4939.robot.Robot;
import org.usfirst.frc.team4939.robot.commands.auto.*;

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
				chosen = 2;
			}
			else if(startPosition == 'L') {
				chosen = 1;
			}
			else if(startPosition == 'C') {
				chosen = 4;
			}
		}
    	
		else if(switchSide == 'R'){
			if(startPosition == 'R'){
				chosen = 1;
		}
			else if(startPosition == 'L') {
				chosen = 3;
			}
			else if (startPosition == 'C') {
				chosen = 5;
			}
		}
		else {
			chosen = 0;
		}
    }
    
    public void launchAuto() {
    	switch (chosen){
	    	case 0:
	    		Robot.autonomousCommand = new DoNothingAuto();
	    		break;
	    	case 1: 
	    		Robot.autonomousCommand = new StraightToSwitch();
	    		break;
	    	case 2:
	    		Robot.autonomousCommand = new LeftSwitch();
	    		break;
	    	case 3:
	    		Robot.autonomousCommand = new RightSwitch();
	    		break;
	    	case 4:
	    		Robot.autonomousCommand = new CenterToLeftSwitch();
	    		break;
	    	case 5:
	    		Robot.autonomousCommand = new CenterToRightSwitch();
	    		break;
    		
    	}
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}