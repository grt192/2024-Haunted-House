package frc.robot.subsystems;

import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ErinandTanmayMech extends SubsystemBase{
    private Solenoid creeperSolenoid;
    private Solenoid amongusSolenoid;
    
    NetworkTableInstance inst;
    NetworkTable table;
    DoublePublisher audioPub;

    private boolean out;
    private boolean outT;
    private boolean start;
    private boolean soundstarted;

    private Timer solenoidTimer;

    public ErinandTanmayMech(Solenoid creeperSolenoid, Solenoid amongusSolenoid) {
        this.creeperSolenoid = creeperSolenoid;
        this.amongusSolenoid = amongusSolenoid;

        inst = NetworkTableInstance.getDefault();
        table = inst.getTable("audio");
        audioPub = table.getDoubleTopic("trigger_audio").publish();
        solenoidTimer = new Timer();

        outT = false;
        out = false;
        start = false;
        soundstarted = false;

        solenoidTimer.start();
    }

    public void periodic() {
        if (solenoidTimer.hasElapsed(2) && (start == false)){
            outT = true;
            start = true;
            creeperSolenoid.set(outT);
            audioPub.set(3.0);
        }
        if (solenoidTimer.hasElapsed(4) && (outT == true)){
            audioPub.set(0.0);
            outT = false;
            creeperSolenoid.set(outT);
        }
        if (solenoidTimer.hasElapsed(13) && (soundstarted == false)){
            audioPub.set(1.0);
            soundstarted = true;
        }
        if (solenoidTimer.hasElapsed(15) && (out == false)){
            creeperSolenoid.set(true);
            audioPub.set(2.0);
            out = true;
        }
        if (solenoidTimer.advanceIfElapsed(18)){
            creeperSolenoid.set(false);
            audioPub.set(0.0);
            out = false;
            outT = false;
            start = false;
            soundstarted = false;
        }

    }
    
}
