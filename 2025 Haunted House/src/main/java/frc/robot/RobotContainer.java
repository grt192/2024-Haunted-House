// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.ErinandTanmayMech;
import frc.robot.subsystems.SolenoidMech;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.MeniMech;
import frc.robot.subsystems.SolenoidMech;
import edu.wpi.first.wpilibj.PneumaticsControlModule;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  // PCM1 is floor 1 of haunted house, PCM2 is floor 2
    private final PneumaticsControlModule pcm1 = new PneumaticsControlModule(0);
    private final PneumaticsControlModule pcm2 = new PneumaticsControlModule(1);

    private final MeniMech meniMech;

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        meniMech = new MeniMech(pcm1.makeSolenoid(3), pcm1.makeSolenoid(4));

    }
  private final PneumaticsControlModule pcm1 = new PneumaticsControlModule(0);
  private final PneumaticsControlModule pcm2 = new PneumaticsControlModule(1);
  public static final int justinPort = 2;

  //TOP LEFT WINDOW
  private final SolenoidMech justinMech = new SolenoidMech(pcm2.makeSolenoid(justinPort), 3, 7, 0.7);

  //Front Porch, using PCM1
  // private final SolenoidMech tanmayMech = new SolenoidMech(pcm1.makeSolenoid(tanmayPort), 5, 5);
  private final ErinandTanmayMech erinandtanmayMech; 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings

    erinandtanmayMech = new ErinandTanmayMech(pcm1.makeSolenoid(5), pcm1.makeSolenoid(1));

  }



}
