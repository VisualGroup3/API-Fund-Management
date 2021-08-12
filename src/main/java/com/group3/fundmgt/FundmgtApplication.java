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
                    new Manager(1L, "Chris", "Gardner"),
                    new Manager(2L, "Frank", "Abagnale")
            );
            managerRepository.saveAll(managers);


            List<Fund> funds=List.of(
                    new Fund(Long.valueOf(1),"111",new ArrayList<>()),
                    new Fund(Long.valueOf(2), "222",new ArrayList<>())
            );
            fundRepository.saveAll(funds);

            List<Security> securities = List.of(
                    new Security(1, "Chris"),
                    new Security(2, "Frank"),
                    new Security(3, "like")
            );
            securityRepository.saveAll(securities);

            /*存入2个position*/
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            List<Position> positions=List.of(
                    new Position(Long.valueOf(1),100, LocalDate.parse("2021-08-11",dtf),funds.get(0)),
                    new Position(Long.valueOf(2), 150, LocalDate.parse("2021-08-08",dtf),funds.get(1))
            );
            positionRepository.saveAll(positions);
        };
    }

}
