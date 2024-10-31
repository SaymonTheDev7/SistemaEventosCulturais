public class Inscricao {

    private int id;
    private Evento evento;
    private Participante participante;

    public Inscricao(int id, Evento eventoId, Participante participanteId) {
        this.id = id;
        this.evento = eventoId;
        this.participante = participanteId;
    }

    public Inscricao(Evento eventoId, Participante participanteId) {
        this.evento = eventoId;
        this.participante = participanteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public String toString () {
        return "\nID da inscrição: " + getId() +
               "\nID do evento: " + getEvento() +
               "\nID do participante: " + getParticipante();
    }
}
