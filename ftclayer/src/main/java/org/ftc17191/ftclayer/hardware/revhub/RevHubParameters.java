package org.ftc17191.ftclayer.hardware.revhub;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * The type Rev hub parameters.
 */
public class RevHubParameters
{
    /**
     * The Hardware map.
     */
    public HardwareMap hardwareMap;
    /**
     * The Motor ids.
     */
    public String motor[] = new String[4];
    /**
     * The Servo ids.
     */
    public String servo[] = new String[6];
    /**
     * The i2c ids.
     */
    public String i2c[] = new String[4];

    /**
     * Instantiates a new Rev hub parameters.
     *
     * @param hardwareMap the hardware map
     */
    public RevHubParameters(@NonNull HardwareMap hardwareMap)
    {
        this.hardwareMap = hardwareMap;
    }



}
