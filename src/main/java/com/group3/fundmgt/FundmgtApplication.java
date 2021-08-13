package com.group3.fundmgt;


import com.group3.fundmgt.fund.Fund;
import com.group3.fundmgt.fund.FundRepository;

import com.group3.fundmgt.Securities.Security;
import com.group3.fundmgt.Securities.SecurityRepository;

import com.group3.fundmgt.manager.Manager;
import com.group3.fundmgt.manager.ManagerRepository;
import com.group3.fundmgt.position.Position;
import com.group3.fundmgt.position.PositionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FundmgtApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundmgtApplication.class, args);
    }

    @Bean

    CommandLineRunner commandLineRunner(ManagerRepository managerRepository, PositionRepository positionRepository, SecurityRepository securityRepository,FundRepository fundRepository) {

        return args -> {
            /*存入2个manager*/
            List<Manager> managers = List.of(
                    new Manager("Chris", "Gardner", new ArrayList<>()),
                    new Manager("Frank", "Abagnale", new ArrayList<>())
            );
            managerRepository.saveAll(managers);


            List<Fund> funds=List.of(
                    new Fund("technology select",new ArrayList<>(), managers.get(0)),
                    new Fund("industrial select",new ArrayList<>(), managers.get(0))
            );
            fundRepository.saveAll(funds);

            /*存入2个position*/
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            List<Position> positions=List.of(
                    new Position("TSLA",100, LocalDate.parse("2021-08-11",dtf),funds.get(0)),
                    new Position("FB", 150, LocalDate.parse("2021-08-08",dtf),funds.get(0))
            );
            positionRepository.saveAll(positions);

            List<Security> securities = List.of(
                    new Security( "TSLA"),
                    new Security( "FB"),
                    new Security( "NFLX")
            );
            securityRepository.saveAll(securities);

        };
    }

}
