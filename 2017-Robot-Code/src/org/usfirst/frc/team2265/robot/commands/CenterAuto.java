package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterAuto extends CommandGroup {
	public static double d;
    public CenterAuto() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addSequential(new DriveDistance(24.0, 0.65));
    	
      	addSequential(new AutoAlign());
     
    	addSequential(new DriveToPeg(0.4));
    	
    	addSequential(new ShiftChute(false));
    	
    	addSequential(new DriveDistanceBack(-12, -0.4));
    	addSequential(new ShiftChute(true));
    	//addSequential(new TurnDegrees(60));
    	//addSequential(new DriveDistance(60, 0.5));
    }
}