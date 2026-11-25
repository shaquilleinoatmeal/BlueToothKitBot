package frc.robot.subsystems;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.generated.TunerConstants;


public class Hopper extends SubsystemBase{
    private final TalonFX hopperMotor;
    //private final TalonFX altIntakeMotor;
    private final CANBus canbus = TunerConstants.kCANBus;
    public Hopper() {
        //create config object 
        TalonFXConfiguration hopperConfig = new TalonFXConfiguration();

        hopperMotor = new TalonFX(Constants.Hopper.HOPPER_MOTOR_CURRENT_LIMIT, canbus);

        hopperConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        hopperConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        hopperMotor.getConfigurator().apply(hopperConfig);
    }

    public enum HopperStates {
        // Inward, off, outward
        IN,
        OUT,
        OFF,
    }
    public void setHopper(HopperStates state) {
        switch (state) {
            case IN:
                setRawPower(0.01);
                break;
            case OUT:
                setRawPower(-0.01);
                break;
            case OFF:
                setRawPower(0);
                break;
        }
    }

    public void setRawPower(double power) {
        hopperMotor.set(power);
    }

}
