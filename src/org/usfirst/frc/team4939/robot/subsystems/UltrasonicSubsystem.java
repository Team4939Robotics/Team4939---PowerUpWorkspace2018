package org.usfirst.frc.team4939.robot.subsystems;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;


public class UltrasonicSubsystem extends Subsystem{
	// Volts per inch
    public static final double SCALING_FACTOR = 0.1176;

    // Port
    private static final int ULTRASONIC_CHANNEL = 2;

    private final AnalogInput ultrasonic;
    private double measuredVoltage;

    public UltrasonicSubsystem() {
        ultrasonic = new AnalogInput(ULTRASONIC_CHANNEL);
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
        return measuredVoltage / SCALING_FACTOR;
    }

    /**
     * @return Voltage output from the ultrasonic
     */
    public double getRaw() {
        return measuredVoltage;
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
