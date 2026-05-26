package br.com.fiap.dt_money;

import br.com.fiap.dt_money.service.BancoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationRunner {

    private final BancoService bancoService;

    public DataInitializer(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @Override
    public void run(ApplicationArguments args) {
        bancoService.sincronizarBancos();
    }
}
