package com.group3.fundmgt;


import com.group3.fundmgt.fund.Fund;
import com.group3.fundmgt.fund.FundAssetValue;
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

import java.math.BigDecimal;
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

//            List list=fundRepository.getValueGroupByAssetClass("GF001");
//            List<FundAssetValue> fundAssetValueList=new ArrayList<>();
//            for(Object row:list){
//                FundAssetValue fundAssetValue=new FundAssetValue();
//                Object[] cells = (Object[]) row;
//                fundAssetValue.setAssetClass(String.valueOf(cells[1]));
//                BigDecimal bigDecimal=new BigDecimal(String.valueOf(cells[0]));
//                fundAssetValue.setValue(bigDecimal.longValue());
//                System.out.println(fundAssetValue);
//            }
//            /*存入manager*/
//            List<Manager> managers = List.of(
//                    new Manager("CG1111","Chris", "Gardner","939015806@qq.com",new ArrayList<>())
//            );
//            managerRepository.saveAll(managers);
//
//
//            List<Fund> funds=List.of(
//                    new Fund("technology select sector fund",new ArrayList<>(), managers.get(0)),
//                    new Fund( "communication services select sector fund",new ArrayList<>(), managers.get(0)),
//                    new Fund( "industrial select sector fund",new ArrayList<>(), managers.get(1))
//
//            );
//            fundRepository.saveAll(funds);
//
//            /*存入2个position*/
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            List<Position> positions=List.of(
//                    new Position("TSLA",100, LocalDate.parse("2021-08-11",dtf),funds.get(0)),
//                    new Position("FB", 150, LocalDate.parse("2021-08-08",dtf),funds.get(0)),
//                    new Position("NFLX", 200, LocalDate.parse("2021-08-09",dtf),funds.get(1)),
//                    new Position("NFLX", 150, LocalDate.parse("2021-08-10",dtf),funds.get(1)),
//                    new Position("GE", 50, LocalDate.parse("2021-08-10",dtf),funds.get(2))
//            );
//            positionRepository.saveAll(positions);
//
//            List<Security> securities = List.of(
//                    new Security( "TSLA"),
//                    new Security("FB"),
//                    new Security( "NFLX"),
//                    new Security( "GE")
//            );
//            securityRepository.saveAll(securities);

        };
    }

}
