package org.usfirst.frc.team4939.robot.subsystems;

import org.usfirst.frc.team4939.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem{
	public static WPI_TalonSRX leftarm = new WPI_TalonSRX(RobotMap.leftArmIntake);
	public static WPI_TalonSRX rightarm= new WPI_TalonSRX(RobotMap.rightArmIntake);
    
	//double kp = 0.008;
    
    static final double kP = 0.03;
    static final double kI = 0.00;
    static final double kD = 0.00;
    static final double kF = 0.00;
    
    static final double kToleranceDegrees = 2.0f;
    
    //INTAKE PNEUMATICS

    public DoubleSolenoid boxMechOpeningPistons = new DoubleSolenoid(RobotMap.leftIntakePiston, RobotMap.rightIntakePiston);
    public boolean boxMechOpen = false;
    protected void initDefaultCommand() {
    	// TODO Auto-generated method stub
    }
    	
    public void openBoxMech () {
    	this.boxMechOpeningPistons.set(DoubleSolenoid.Value.kForward);
    	this.boxMechOpen = false;
    }
    	
    public void closeBoxMech() {
    	this.boxMechOpeningPistons.set(DoubleSolenoid.Value.kReverse);
    	this.boxMechOpen = true;
    }
    
    public void useIntake(double speed) {
    	leftarm.set(speed);
    	rightarm.set(-speed);
    }
    	
}
