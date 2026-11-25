package frc.robot.subsystems;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.generated.TunerConstants;



public class Belt extends SubsystemBase{
    private TalonFX beltMotor;
    private final CANBus canbus = TunerConstants.kCANBus;
    public Belt() {
        //create config object 
        TalonFXConfiguration beltConfig = new TalonFXConfiguration();

        beltMotor = new TalonFX(Constants.Belt.BELT_MOTOR_CURRENT_LIMIT, canbus);
        beltConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        beltConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        beltMotor.getConfigurator().apply(beltConfig);
    }

    public enum BeltStates {
        // Inward, off, outward
        IN,
        OUT,
        OFF,
    }
    public void setBelt(BeltStates state) {
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
        beltMotor.set(power);
    }

}
