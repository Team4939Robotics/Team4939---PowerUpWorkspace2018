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
	private char autoChoice;
	private char switchSide;
	private int chosen;
	
	public boolean nearRight;
	public boolean nearLeft;

    public void selectAuto() {
    	this.gameData = Robot.gameData;
    	this.startPosition = Robot.startPosition;
    	this.autoChoice = Robot.autoChoice;

		switchSide = gameData.charAt(0);
		
		if(switchSide == 'L'){
			if(startPosition == 'R'){
				if (autoChoice == 'V'){
					chosen = 6;
				}
				else if(autoChoice =='B'){
					chosen = 2;
				}
				else{
					chosen = 0;
				}
			
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
				if(autoChoice == 'V') {
					chosen = 0;
					//no right vault auto yet
				}
				else if (autoChoice == 'B'){
					chosen = 3;
				}
				else{
					chosen = 0;
				}
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
	    		Robot.autonomousCommand = new LeftAroundSwitch();
	    		break;
	    	case 3:
	    		Robot.autonomousCommand = new RightAroundSwitch();
	    		break;
	    	case 4:
	    		Robot.autonomousCommand = new CenterToLeftSwitch();
	    		break;
	    	case 5:
	    		Robot.autonomousCommand = new CenterToRightSwitch();
	    		break;
	    	case 6:
	    		Robot.autonomousCommand = new LeftToVault();
	    		break;
	    	case 7:
	    		Robot.autonomousCommand = new CenterVaultToBaseline();
	    		break;
    	}
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}