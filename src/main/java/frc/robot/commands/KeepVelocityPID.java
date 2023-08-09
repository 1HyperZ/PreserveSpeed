package frc.robot.commands;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ChassisSubsystem;

public class KeepVelocityPID  extends CommandBase{

    private ChassisSubsystem chassis;
    private int counts;
    private double velocity = 0;
    private double returnVelocity0(){
        return velocity;
    }
    public double getVelocity(){
        return ((chassis.leftFrontMotor.getSelectedSensorVelocity() + 
        chassis.rightFrontMotor.getSelectedSensorVelocity()) / 2) / (Constants.motorCountsPerMeter / 10);

    }
    private void setVelocity(double velocity){
        this.velocity = velocity;
    }

    public KeepVelocityPID(ChassisSubsystem chassis){
        this.chassis = chassis;
        addRequirements(chassis);
        SmartDashboard.putData(this);
    }

    @Override
    public void initialize() {
        counts = 0;
        chassis.setVelocity(velocity, velocity);
        chassis.leftFrontMotor.config_kP(0, Constants.KP);
        chassis.rightFrontMotor.config_kP(0, Constants.KP);
        chassis.leftFrontMotor.config_kI(0, Constants.KI);
        chassis.rightFrontMotor.config_kI(0, Constants.KI);
        chassis.leftFrontMotor.config_kD(0, Constants.KD);
        chassis.rightFrontMotor.config_kD(0, Constants.KD);
    }
    
    @Override
    public boolean isFinished() {
        counts++;
        return counts > 150;
    }
    @Override
    public void end(boolean interrupted) {
        chassis.setPower(0, 0);
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("Set Velocity", this::returnVelocity0, this::setVelocity);
        builder.addDoubleProperty("Realtime Velocity", this::getVelocity, null);
    }
    
}
