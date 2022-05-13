package org.ftc17191.ftclayer.hardware.revhub;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class RevHubParameters
{
    public HardwareMap hardwareMap;
    public String motor[] = new String[4];
    public String servo[] = new String[6];
    public String i2c[] = new String[4];

    public RevHubParameters(@NonNull HardwareMap hardwareMap)
    {
        this.hardwareMap = hardwareMap;
    }



}
