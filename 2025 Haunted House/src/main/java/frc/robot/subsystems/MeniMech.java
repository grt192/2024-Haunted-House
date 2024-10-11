package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MeniMech extends SubsystemBase {
  
    private double handUpTime = 7;
    private double handDownTime = 3;
    private double headUpTime = 5;
    private double headDownTime = 5;
    private Timer headTimer, handTimer;
    private Solenoid handSolenoid;
    private Solenoid headSolenoid;


    public MeniMech(Solenoid headSolenoid, Solenoid handSolenoid) {
        this.headSolenoid= headSolenoid;
        this.handSolenoid = handSolenoid;
        headTimer= new Timer();
        handTimer = new Timer();
        headTimer.start();
        handTimer.start();
    }

    double handTimeUntilNextEvent = 0.0;
    double headTimeUntilNextEvent = 0.0;
    boolean headUp = true;
    boolean handUp = true;

    @Override 
    public void periodic() {
    if(headTimer.advanceIfElapsed(headTimeUntilNextEvent)){
        headUp = !headUp;
        if(headUp){
            headTimeUntilNextEvent = headUpTime;
        }
        else{
            headTimeUntilNextEvent = headDownTime;
        }
        headSolenoid.set(headUp);
    }

    if(handTimer.advanceIfElapsed(handTimeUntilNextEvent)){
        handUp = !handUp;
        if(handUp){
            handTimeUntilNextEvent = handUpTime;
        }
        else{
            handTimeUntilNextEvent = handDownTime;
        }
        handSolenoid.set(handUp);
    }
    }
}