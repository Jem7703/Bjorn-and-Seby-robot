// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.Encoder;
// import edu.wpi.first.wpilibj.PWMSparkMax;
// import edu.wpi.first.wpilibj.controller.ArmFeedforward;
// import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
// import frc.robot.Constants.ShooterIntakeConstants;
// import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
// import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;

// /** A robot arm subsystem that moves with a motion profile. */
// public class ArmSubsystem extends ProfiledPIDSubsystem {
//   private final PWMSparkMax m_motor = new PWMSparkMax(ShooterIntakeConstants.kMotorPort);
//   private final Encoder m_encoder =
//       new Encoder(ShooterIntakeConstants.kEncoderPorts[0], ShooterIntakeConstants.kEncoderPorts[1]);
//   private final ArmFeedforward m_feedforward =
//       new ArmFeedforward(
//         ShooterIntakeConstants.kSVolts, ShooterIntakeConstants.kCosVolts,
//           ArmConstants.kVVoltSecondPerRad, ArmConstants.kAVoltSecondSquaredPerRad);

//   /** Create a new ArmSubsystem. */
//   public ArmSubsystem() {
//     super(
//         new ProfiledPIDController(
//             ArmConstants.kP,
//             0,
//             0,
//             new TrapezoidProfile.Constraints(
//                 ArmConstants.kMaxVelocityRadPerSecond,
//                 ArmConstants.kMaxAccelerationRadPerSecSquared)),
//         0);
//     m_encoder.setDistancePerPulse(ArmConstants.kEncoderDistancePerPulse);
//     // Start arm at rest in neutral position
//     setGoal(ArmConstants.kArmOffsetRads);
//   }

//   @Override
//   public void useOutput(double output, TrapezoidProfile.State setpoint) {
//     // Calculate the feedforward from the sepoint
//     double feedforward = m_feedforward.calculate(setpoint.position, setpoint.velocity);
//     // Add the feedforward to the PID output to get the motor output
//     m_motor.setVoltage(output + feedforward);
//   }

//   @Override
//   public double getMeasurement() {
//     return m_encoder.getDistance() + ArmConstants.kArmOffsetRads;
//   }
// }
