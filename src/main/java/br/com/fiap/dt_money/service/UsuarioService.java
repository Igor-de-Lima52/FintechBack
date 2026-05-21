package br.com.fiap.dt_money.service;

import br.com.fiap.dt_money.model.Banco;
import br.com.fiap.dt_money.model.Usuario;
import br.com.fiap.dt_money.repository.BancoRepository;
import br.com.fiap.dt_money.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BancoRepository bancoRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, BancoRepository bancoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.bancoRepository = bancoRepository;
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
