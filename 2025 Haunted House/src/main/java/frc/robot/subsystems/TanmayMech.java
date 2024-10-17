package frc.robot.subsystems;

import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TanmayMech extends SubsystemBase{
    private Solenoid creeperSolenoid;
    
    NetworkTableInstance inst;
    NetworkTable table;
    DoublePublisher audioPub;

    private boolean out;

    private Timer solenoidTimer;

    private double upTime = 5;
    private double downTime = 5;
    private double timeUntilNextEvent = 0;

    public TanmayMech(Solenoid creeperSolenoid) {
        this.creeperSolenoid = creeperSolenoid;

        inst = NetworkTableInstance.getDefault();
        table = inst.getTable("audio");
        audioPub = table.getDoubleTopic("trigger_audio").publish();
        solenoidTimer = new Timer();

        
        out = false;

        solenoidTimer.start();
    }

    public void periodic() {
        if (solenoidTimer.advanceIfElapsed(timeUntilNextEvent)){
            out = !out;
            creeperSolenoid.set(out);
            if(out == true){
                audioPub.set(3.0);
                audioPub.set(0.0);
                timeUntilNextEvent = downTime;
            }
            else{
                timeUntilNextEvent = upTime;
            }
        }
    }
    
}
