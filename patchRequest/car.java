

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The {@code car} class represents a car with a name and associated data.
 * It includes only non-null fields when serialized to JSON.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class car {
    private String name;
    private HashMap<String, Object> data;

    public car() {
        //TODO Auto-generated constructor stub
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
