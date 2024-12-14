package financeflow.models.employees;

import javafx.beans.property.*;

public class Branch {
    private final IntegerProperty id;
    private final StringProperty name;
    private final StringProperty location;
    private final IntegerProperty managerId;

    public Branch(int id, String name, String location, int managerId) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.location = new SimpleStringProperty(location);
        this.managerId = new SimpleIntegerProperty(managerId);
    }

    // Property methods
    public IntegerProperty idProperty() { return id; }
    public StringProperty nameProperty() { return name; }
    public StringProperty locationProperty() { return location; }
    public IntegerProperty managerIdProperty() { return managerId; }

    // Getters and setters
    public int getId() { return id.get(); }
    public void setId(int id) { this.id.set(id); }
    public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }
    public String getLocation() { return location.get(); }
    public void setLocation(String location) { this.location.set(location); }
    public int getManagerId() { return managerId.get(); }
    public void setManagerId(int managerId) { this.managerId.set(managerId); }
}
