package org.firstinspires.ftc.teamcode.Commands.AutoCommands;

import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.WaitCommand;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;

public class RotateRight extends SequentialCommandGroup {
  public RotateRight(MecanumDriveSubsystem drive, long time) {
    addCommands(
        new InstantCommand(() -> drive.driveRobotCentric(0, 0, 0.5)),
        new WaitCommand(time),
        new InstantCommand(drive::stopMotors));
  }
}
