package org.firstinspires.ftc.teamcode.Commands.AutoCommands;

import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.WaitCommand;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;

public class DriveBackward extends SequentialCommandGroup {
  public DriveBackward(MecanumDriveSubsystem drive, long cm) {
    addCommands(
        new InstantCommand(() -> drive.driveRobotCentric(-0.5, 0, 0)),
        new WaitCommand(cm * (500 / 45)),
        new InstantCommand(drive::stopMotors));
  }
}
