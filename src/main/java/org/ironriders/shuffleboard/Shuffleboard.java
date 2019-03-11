package org.ironriders.shuffleboard;

import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.networktables.*;

public class Shuffleboard {

    public static void main(String[] args) {
        try {
            // Pretend we are a Robot
            Shuffleboard pretendRobot = new Shuffleboard();
            pretendRobot.robotInit();
            pretendRobot.autonomousInit();
            while (true) {
                Thread.sleep(20);
                pretendRobot.autonomousPeriodic();
            }
        }
        catch (Exception e) {

        }
    }

    SendableChooser autoPathChooser1 = new SendableChooser();
    SendableChooser autoPathChooser2 = new SendableChooser();
    SendableChooser autoPathChooser3 = new SendableChooser();

    public void robotInit() {
        // Connect to Network Tables
        NetworkTableInstance clientInst = NetworkTableInstance.getDefault();
        clientInst.setServer("127.0.0.1");
        clientInst.startClient();

        // Set the paths that can be chosen from, and send to Network Tables
        autoPathChooser1.addDefault("Path 1", "path1");
        autoPathChooser1.addOption("Path 2", "path2");
        autoPathChooser1.addOption("Path 3", "path3");
        SmartDashboard.putData("autoPathChooser/first", autoPathChooser1);

        autoPathChooser2.addDefault("Path 4", "path4");
        autoPathChooser2.addOption("Path 5", "path5");
        autoPathChooser2.addOption("Path 6", "path6");
        SmartDashboard.putData("autoPathChooser/second", autoPathChooser2);

        autoPathChooser3.addDefault("Path 7", "path7");
        autoPathChooser3.addOption("Path 8", "path8");
        autoPathChooser3.addOption("Path 9", "path9");
        SmartDashboard.putData("autoPathChooser/third", autoPathChooser3);
    }

    public void autonomousInit() {
        System.out.println("autonomousInit()");
        // Get the values from the SendableChoosers
        System.out.println(String.format("chosen path 1: %s", autoPathChooser1.getSelected()));
        System.out.println(String.format("chosen path 2: %s", autoPathChooser2.getSelected()));
        System.out.println(String.format("chosen path 3: %s", autoPathChooser3.getSelected()));
    }

    public void autonomousPeriodic() {
        System.out.println("autonomousPeriodic()");
        System.out.println(String.format("chosen path 1: %s", autoPathChooser1.getSelected()));
        System.out.println(String.format("chosen path 2: %s", autoPathChooser2.getSelected()));
        System.out.println(String.format("chosen path 3: %s", autoPathChooser3.getSelected()));
    }
}
