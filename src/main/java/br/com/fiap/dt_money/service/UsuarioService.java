package br.com.fiap.dt_money.service;

import br.com.fiap.dt_money.dto.LoginRequestDTO;
import br.com.fiap.dt_money.dto.UsuarioRequestDTO;
import br.com.fiap.dt_money.model.Banco;
import br.com.fiap.dt_money.model.Usuario;
import br.com.fiap.dt_money.repository.BancoRepository;
import br.com.fiap.dt_money.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BancoRepository bancoRepository;
    private final PasswordEncoder passwordEncoder;



    public UsuarioService(UsuarioRepository usuarioRepository, BancoRepository bancoRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.bancoRepository = bancoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario criar(UsuarioRequestDTO dto) {
        String senhaCriptografada = passwordEncoder.encode(dto.senha());

        Usuario novoUsuario = new Usuario(
                dto.nome(),
                dto.cpf(),
                dto.email(),
                senhaCriptografada,
                dto.sexo(),
                dto.dataNascimento()
        );

        return usuarioRepository.save(novoUsuario);
    }

    public Usuario editar(UUID id, UsuarioRequestDTO dto) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuarioExistente.setNome(dto.nome());
        usuarioExistente.setCpf(dto.cpf());
        usuarioExistente.setEmail(dto.email());
        usuarioExistente.setSexo(dto.sexo());
        usuarioExistente.setDataNascimento(dto.dataNascimento());

        if (dto.senha() != null && !dto.senha().isBlank()) {
            usuarioExistente.setSenhaHash(passwordEncoder.encode(dto.senha()));
        }

        return usuarioRepository.save(usuarioExistente);
    }

    public Usuario autenticar(LoginRequestDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.email()).orElseThrow(() -> new RuntimeException("Credenciais inválidas"));
        if (!passwordEncoder.matches(dto.senha(), usuario.getSenhaHash())) {
            throw new RuntimeException("Credenciais inválidas");
        }
        return usuario;
    }

    public Usuario adicionarBancoAoUsuario(UUID usuarioId, UUID bancoId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Banco banco = bancoRepository.findById(bancoId).orElseThrow(() -> new RuntimeException("Banco não encontrado"));

        if(usuario.getBancos().contains(banco)){
            throw new RuntimeException("O usuário já possui este banco vinculado.");
        }

        usuario.getBancos().add(banco);
        return usuarioRepository.save(usuario);
    }


    public Usuario removerBancoDoUsuario(UUID usuarioId, UUID bancoId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Banco banco = bancoRepository.findById(bancoId).orElseThrow(() -> new RuntimeException("Banco não encontrado"));

        if (usuario.getBancos().contains(banco)) {
            usuario.getBancos().remove(banco);
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Erro: Esse banco não está vinculado ao usuário.");
        }
    }


    public void mostrarUsuario(UUID usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        System.out.println("Usuario: " + usuario.getNome());
        System.out.println("Cpf: " + usuario.getCpf());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Sexo: " + usuario.getSexo());
    }
}
