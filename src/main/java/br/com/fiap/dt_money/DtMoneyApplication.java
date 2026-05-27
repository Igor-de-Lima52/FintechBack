package br.com.fiap.dt_money;

import br.com.fiap.dt_money.repository.BancoRepository;
import br.com.fiap.dt_money.service.BancoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DtMoneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DtMoneyApplication.class, args);
	}

	@Bean
	public CommandLineRunner initBancos(BancoRepository repository, BancoService service) {
		return args -> {
			if (repository.count() == 0) {
				System.out.println("Banco de dados vazio de bancos. Sincronizando bancos a partir da Brasil API...");
				try {
					service.sincronizarBancos();
					System.out.println("Bancos sincronizados com sucesso!");
				} catch (Exception e) {
					System.err.println("Erro ao sincronizar bancos na inicialização: " + e.getMessage());
				}
			}
		};
	}
}
