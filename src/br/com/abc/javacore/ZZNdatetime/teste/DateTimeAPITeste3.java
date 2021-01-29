package br.com.abc.javacore.ZZNdatetime.teste;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DateTimeAPITeste3 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2017, Month.FEBRUARY, 25);
        System.out.println(localDate);
        // Não é possível alterar algum dado do mesmo objeto que você fez, você precisa
        // criar um novo e atribuí-lo a mesma variavel

        // withYear(): muda o ano de uma deteminada data
        localDate = localDate.withYear(2020);
        System.out.println(localDate);
        // withMonth(): muda o mês de uma deteminada data (precisa do getValue() depois)
        localDate = localDate.withMonth(Month.AUGUST.getValue());
        System.out.println(localDate);
        // withDayOfMonth(): muda o dia do mês de uma deteminada data
        localDate = localDate.withDayOfMonth(20);
        System.out.println(localDate);

        // with(): uma outra forma de fazer as mudanças acima
        localDate = localDate.with(ChronoField.MONTH_OF_YEAR, 10);
        System.out.println(localDate);

        // Métodos plus(): incrementa a unidade desejada
        localDate = localDate.plusMonths(5);
        System.out.println(localDate);
        localDate = localDate.plus(6, ChronoUnit.MONTHS);
        System.out.println(localDate);

        // Métodos minus(): ao incrementar um período de tempo, também retira uma parte
        localDate = localDate.plusMonths(2).minusDays(5);
        System.out.println(localDate);

        // Os métodos with(), plus() e minus() também funcionam para LocalTime
        LocalTime time = LocalTime.now();
        System.out.println(time);
        time = time.withHour(10);
        System.out.println(time);
        time = time.plusHours(15);
        System.out.println(time);
        time = time.plusHours(15).minusMinutes(30);
        System.out.println(time);


    }
}
