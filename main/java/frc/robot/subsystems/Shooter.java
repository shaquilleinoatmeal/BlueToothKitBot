package frc.robot.subsystems;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.generated.TunerConstants;



public class Shooter extends SubsystemBase{
    private TalonFX shooterMotor;
    private final CANBus canbus = TunerConstants.kCANBus;
    public Shooter() {
        //create config object 
        TalonFXConfiguration shooterConfig = new TalonFXConfiguration();

        shooterMotor = new TalonFX(Constants.Shooter.SHOOTER_MOTOR_CURRENT_LIMIT, canbus);
        shooterConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        shooterConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        shooterMotor.getConfigurator().apply(shooterConfig);
    }

    public enum ShooterStates {
        // Inward, off, outward
        IN,
        OUT,
        OFF,
    }
    public void setShooter(ShooterStates state) {
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
        shooterMotor.set(power);
    }

}
