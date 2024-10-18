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
    private boolean soundplayed;
    private boolean set0;

    private Timer solenoidTimer;

    private double upTime = 5;
    private double downTime = 5;

    public TanmayMech(Solenoid creeperSolenoid) {
        this.creeperSolenoid = creeperSolenoid;

        inst = NetworkTableInstance.getDefault();
        table = inst.getTable("audio");
        audioPub = table.getDoubleTopic("trigger_audio").publish();
        solenoidTimer = new Timer();

        
        set0 = false;
        out = false;

        solenoidTimer.start();
    }

    public void periodic() {
        if (solenoidTimer.hasElapsed(2) && (out == false)){
            out = true;
            creeperSolenoid.set(out);
            audioPub.set(3.0);
        }
        if (solenoidTimer.hasElapsed(4) && (out == true)){
            audioPub.set(0);
            out = false;
            creeperSolenoid.set(out);
        }
        if (solenoidTimer.advanceIfElapsed(17)){
            out = false;
        }
    }
    
}
