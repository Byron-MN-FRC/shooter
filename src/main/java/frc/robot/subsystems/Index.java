// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class Index extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private AnalogInput indexAcquiredSensor;
private AnalogInput indexSensor;
private AnalogInput indexToShootSensor;
private WPI_TalonSRX beltMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private boolean indexerRunning = false;

    public Index() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
indexAcquiredSensor = new AnalogInput(0);
addChild("indexAcquiredSensor",indexAcquiredSensor);

        
indexSensor = new AnalogInput(1);
addChild("indexSensor",indexSensor);

        
indexToShootSensor = new AnalogInput(2);
addChild("indexToShootSensor",indexToShootSensor);

        
beltMotor = new WPI_TalonSRX(4);


        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
        if (ballPresent(0) && !indexerRunning) {
            IndexOneBall idxCmd = new IndexOneBall();
            indexerRunning = true;
            idxCmd.start();
        }

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS
    public void testSensor() {
        SmartDashboard.putNumber("is sensor working", indexAcquiredSensor.getValue());
    }

    public boolean ballPresent(int aPort) {
        boolean retValue = false;
        switch (aPort) {
        case 0:
            retValue = (indexAcquiredSensor.getValue() < 500);
            break;
        case 1:
            retValue = (indexSensor.getValue() < 500);
            break;
        case 2:
            retValue = (indexToShootSensor.getValue() < 500);
            break;
        default:
            retValue = false;
            break;
        }
        return retValue;
    }

    public void indexOneBall() {

    }

    public void startIndexerMotor(){
        beltMotor.set(.5);
    }

    public void stopIndexerMotor(){
        beltMotor.set(0);
        indexerRunning = false;
    }
}
