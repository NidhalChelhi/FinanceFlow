package financeflow.models.clients;

import javafx.beans.property.*;
import financeflow.models.enums.InteractionType;

public class ClientInteraction {
    private final IntegerProperty id;
    private final IntegerProperty clientId;
    private final ObjectProperty<InteractionType> interactionType;
    private final StringProperty notes;

    public ClientInteraction(int id, int clientId, InteractionType interactionType, String notes) {
        this.id = new SimpleIntegerProperty(id);
        this.clientId = new SimpleIntegerProperty(clientId);
        this.interactionType = new SimpleObjectProperty<>(interactionType);
        this.notes = new SimpleStringProperty(notes);
    }

    // Property methods
    public IntegerProperty idProperty() { return id; }
    public IntegerProperty clientIdProperty() { return clientId; }
    public ObjectProperty<InteractionType> interactionTypeProperty() { return interactionType; }
    public StringProperty notesProperty() { return notes; }

    // Getters and setters
    public int getId() { return id.get(); }
    public void setId(int id) { this.id.set(id); }
    public int getClientId() { return clientId.get(); }
    public void setClientId(int clientId) { this.clientId.set(clientId); }
    public InteractionType getInteractionType() { return interactionType.get(); }
    public void setInteractionType(InteractionType interactionType) { this.interactionType.set(interactionType); }
    public String getNotes() { return notes.get(); }
    public void setNotes(String notes) { this.notes.set(notes); }
}
