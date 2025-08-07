package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.command.Subsystem;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.Utils;

public class DriveCommand extends CommandBase {
  private final MecanumDriveSubsystem drive;
  private final GamepadEx gamepad;

  private final double tolerance = 0.1; // Tolerance for joystick input

  public DriveCommand(MecanumDriveSubsystem drive, GamepadEx gamepad) {
    this.drive = drive;
    this.gamepad = gamepad;
    addRequirements((Subsystem) drive);
  }

  public void initialize() {
    // Nothing to do here
  }

  @Override
  public void execute() {
    double forward = -gamepad.getLeftY();
    double strafe = gamepad.getLeftX();
    double rotate = gamepad.getRightX();

    if (!Utils.isWithinTolerance(0, forward, tolerance)
        || !Utils.isWithinTolerance(0, strafe, tolerance)
        || !Utils.isWithinTolerance(0, rotate, tolerance)) {
      drive.driveRobotCentric(forward, strafe, rotate);
    } else {
      drive.stopMotors();
    }
  }

  public void end(boolean interrupted) {
    drive.stopMotors(); // Stop the drive motors when the command ends
  }

  @Override
  public boolean isFinished() {
    return false; // This command runs until explicitly stopped
  }
}
