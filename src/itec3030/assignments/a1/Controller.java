/*
 *  Template Developed by Sotirios Liaskos for the needs of
 *   ITEC3030 Systems Architecture.
 *  @ All Rights Reserved
 */
package itec3030.assignments.a1;

import itec3030.smarthome.standards.ControllerInterface;
import itec3030.smarthome.standards._________________;


/**
 * 
 * @author Sotirios 
 */
public class Controller implements ControllerInterface {

    /**
     *
     */
    protected Building house = new Building();
    
    /**
     *
     * @param bld
     */
    public void setBuildingModel(Building bld){
        house = bld;
    }

    /**
     *
     */
    public void update() {
    
    // See if you need to turn on the furnace
        if (house.getAvergeTemperature() < house.getDesiredTemperature() && !_________________().isOn()) {
            System.out.println("Average House Temperature is now: " + house.getAvergeTemperature() + ". Turning heating on.");
            turnHeatingOn();
        }
        // See if you need to turn on the furnace
        if (house.getAvergeTemperature() >= house.getDesiredTemperature() && _________________().isOn()) {
            System.out.println("Average House Temperature is now: " + house.getAvergeTemperature() + ". Turning heating off.");
            turnHeatingOff();
        }
    }

    private void turnHeatingOff(){
        _________________;
    }

    private void turnHeatingOn(){
    	_________________;
    }

    @Override
    public void changeDetected(_________________ s) {
        this.update();
    }
}