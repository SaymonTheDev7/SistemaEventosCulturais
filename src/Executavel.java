import java.sql.SQLException;
import java.util.Scanner;

public class Executavel {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        System.out.println("Bem vindo ao sistema de gerenciamento de eventos.");

        int opcaoEscolha = 0;
        while ( opcaoEscolha != 1) {

            System.out.println("1. Login");
            System.out.println("0. Logout");
            opcaoEscolha = sc.nextInt();

            if ( opcaoEscolha == 0 ) {
                System.out.println("Sistema sendo finalizado.");
                System.exit(0);
            }

            else {

                String user = "Saymon";
                String password = "@Saymon7";

                System.out.println("Insira o login:");
                user = sc.next();

                System.out.println("Insira a senha do login:");
                password = sc.next();


                if ( !password.equals("@Saymon7")) {

                    System.out.println("Senha incorreta, você tem mais 2 tentativas");

                    System.out.println("Insira a senha do login:");
                    password = sc.next();

                    if ( !password.equals("@Saymon7")) {

                        System.out.println("Senha incorreta, você tem mais 1 tentativa");

                        System.out.println("Insira a senha do login:");
                        password = sc.next();

                        if ( !password.equals("@Saymon7")) {

                            System.out.println("Sistema finalizado por segurança.");
                            System.exit(0);
                        }
                    }
                }

                while (true) {

                    System.out.println("Menu de escolhas:");
                    System.out.println("1.Adicionar evento:");
                    System.out.println("2.Buscar evento por nome:");
                    System.out.println("3.Remover evento:");
                    System.out.println("4.Adicionar participante:");
                    System.out.println("5.Buscar participante por E-Mail:");
                    System.out.println("6.Remover participante:");
                    System.out.println("7.Inscrever participante:");
                    System.out.println("8.Remover participante:");
                    System.out.println("0.Logout:");
                    int escolhaMenuEscolhas = sc.nextInt();

                    switch (escolhaMenuEscolhas) {

                        case 0: {

                            System.out.println("Obrigado, volte sempre!");

                        }

                        break;

                        case 1: {

                            BancoEvento.salvarEvento(inputSaveEvent());
                            System.out.println("Evento cadastrado com sucesso.");

                        }

                        break;

                        case 2: {

                            BancoEvento.buscarPorNome(searchEvent());

                        }

                        break;

                        case 3: {

                            inputDeleteEvent();
                            System.out.println("Evento deletado com sucesso");

                        }

                        break;

                        case 4: {

                            BancoParticipante.salvarParticipante(inputParticipant());
                            System.out.println("Participante cadastrado com sucesso.");

                        }

                        break;

                        case 5: {

                            BancoParticipante.buscarPorNome(searchParticipant());

                        }

                        break;

                        case 6: {

                            inputDeleteParticipant();
                            System.out.println("Participante deletado com sucesso.");

                        }

                        break;

                        case 7: {

                            BancoInscricao.salvarInscricao(inputSubscribe());
                            System.out.println("Inscrição adicionada com sucesso.");

                        }

                        case 8: {

                            inputDeleteSubscribe();
                            System.out.println("Inscrição deletada com sucesso");

                        }
                    }
                }
            }
        }
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

    public static void inputDeleteSubscribe () {

        System.out.println("Insira o ID da inscrição que deseja remover: ");
        int id = sc.nextInt();
        BancoInscricao.deletarInscricao(id);

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
