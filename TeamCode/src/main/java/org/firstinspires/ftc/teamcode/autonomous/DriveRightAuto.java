package org.firstinspires.ftc.teamcode.autonomous;

import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import org.firstinspires.ftc.teamcode.Commands.AutoCommands.DriveStrafeRight;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;

public class DriveRightAuto extends SequentialCommandGroup {
  public DriveRightAuto(MecanumDriveSubsystem drive) {
    addCommands(
        // Movement sequence
        new DriveStrafeRight(drive, 70));
  }
}
