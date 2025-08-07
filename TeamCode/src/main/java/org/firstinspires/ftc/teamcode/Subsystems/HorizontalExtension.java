package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import org.firstinspires.ftc.teamcode.Constants;

public class HorizontalExtension extends SubsystemBase {
  private final CRServo rightExtensionServo;
  private final CRServo leftExtensionServo;

  private final double MAX_POWER = 1;
  private final double MIN_POWER = -1;

  private final HardwareMap hwMap;

  public HorizontalExtension(HardwareMap hwMap) {
    this.hwMap = hwMap;

    rightExtensionServo = hwMap.crservo.get(Constants.HorizontalConstants.RIGHT_EXTENSION_ID);
    leftExtensionServo = hwMap.crservo.get(Constants.HorizontalConstants.LEFT_EXTENSION_ID);
    rightExtensionServo.setDirection(CRServo.Direction.REVERSE);
  }

  public void setPower(double power) {
    if (power < MAX_POWER && power > MIN_POWER) {
      leftExtensionServo.setPower(power);
      rightExtensionServo.setPower(power);
    }
  }

  public void extend() {
    setPower(Constants.HorizontalConstants.EXTENSION_POWER);
  }

  public void retract() {
    setPower(-Constants.HorizontalConstants.EXTENSION_POWER);
  }

  public void stopServos() {
    setPower(0);
  }
}
