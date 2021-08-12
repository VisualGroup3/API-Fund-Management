package com.group3.fundmgt;

import com.group3.fundmgt.Securities.Security;
import com.group3.fundmgt.Securities.SecurityRepository;
import com.group3.fundmgt.manager.Manager;
import com.group3.fundmgt.manager.ManagerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@SpringBootApplication
public class FundmgtApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundmgtApplication.class, args);
    }

    @Bean

    CommandLineRunner commandLineRunner(ManagerRepository managerRepository, SecurityRepository securityRepository) {
        return args -> {
            List<Manager> managers = List.of(
                    new Manager(1, "Chris", "Gardner"),
                    new Manager(2, "Frank", "Abagnale")
            );
            managerRepository.saveAll(managers);
            List<Security> securities = List.of(
                    new Security(1, "Chris"),
                    new Security(2, "Frank"),
                    new Security(3, "like")
            );
            securityRepository.saveAll(securities);
        };
    }

}
