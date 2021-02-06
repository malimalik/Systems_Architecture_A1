/*
 *  Template Developed by Sotirios Liaskos for the needs of
 *   ITEC3030 Systems Architecture.
 *  @ All Rights Reserved
 */
package itec3030.assignments.a1;

import itec3030.smarthome.standards.Furnace;
import itec3030.smarthome.standards.NumericMeasurementInstrument;
import itec3030.smarthome.standards.TemperatureSensor;

import itec3030.assignments.a1.sensors.omnitemp.OmniTempSensorXS3;
import itec3030.assignments.a1.sensors.thermoset.ThermoSetX19.ThermosetX19;
import itec3030.assignments.a1.actuators.saharah.SaharaFurnaceHL42;
/**
 *
 * @author Sotirios
 */
public class Main {
    Main p = new Main();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller c = new Controller();
  

                
        //Create Building
        Building h = new Building();
        Room livingRoom = new Room();
        Room bedRoom = new Room();
        livingRoom.setName("Living Room");
        bedRoom.setName("Bedroom");
        h.add(livingRoom);
        h.add(bedRoom);
        
        
        TemperatureSensor o1 = new OmniTempSensorXS3(c,"o1");
        TemperatureSensor o2 = new OmniTempSensorXS3(c,"o2");
        TemperatureSensor o3 = new OmniTempSensorXS3(c,"o3");
        TemperatureSensor o4 = new OmniTempSensorXS3(c,"o4");
        Furnace f = new SaharaFurnaceHL42("f");
        NumericMeasurementInstrument th = new QuickThermostat();
 
        
        livingRoom.install(o1);
        livingRoom.install(o2);
        bedRoom.install(o3);
        bedRoom.install(o4);

        h.setFurnace(f);
        h.setThermostat(th);
        c.setBuildingModel(h);
        
        
        // Part 2
        Scenario e = new Scenario(o1,o2,o3,o4);
        e.play();
        
        
        // Part 3 - uncomment to execute
        th = new ThermosetX19();
        h.setThermostat(th);
        e = new Scenario(o1,o2,o3,o4);
        e.play();
        
    }
}