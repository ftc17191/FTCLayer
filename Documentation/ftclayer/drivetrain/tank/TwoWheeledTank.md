# TwoWheeledTank
class TwoWheeledTank

## public TwoWheeledTank

```
public TwoWheeledTank(
            DcMotorEx right_motor,
            DcMotorEx left_motor);
```
Constructor that initializes with DcMotorEx objects


## public TwoWheeledTank

```
public TwoWheeledTank(
            HardwareMap hmap,
            String right_motor,
            String left_motor);
```
Constructor that initializes with a HardwareMap and motor ids


## public void powerDrive

```
public void powerDrive(double right_power, double left_power)
```
Drives based off 2 power parameters, tank style.
