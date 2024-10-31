import java.util.Scanner;

public class Executavel {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BancoInscricao.salvarInscricao(inputSubscribe());
    }

    public static Evento inputSaveEvent () {

        System.out.println("Insira o nome do evento: ");
        String nomeEvento = sc.next();

        System.out.println("Insira o local do evento: ");
        String localEvento = sc.next();

        System.out.println("Insira a data do evento: ");
        String dataEvento = sc.next();

        System.out.println("Insira a descição do evento: ");
        String descricaoEvento = sc.next();

        return new Evento(nomeEvento, localEvento, dataEvento, descricaoEvento);

    }

    public static Participante inputParticipant () {

        System.out.println("Insira o nome do participante: ");
        String nomeParticipante = sc.next();

        System.out.println("Insira o E-mail do participante: ");
        String emailParticipante = sc.next();

        return new Participante(nomeParticipante, emailParticipante);

    }

    public static Inscricao inputSubscribe () {

        System.out.println("Insira o nome do evento que deseja inscrever: ");
        String nomeEvento = sc.next();

        System.out.println("Insira o nome do participante que deseja inscrever: ");
        String nomeParticipante = sc.next();

        Evento evento = BancoEvento.buscarPorNome(nomeEvento);
        Participante participante = BancoParticipante.buscarPorNome(nomeParticipante);

        return new Inscricao(evento, participante);


    }

    public static void inputDeleteEvent () {

        System.out.println("Insira o ID do evento que deseja remover: ");
        int id = sc.nextInt();
        BancoEvento.deletarEvento(id);

    }

    public static void inputDeleteParticipant () {

        System.out.println("Insira o ID do participante que deseja remover: ");
        int id = sc.nextInt();
        BancoParticipante.deletarParticipante(id);

    }

    public static String searchEvent () {

        System.out.println("Insira o nome do evento que deseja buscar");
        String nomeEvento = sc.next();
        BancoEvento.buscarPorNome(nomeEvento);
        return nomeEvento;

    }

    public static String searchParticipant () {

        System.out.println("Insira o nome do participante que deseja buscar");
        String nomeParticipante = sc.next();
        BancoParticipante.buscarPorNome(nomeParticipante);
        return nomeParticipante;

    }
}
