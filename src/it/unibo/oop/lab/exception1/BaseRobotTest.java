package it.unibo.oop.lab.exception1;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;


/**
 * Testing class for PositionOutOfBound.
 * 
 */
public final class BaseRobotTest {
	
	private static final int TEST_BATTERY_LEVEL = 20;

    /**
     * Simple test for testing a robot moving, wandering the available
     * environment.
     * 
     */
    @Test
    public void testRobotMovementBase() {
        /*
         * FIRST OF ALL, take a look to "TestWithExceptions". Read the source and the
         * comments very carefully.
         */
        /*
         *  1) Create a Robot with battery level 100
         */
        final Robot r1 = new Robot("SimpleRobot", 100);
        // checking if robot is in position x=0; y=0
        assertEquals("[CHECKING ROBOT INIT POS X]", 0, r1.getEnvironment().getCurrPosX());
        assertEquals("[CHECKING ROBOT INIT POS Y]", 0, r1.getEnvironment().getCurrPosY());
        
        /*
         * 2) Move the robot right until it touches the world limit
         */
        try {
        	//Reach world limit.
            for (int i = 0; i < RobotEnvironment.WORLD_X_UPPER_LIMIT; i++) {
                r1.moveRight();
            }
            
            //Do the illegal movement.
            r1.moveRight();
            
            // Shouldn't do this.
            Assert.fail("Robot shouldn't get this far.");
        } catch (PositionOutOfBoundException e) {
        	// checking positions x=50; y=0
        	assertTrue(e.getMessage().contains("pos(" + (RobotEnvironment.WORLD_X_UPPER_LIMIT + 1) + ", 0)"));
        }
        
        /*
         * 2) Move the robot right until it touches the world limit
         */
        try {
        	//Reach world limit.
            for (int i = 0; i < RobotEnvironment.WORLD_X_UPPER_LIMIT; i++) {
                r1.moveUp();
            }
            
            //Do the illegal movement.
            r1.moveUp();
            
            // Shouldn't do this.
            Assert.fail("Robot shouldn't get this far.");
        } catch (PositionOutOfBoundException e) {
        	// checking positions x=50; y=0
        	assertNotNull(e.getMessage());
        }
    }

    /**
     * Simple test for testing robot battery.
     * 
     */
    @Test
    public void testRobotBatteryBase() {
        final Robot r2 = new Robot("SimpleRobot2", TEST_BATTERY_LEVEL);
        /*
         * Repeatedly move the robot up and down until the battery is completely
         * exhausted.
         */
        try {
            while (r2.getBatteryLevel() > 0) {
                r2.moveUp();
                r2.moveDown();
            }
            r2.moveDown();
            Assert.fail("You're not supposed to get that far with no battery!");
        } catch (PositionOutOfBoundException e) {
        	Assert.fail("I expected battery to fail!");
        } catch (NotEnoughBatteryException e) {
            assertTrue(e.getMessage().contains(" Battery level is " + r2.getBatteryLevel()));
        }
    }
}
