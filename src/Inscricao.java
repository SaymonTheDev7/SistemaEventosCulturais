public class Inscricao {

    private int id;
    private Evento eventoId;
    private Participante participanteId;

    public Inscricao(int id, Evento eventoId, Participante participanteId) {
        this.id = id;
        this.eventoId = eventoId;
        this.participanteId = participanteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Evento getEventoId() {
        return eventoId;
    }

    public void setEventoId(Evento eventoId) {
        this.eventoId = eventoId;
    }

    public Participante getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(Participante participanteId) {
        this.participanteId = participanteId;
    }

    public String toString () {
        return "\nID da inscrição: " + getId() +
               "\nID do evento: " + getEventoId() +
               "\nID do participante: " + getParticipanteId();
    }
}
