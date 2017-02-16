package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
// auto aligning 0 = not aligning, auto aligning 1 = currently aligning, auto aligning 2 = done aligning
public class CameraAuto extends Command {
	boolean done = false;

	public CameraAuto() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.autoAlign();
		Robot.autoAligning = 1; // auto aligning
		Robot.connectArduino();
		done = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return done;

	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.autoAligning = 2;//done auto aligning
		Robot.connectArduino();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		done = true;
		Robot.autoAligning = 0; 
		Robot.connectArduino();
	}

}