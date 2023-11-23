import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Classe abstrata para representar um usuário genérico
abstract class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    protected String sexo;
    protected String nacionalidade;

    public Usuario(String nome, String email, String senha, String sexo, String nacionalidade) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.sexo = sexo;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getSexo() {
        return sexo;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }
}

// Interface para definir operações de amizade
interface Amigo {
    void adicionarAmigo(Usuario amigo);

    void removerAmigo(Usuario amigo);

    void listarAmigos();
}

// Classe concreta que representa um usuário da rede social
class UsuarioRedeSocial extends Usuario implements Amigo {
    private List<Usuario> amigos;
    private Map<Usuario, List<String>> mensagens;

    public UsuarioRedeSocial(String nome, String email, String senha, String sexo, String nacionalidade) {
        super(nome, email, senha, sexo, nacionalidade);
        amigos = new ArrayList<>();
        mensagens = new HashMap<>();
    }

    @Override
    public void adicionarAmigo(Usuario amigo) {
        amigos.add(amigo);
    }

    @Override
    public void removerAmigo(Usuario amigo) {
        amigos.remove(amigo);
    }

    @Override
    public void listarAmigos() {
        if (amigos.isEmpty()) {
            System.out.println("Você não tem amigos.");
        } else {
            System.out.println("Amigos:");
            for (Usuario amigo : amigos) {
                System.out.println("- " + amigo.getNome());
            }
        }
    }

    public void enviarMensagem(Usuario amigo, String mensagem) {
        if (amigos.contains(amigo)) {
            List<String> conversa = mensagens.getOrDefault(amigo, new ArrayList<>());
            conversa.add(mensagem);
            mensagens.put(amigo, conversa);
            System.out.println("Mensagem enviada para " + amigo.getNome() + ": " + mensagem);
        } else {
            System.out.println(amigo.getNome() + " não é seu amigo.");
        }
    }

    public void listarMensagens(Usuario amigo) {
        List<String> conversa = mensagens.get(amigo);
        if (conversa != null) {
            System.out.println("Conversa com " + amigo.getNome() + ":");
            for (String mensagem : conversa) {
                System.out.println("- " + mensagem);
            }
        } else {
            System.out.println("Você não tem conversa com " + amigo.getNome());
        }
    }
}

// Classe que representa o sistema da rede social
class SistemaRedeSocial {
    private List<UsuarioRedeSocial> usuariosCadastrados;
    private UsuarioRedeSocial usuarioLogado;

    public SistemaRedeSocial() {
        usuariosCadastrados = new ArrayList<>();
    }

    public void cadastrarUsuario() {
        String nome = JOptionPane.showInputDialog("Nome:");
        String email = JOptionPane.showInputDialog("E-mail:");
        String senha = JOptionPane.showInputDialog("Senha:");
        String sexo = JOptionPane.showInputDialog("Sexo:");
        String nacionalidade = JOptionPane.showInputDialog("Nacionalidade:");

        UsuarioRedeSocial usuario = new UsuarioRedeSocial(nome, email, senha, sexo, nacionalidade);
        usuariosCadastrados.add(usuario);

        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
    }

    public void realizarLogin() {
        String email = JOptionPane.showInputDialog("E-mail:");
        String senha = JOptionPane.showInputDialog("Senha:");

        for (UsuarioRedeSocial usuario : usuariosCadastrados) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario;
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Usuário ousenha incorretos. Tente novamente.");
    }

    public void menuPrincipal() {
        JFrame frame = new JFrame("Rede Social");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(2, 1));

        JButton cadastrarUsuarioButton = new JButton("Cadastrar Usuário");
        cadastrarUsuarioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });

        JButton realizarLoginButton = new JButton("Realizar Login");
        realizarLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });

        frame.add(cadastrarUsuarioButton);
        frame.add(realizarLoginButton);

        frame.setVisible(true);
    }
}

// Classe principal que inicia o sistema da rede social
public class Main {
    public static void main(String[] args) {
        SistemaRedeSocial sistema = new SistemaRedeSocial();
        sistema.menuPrincipal();
    }
}