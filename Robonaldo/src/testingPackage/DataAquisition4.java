package testingPackage;
import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
/**
 * Robonaldo instantiates all the threads and operations required at start-up of the program.
 * The initial parameters fed into the robot will be received in this class and be passed along to the rest of
 * the system. 
 */
public class DataAquisition4 {
	
	public static final EV3LargeRegulatedMotor loadMotor = new EV3LargeRegulatedMotor(LocalEV3.get().getPort("A"));
	public static final EV3LargeRegulatedMotor launchMotor = new EV3LargeRegulatedMotor(LocalEV3.get().getPort("D"));
	
	
	public static final EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(LocalEV3.get().getPort("B"));
	public static final EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(LocalEV3.get().getPort("C"));
	
	public static double WIDTH = 18.2;
	public static double RIGHT_RADIUS = 2.072;
	public static double LEFT_RADIUS = 2.072;
	
	private final static int FAST = 200, SLOW = 100, REGULAR = 160, SMOOTH = 6000, DEFAULT = 6000; 

	
	
	//MAIN METHOD
	public static void main(String[] args){
		/*
		Odometer odo = new Odometer(leftMotor, rightMotor);
		Screen screen = new Screen(odo);
		odo.start();
		screen.start();*/
		
		leftMotor.setAcceleration(SMOOTH);
		rightMotor.setAcceleration(DEFAULT);
		leftMotor.setSpeed(120); rightMotor.setSpeed(120);
		
		leftMotor.rotate(-convertDistanceRight(RIGHT_RADIUS, 300), true);
		rightMotor.rotate(-convertDistanceLeft(LEFT_RADIUS, 300), false);
		
		
		
		/*
		for(int k=0; k<4; k++){
			//leftMotor.setAcceleration(SLOW);rightMotor.setAcceleration(SLOW);
			rightMotor.rotate(-convertDistance(RADIUS, 60.48), true);
			leftMotor.rotate(-convertDistance(RADIUS, 60.48), false);
			//rightMotor.rotate(-convertDistance(RADIUS, 60.48), false);
			
			//leftMotor.setAcceleration(DEFAULT);rightMotor.setAcceleration(DEFAULT);
			leftMotor.rotate(-convertAngle(RADIUS, WIDTH, Math.PI/2), true);
			rightMotor.rotate(convertAngle(RADIUS, WIDTH, Math.PI/2), false);

		}*/
		
	
		/*loadMotor.setSpeed(120);
		loadMotor.rotateTo(-110);
		loadMotor.stop();
		launchMotor.setAcceleration(2000000000);
		launchMotor.setSpeed(200);
		launchMotor.rotate(360);
		
		
		
		int button = Button.waitForAnyPress();
		while(button == Button.ID_ENTER){
			launchMotor.stop();
			loadMotor.setAcceleration(150);			
			loadMotor.rotateTo(110);
			loadMotor.setSpeed(70);
			loadMotor.rotateTo(-110);
			loadMotor.stop();
			
			try{
				Thread.sleep(2000);
			}catch(Exception e){};
			
			launchMotor.setSpeed(700);
			launchMotor.rotate(-300);
			button = Button.waitForAnyPress();
			launchMotor.rotateTo(300);
		}*/
		
		
		
		
	}
	
	
	/*private static int convertAngle(double radius, double width, double angle) {
		return convertDistance(radius, width * angle / 2);
	}*/
	
	private static int convertDistanceRight(double rightRadius, double distance) {
		return (int) ((180.0 * distance) / (Math.PI * rightRadius));
	}
	
	private static int convertDistanceLeft(double leftRadius, double distance) {
		return (int) ((180.0 * distance) / (Math.PI * leftRadius));
	}
	
	public static EV3LargeRegulatedMotor[] getMotors(){
		EV3LargeRegulatedMotor[] m = {leftMotor, rightMotor};
		return m;
	}
}
