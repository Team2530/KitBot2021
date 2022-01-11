// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class InCANCievable extends SubsystemBase {
    private int dvc_num = 5;

    private static final int mfg = 8; // Fill in from InCANCievable github
    private static final int type = 10; // Fill in from InCANCievable github

    private static final int STARTPROG_APID = 0b01;
    private static final int STOPPROG_APID = 0b10;
    

    CAN conn;

    /** Creates a new ExampleSubsystem. */
    public InCANCievable(int can_id) {
        conn = new CAN(dvc_num = can_id, mfg, type);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

        byte[] data = "Polling...".getBytes();

        conn.writePacket(data, POLL_APID);
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

    public void runProgram(int prog) {
        byte[] data = { (byte) prog };

        conn.writePacket(data, STARTPROG_APID);
    }

    public void stopProgram() {
        conn.writePacket(new byte[0], STOPPROG_APID);
    }
}
