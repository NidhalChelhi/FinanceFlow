package financeflow.models.clients;

import javafx.beans.property.*;
import financeflow.models.enums.ClientType;

public class Client {
    private final IntegerProperty id;
    private final StringProperty name;
    private final StringProperty email;
    private final StringProperty phone;
    private final StringProperty address;
    private final ObjectProperty<ClientType> type;

    public Client(int id, String name, String email, String phone, String address, ClientType type) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.address = new SimpleStringProperty(address);
        this.type = new SimpleObjectProperty<>(type);
    }

    // Property methods
    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public StringProperty addressProperty() {
        return address;
    }

    public ObjectProperty<ClientType> typeProperty() {
        return type;
    }

    // Getters and setters
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public ClientType getType() {
        return type.get();
    }

    public void setType(ClientType type) {
        this.type.set(type);
    }
}
