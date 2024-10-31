import java.sql.*;
import java.util.Scanner;

public class BancoInscricao {

    private static Scanner sc = new Scanner(System.in);

    public static Inscricao salvarInscricao ( Inscricao inscricao ) {

        try (Connection connection = ConexaoBanco.getConnections()) {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO tb_inscricao (evento, participante) VALUES " + "(?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, inscricao.getEvento().getId());
            ps.setInt(2, inscricao.getParticipante().getId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                inscricao.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inscricao;

    }
}
