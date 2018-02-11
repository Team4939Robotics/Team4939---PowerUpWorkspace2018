package org.usfirst.frc.team4939.robot;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Ultrasonic {
	// Volts per inch
    public static final double SCALING_FACTOR = 0.1176;

    // Port
    private static final int ULTRASONIC_CHANNEL = 2;

    private final AnalogChannel ultrasonic;
    private double measuredVoltage;

    public Ultrasonic() {
        ultrasonic = new AnalogChannel(ULTRASONIC_CHANNEL);
    }

    public void robotDisable() {}

    public void robotEnable() {}

    public void robotAuton() {
        measuredVoltage = ultrasonic.getVoltage();
    }

    public void act() {
        measuredVoltage = ultrasonic.getVoltage();
    }

    /**
     * @return Distance to the target, in feet
     */
    public double getDistance() {
    	SmartDashboard.putNumber("Distance:", DriveSubsystem.getDistance());
    	return measuredVoltage / SCALING_FACTOR;
        
    }

    /**
     * @return Voltage output from the ultrasonic
     */
    public double getRaw() {
        return measuredVoltage;
    }
}

