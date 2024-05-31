

import java.util.HashMap;

/**
 * The {@code car} class represents a car with a name and associated data.
 */
public class car {
    private String name;
    private HashMap<String, Object> data;

    /**
     * Constructs a new {@code car} instance with the specified name and data.
     *
     * @param name the name of the car
     * @param data a HashMap containing additional data about the car
     */
    public car(String name, HashMap<String, Object> data) {
        this.name = name;
        this.data = data;
    }

    /**
     * Returns the name of the car.
     *
     * @return the name of the car
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the car.
     *
     * @param name the new name of the car
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the data associated with the car.
     *
     * @return a HashMap containing the car's data
     */
    public HashMap<String, Object> getData() {
        return data;
    }

    /**
     * Sets the data associated with the car.
     *
     * @param data a HashMap containing the new data for the car
     */
    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
}
