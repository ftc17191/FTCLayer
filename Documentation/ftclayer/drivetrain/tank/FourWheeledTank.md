# FourWheeledTank
class FourWheeledTank

## public FourWheeledTank

```
public FourWheeledTank(
            DcMotorEx front_right_motor,
            DcMotorEx front_left_motor,
            DcMotorEx back_right_motor,
            DcMotorEx back_left_motor);
```
Constructor that initializes with DcMotorEx objects


## public FourWheeledTank

```
public FourWheeledTank(
            HardwareMap hmap,
            String front_right_motor,
            String front_left_motor,
            String back_right_motor,
            String back_left_motor);
```
Constructor that initializes with a HardwareMap and motor ids


## public void powerDrive

```
public void powerDrive(double right_power, double left_power)
```
Drives based off 2 power parameters, tank style.
