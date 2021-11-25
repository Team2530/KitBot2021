package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class SingleJoystickDrive extends CommandBase {
    private final DriveTrain drive;
  
    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public SingleJoystickDrive(DriveTrain subsystem) {
        drive = subsystem;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        System.out.println(drive.motor_l);
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        drive.motor_l.set(1.0);
        drive.motor_r.set(1.0);

        SmartDashboard.putNumber("drive.motor_l",  drive.motor_l.get());
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}
