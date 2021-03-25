/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


/**
 * Shoot and Intake Balls.
 */
public class ShooterIntakeSubsystem extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  public PWMVictorSPX intake = new PWMVictorSPX(9);
  public PWMVictorSPX shooter = new PWMVictorSPX(8);

  public void intakeBall(double speed) {
    intake.set(speed);
    System.out.println("am i intaking ball?");
  }

  public void shootBall(double speed) {
    shooter.set(speed);
    System.out.println("am i shooting ball?");
  }


}
