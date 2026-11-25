package frc.robot;

public class Constants {
    public static class Controllers {
        //Driver and Operator Contoller
        public static final int DRIVER_PORT = 0;
        public static final int OPERATOR_PORT = 1;

        //Controller
        public static final double DEADBAND = 0.08;
    }

    public interface Intake {
        static final int INTAKE_MOTOR_ID = 5; //change as needed
        public static final int INTAKE_MOTOR_CURRENT_LIMIT = 40;
    }
    public interface Belt {
        static final int BELT_MOTOR_ID = 5; //change as needed
        public static final int BELT_MOTOR_CURRENT_LIMIT = 40;
    }
    public interface Hopper {
        static final int HOPPER_MOTOR_ID = 5; //change as needed
        public static final int HOPPER_MOTOR_CURRENT_LIMIT = 40;
    }
    public interface Shooter {
        static final int SHOOTER_MOTOR_ID = 6; //change as needed
        //static final String CANBUS = "rio"; --changed to TunerConstants.kCANBus
        public static final int SHOOTER_MOTOR_CURRENT_LIMIT = 40;
    }
}
