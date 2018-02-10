
package org.usfirst.frc.team4939.robot.subsystems;

import org.usfirst.frc.team4939.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
	ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	public WPI_TalonSRX leftsidedrivefront = new WPI_TalonSRX(RobotMap.leftDriveFront);
	public WPI_TalonSRX leftsidedriveback= new WPI_TalonSRX(RobotMap.leftDriveBack);
	public WPI_TalonSRX rightsidedrivefront= new WPI_TalonSRX(RobotMap.rightDriveFront);
    public WPI_TalonSRX rightsidedriveback= new WPI_TalonSRX(RobotMap.rightDriveBack);
 //   public Talon lights = new Talon(RobotMap.lights);
   
    //double kp = 0.008;
    
    static final double kP = 0.03;
    static final double kI = 0.00;
    static final double kD = 0.00;
    static final double kF = 0.00;
    
    static final double kToleranceDegrees = 2.0f;
    
    private AHRS ahrs;
    PIDController turnController;
    double rotateToAngleRate;
    
    public DriveSubsystem() {
    	try {
			/***********************************************************************
			 * navX-MXP:
			 * - Communication via RoboRIO MXP (SPI, I2C, TTL UART) and USB.            
			 * - See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface.
			 * 
			 * navX-Micro:
			 * - Communication via I2C (RoboRIO MXP or Onboard) and USB.
			 * - See http://navx-micro.kauailabs.com/guidance/selecting-an-interface.
			 * 
			 * Multiple navX-model devices on a single robot are supported.
			 ************************************************************************/
            ahrs = new AHRS(SerialPort.Port.kMXP);
        } catch (RuntimeException ex ) { 
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }
//    	turnController = new PIDController(kP, kI, kD, kF, ahrs, this);
//        turnController.setInputRange(-180.0f,  180.0f);
//        turnController.setOutputRange(-1.0, 1.0);
//        turnController.setAbsoluteTolerance(kToleranceDegrees);
//        turnController.setContinuous(true);
//        
//        /* Add the PID Controller to the Test-mode dashboard, allowing manual  */
//        /* tuning of the Turn Controller's P, I and D coefficients.            */
//        /* Typically, only the P value needs to be modified.                   */
//        LiveWindow.addActuator("DriveSystem", "RotateController", turnController);
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
 //   	setDefaultCommand(new TankDrive());
    }

public void runleftsidedrive(double left)
{
	leftsidedrivefront.set(left);
	leftsidedriveback.set(left);
//	this.lights.set(left);
}
public void runrightsidedrive(double right)
{ 
	this.rightsidedriveback.set(right);
	this.rightsidedrivefront.set(right);
}
public double angle()
{
	return gyro.getAngle();
}
public double rate ()
{
	return gyro.getRate();
}

public void driveStraight(double leftpower, double rightpower, double time)
{
	//gyro.reset();
	{
	this.runleftsidedrive(leftpower);
	SmartDashboard.putNumber("angle", angle());
	this.runrightsidedrive(rightpower);
	}
	Timer.delay(time);
}

public void driveStraightAngle(double leftpower, double rightpower, double time)
{
	this.runleftsidedrive(leftpower - getGyroYaw()*kP);
	SmartDashboard.putNumber("angle", angle());
	this.runrightsidedrive(rightpower - getGyroYaw()*kP);
}

public void rotateright(double rightpower, double leftpower, double time)
{
	{
	this.runleftsidedrive(leftpower);
	this.runrightsidedrive(rightpower);
	}
	Timer.delay(time);
}
public void rotateleft(double rightpower, double leftpower, double time)
{
	{
		this.runleftsidedrive(leftpower);
		this.runrightsidedrive(rightpower);
		}
		Timer.delay(time);
}
public void stop()
{
	this.runleftsidedrive(0);
	this.runrightsidedrive(0);
}

public void pause(double time)
{
	{
		this.runleftsidedrive(0);
		this.runrightsidedrive(0);
	}
	Timer.delay(time);
}
public void calibrate_gyro()
{
	gyro.calibrate();
}

public void resetGyro() {
	gyro.reset();
}

public AHRS getAhrs() {
	return ahrs;
}

public double getGyroYaw() {
    return ahrs.getAngle();
}

public void resetGyroYaw() {
    ahrs.reset();
}




}
