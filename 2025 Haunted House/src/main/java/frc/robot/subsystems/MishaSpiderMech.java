// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MishaSpiderMech extends SubsystemBase {
  
  private double uptime;
  private double downtime;
  private double randomnessUp = 0.0;
  private double randomnessDown = 0.0;
  private Timer timer;
  private DoubleSolenoid solenoid;


  public MishaSpiderMech(DoubleSolenoid solenoid, double uptime, double downtime) {
    this.uptime = uptime;
    this.downtime = downtime;
    this.solenoid = solenoid;
    timer = new Timer();
    timer.start();
  }

  public MishaSpiderMech(DoubleSolenoid solenoid, double uptime, double downtime, double randomness) {
    this(solenoid, uptime, downtime);
    this.randomnessUp = randomness;
    this.randomnessDown = randomness;
  }

  
  double timeUntilNextEvent = 0.0;
  boolean up = false;
  
  public void periodic() {
    if(timer.advanceIfElapsed(timeUntilNextEvent)){
      up = !up;
      // Time is random in the range [uptime - uptime * randomnesesUp, uptime + uptime * randomnessUp] if switching to up
      // or [downtime - downtime * randomnesesDown, downtime + downtime * randomnessDown] if switching to down
      timeUntilNextEvent = (up ? uptime * (1 + (Math.random() * 2 - 1) * randomnessUp) : downtime * (1 + (Math.random() * 2 - 1) * randomnessDown)) ;
    }
    if(up){
      solenoid.set(Value.kForward);
    }
    else{
      solenoid.set(Value.kReverse);
    }
  }

  
}