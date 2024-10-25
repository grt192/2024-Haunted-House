// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.ErinandTanmayMech;
import frc.robot.subsystems.SolenoidMech;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.MeniMech;
import frc.robot.subsystems.MishaSpiderMech;
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

    public static final int justinPort = 2;
    private final SolenoidMech justinMech = new SolenoidMech(pcm2.makeSolenoid(justinPort), 3, 7, 0.7);
    private final MeniMech meniMech;
    private final SolenoidMech hamzaMech;
    private final SolenoidMech kiessMech;

    private final ErinandTanmayMech erinandtanmayMech; 

    private final MishaSpiderMech mishaspiderMech;
    private final SolenoidMech mishalegMech;
    private final int satvikPort = 0;
    private final SolenoidMech satvikMech = new SolenoidMech(pcm1.makeSolenoid(satvikPort), 4, 5);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    hamzaMech = new SolenoidMech(pcm1.makeSolenoid(2), 2, 5);
    meniMech = new MeniMech(pcm1.makeSolenoid(3), pcm1.makeSolenoid(4));
    kiessMech = new SolenoidMech(pcm2.makeSolenoid(3), 3, 5);
    mishaspiderMech = new MishaSpiderMech(pcm2.makeDoubleSolenoid(0, 4), 3, 3, 1);
    mishalegMech = new SolenoidMech(pcm2.makeSolenoid(1), 1, 1);
    // Configure the trigger bindings

    erinandtanmayMech = new ErinandTanmayMech(pcm1.makeSolenoid(5), pcm1.makeSolenoid(1));

  }



}
