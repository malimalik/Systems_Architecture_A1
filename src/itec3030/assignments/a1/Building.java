package itec3030.assignments.a1;
import itec3030.smarthome.standards.Furnace;
import itec3030.smarthome.standards.NumericMeasurementInstrument;
import itec3030.smarthome.standards.OnOffAble;
import itec3030.smarthome.standards.SmartThing;
import java.util.ArrayList;


/**
 * A Room object for maintaining information about the entire building.
 * 
 * @author Sotirios
 */
public class Building {
    private ArrayList<Room> rooms = new ArrayList<Room>();

    // figure out the type for the furnace - it is a type of actuator.
    private Furnace furnace = null;
    private NumericMeasurementInstrument thermostat = null;

    /**
     * Returns the temperature desired by the inhabitants of the building.
     * 
     * @return The desired temperature.
     */
    public int getDesiredTemperature() {
        // a method for thermostat which returns an integer.
        return thermostat.getReading();
    }

    /**
     * Returns a reference to the furnace installed in the building.
     * 
     * @return A reference to the furnace installed in the building.
     */

     // the type for furnace - actuator. 
    public Furnace getFurnace() {
        return furnace;
    }

    /**
     * "Installs" a furnace in the building.
     * 
     * @param frn A reference to the furnace to be installed in the building.
     */

     // the type for the furnace
    public void setFurnace(Furnace frn) {
        furnace = frn;
    }

    /**
     * Returns a reference to the thermostat installed in the building.
     * 
     * @return A reference to the thermostat installed in the building.
     */
    public NumericMeasurementInstrument getThermostat() {
        return thermostat;
    }

    /**
     * "Installs" the thermostat in the building
     * 
     * @param sth Reference to a things that performs numeric measurements.
     */
    public void setThermostat(NumericMeasurementInstrument sth) {
        this.thermostat = sth;
    }

    /**
     * Returns the average temperature in all rooms of the building.
     * 
     * @return Average temperature over all rooms of the building.
     */
    public float getAvergeTemperature() {
        float count = 0, sum = 0;
        for (Room r : rooms) {
            sum += r.getAvergeTemperature();
            count++;
        }
        return (float) (sum / count);
    }

    /**
     * Locates and returns the room in which a SmartThing is installed.
     * 
     * @param s Reference to a SmartThing.
     * @return Reference to the Room in which the SmartThing is installed.
     */
        // type of controller? The smart thing is a type of controller?
    
    public Room findRoomOf( SmartThing s) {
        Room found = null;
        for (Room r : rooms) {
            if (r.hasThing((SmartThing) s))
                found = r;
        }
        return (found);
    }

    //
    // Install Constituent Rooms
    //

    /**
     * Add a room to the building.
     * 
     * @param room Reference to a Room Object.
     */
    public void add(Room room) {
        rooms.add(room);
    }
}