package frc.robot.subsystems;

import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ErinMech extends SubsystemBase{
    private Solenoid creeperSolenoid;
    
    NetworkTableInstance inst;
    NetworkTable table;
    DoublePublisher audioPub;

    private boolean out;
    private boolean soundstarted;

    private Timer solenoidTimer;

    public ErinMech(Solenoid creeperSolenoid) {
        this.creeperSolenoid = creeperSolenoid;

        inst = NetworkTableInstance.getDefault();
        table = inst.getTable("audio");
        audioPub = table.getDoubleTopic("trigger_audio").publish();
        solenoidTimer = new Timer();

        out = false;
        soundstarted = false;

        solenoidTimer.start();
    }

    public void periodic() {
        if (solenoidTimer.hasElapsed(13) && (soundstarted == false)){
            audioPub.set(1.0);
            soundstarted = true;
        }
        if (solenoidTimer.hasElapsed(15) && (out == false)){
            creeperSolenoid.set(true);
            audioPub.set(2.0);
            out = true;
        }
        if (solenoidTimer.advanceIfElapsed(17) && (out == true)){
            creeperSolenoid.set(false);
            audioPub.set(0.0);
            out = false;
            soundstarted = false;
        }

    }
    
}
