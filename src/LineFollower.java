
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;

public class LineFollower  { 
 static EV3MediumRegulatedMotor motorA = new EV3MediumRegulatedMotor(MotorPort.B);	//left
 static EV3MediumRegulatedMotor motorB = new EV3MediumRegulatedMotor(MotorPort.C);	//right
static EV3ColorSensor lightA = new EV3ColorSensor(SensorPort.S1);						//left
static EV3ColorSensor lightB = new EV3ColorSensor(SensorPort.S3);						//right
 
 public static void main (String[] args) {
   int ki = 0;
   int kp = 300;
   int kd  = 0;
   
   int Tp = 200; 			//starting speed
   float integral = 0;
   float lastError = 0;
   float derivative = 0;
   int i = 0;
   int colA = lightA.getColorID();
   int colB = lightB.getColorID();

   while (true) {
	  
	  SensorMode LightValueA = lightA.getRedMode();			//read color from the left sensor
	  float[] valueA = new float[LightValueA.sampleSize()];
	  LightValueA.fetchSample(valueA, 0);
      
	  SensorMode LightValueB = lightB.getRedMode();			//read color from the right sensor
	  float[] valueB = new float[LightValueB.sampleSize()];
	  LightValueB.fetchSample(valueB, 0);
     
	  float error =  valueA[0] - valueB[0];
	  integral = integral + error;
	   
	  derivative  = error - lastError;
	  float Turn = kp*error + ki*integral + kd*derivative;
	  
	  float powerA = (Tp - Turn);
	  float powerB = (Tp + Turn);
	  lastError = error;
	  
	  motorA.setSpeed((int) powerA);
	  motorB.setSpeed((int) powerB);
     
	  motorA.forward();
	  motorB.forward();
     
     i++;
     if (i == 200000) {							//number of iterations. How many times car will ride
        return;
     }
   }
 }
}
