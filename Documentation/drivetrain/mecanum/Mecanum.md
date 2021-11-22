# Mecanum
class Mecanum

## public Mecanum

```
public Mecanum(
            DcMotorEx front_right_motor,
            DcMotorEx front_left_motor,
            DcMotorEx back_right_motor,
            DcMotorEx back_left_motor);
```
Constructor that initializes with DcMotorEx objects


## public Mecanum

```
public Mecanum(
            HardwareMap hmap,
            String front_right_motor,
            String front_left_motor,
            String back_right_motor,
            String back_left_motor);
```
Constructor that initializes with a HardwareMap and motor ids


## public void powerDrive

```
public void powerDrive(double forwardPower, double strafePower, double turningPower);
```
Drives based off 3 power parameters.
