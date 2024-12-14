package financeflow.models.employees;

import financeflow.models.enums.Role;
import javafx.beans.property.*;

public class Employee {
    private final IntegerProperty id;
    private final StringProperty name;
    private final StringProperty email;
    private final StringProperty phone;
    private final ObjectProperty<Role> role;
    private final IntegerProperty branchId;

    public Employee(int id, String name, String email, String phone, Role role, int branchId) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.role = new SimpleObjectProperty<>(role);
        this.branchId = new SimpleIntegerProperty(branchId);
    }

    // Property methods
    public IntegerProperty idProperty() { return id; }
    public StringProperty nameProperty() { return name; }
    public StringProperty emailProperty() { return email; }
    public StringProperty phoneProperty() { return phone; }
    public ObjectProperty<Role> roleProperty() { return role; }
    public IntegerProperty branchIdProperty() { return branchId; }

    // Getters and setters
    public int getId() { return id.get(); }
    public void setId(int id) { this.id.set(id); }
    public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }
    public String getEmail() { return email.get(); }
    public void setEmail(String email) { this.email.set(email); }
    public String getPhone() { return phone.get(); }
    public void setPhone(String phone) { this.phone.set(phone); }
    public Role getRole() { return role.get(); }
    public void setRole(Role role) { this.role.set(role); }
    public int getBranchId() { return branchId.get(); }
    public void setBranchId(int branchId) { this.branchId.set(branchId); }
}
