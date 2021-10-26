// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OIConstants;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterIntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final ShooterIntakeSubsystem m_shooterIntakeSubsystem = new ShooterIntakeSubsystem();

  // The driver's controller
  Joystick m_driverController = new Joystick(OIConstants.kDriverControllerPort);
  Joystick m_driverControllerRight = new Joystick(1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    // Set the default drive command to split-stick arcade drive
    m_robotDrive.setDefaultCommand(
        // A split-stick arcade command, with forward/backward controlled by the left
        // hand, and turning controlled by the right.
        new RunCommand(
            () ->
                m_robotDrive.arcadeDrive(
                    m_driverController.getY(GenericHID.Hand.kLeft),
                    m_driverController.getX(GenericHID.Hand.kRight)),
            m_robotDrive));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * JoystickButton}.
   */
  private void configureButtonBindings() {
    
    new JoystickButton(m_driverController, 5)
        .whenPressed(() -> m_shooterIntakeSubsystem.intakeBall(6.0))
        .whenReleased(() -> m_shooterIntakeSubsystem.intakeBall(0));

    // Move the arm to neutral position when the 'B' button is pressed.
    new JoystickButton(m_driverController, 6)
        .whenPressed(() -> m_shooterIntakeSubsystem.shootBall(-5.3))
        .whenReleased(() -> m_shooterIntakeSubsystem.shootBall(0));

    new JoystickButton(m_driverController, 2)
        .whenPressed(() -> m_shooterIntakeSubsystem.shootBall(3.0))
        .whenPressed(() -> m_shooterIntakeSubsystem.intakeBall(-3.0))
        .whenReleased(() -> m_shooterIntakeSubsystem.shootBall(0))
        .whenReleased(() -> m_shooterIntakeSubsystem.intakeBall(0));

    

    // Drive at half speed when the bumper is held
    new JoystickButton(m_driverController, 4)
        .whenPressed(() -> m_robotDrive.setMaxOutput(0.3))
        .whenReleased(() -> m_robotDrive.setMaxOutput(1));
  }

  /**
   * Disables all ProfiledPIDSubsystem and PIDSubsystem instances. This should be called on robot
   * disable to prevent integral windup.
   */
  public void disablePIDSubsystems() {
    // m_robotArm.disable();
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new InstantCommand();
  }
}