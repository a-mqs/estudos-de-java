package br.com.abc.javacore.ZZNdatetime.teste;

import br.com.abc.javacore.Gassociacao.Classes.Seminarios.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 * API DATETIME
 * As classes Date e Calendar do Java não sanavam totalmente os problemas dos
 * desenvolvedores, o que obrigava eles a procurarem APIs de tempo de terceiros.
 * Uma das melhores dessas foi a JTime. Na versão 8, o Java lançou a API DateTime,
 * com muitos dos métodos da JTime.
 */

public class DateTimeAPITeste1 {
    public static void main(String[] args) {
        /**
         * LocalDate: classe para trabalhar direto com datas
         */
        LocalDate date = LocalDate.of(2019, Month.JULY, 24);

        // getYear(): para pegar o ano
        System.out.println(date.getYear());
        // getMonth(): para pegar o mês
        System.out.println(date.getMonth());
        // getDayOfMonth(): para pegar o dia do mês
        System.out.println(date.getDayOfMonth());
        // getDayOfWeek(): para pegar o dia da semana
        System.out.println(date.getDayOfWeek());
        // getDayOfYear(): para pegar o dia do ano
        System.out.println(date.getDayOfYear());
        // lenghtOfMonth(): para pegar quantos dias tem o mês
        System.out.println(date.lengthOfMonth());
        // isLeapYear(): para saber se é ano bissexto ou não
        System.out.println(date.isLeapYear());

        // Outra forma de fazer isso é usando a interface ChronoField
        System.out.println(date.get(ChronoField.YEAR));
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));

        // Para pegar a data de hoje (o interessante desse formato é que ele é humanamente legível
        // e daria pra mandar pro banco de dados sem complicações, se quisessemos)
        System.out.println(LocalDate.now());

        // Temos também as datas minimas e máximas que podemos colocar
        // (que não é mais limitado a 1970 como a Date e Calendar)
        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.MIN);

        System.out.println("----------------------------------------------");

        /**
         * LocalTime: classe para trabalhar direto com horas
         */
        LocalTime time = LocalTime.of(22, 2, 15);
        System.out.println(time);
        // Da mesma forma temos os gets() respectivos para hora, minuto e segundo
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
        // E as possibilidades mínimas e máximas de horarios
        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIN);

        System.out.println("----------------------------------------------");

        // Parse de datas e horas String para Objetos Java
        LocalDate parseDate = LocalDate.parse("2023-06-25");
        LocalTime parseTime = LocalTime.parse("19:06:25");
        System.out.println(parseDate);
        System.out.println(parseTime);

        /**
         * LocalDateTime: classe para trabalhar com datas e horas
         */
        // now(): método estático para pegar data e hora atuais
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        // of(): método estático para obter data e hora específicos
        LocalDateTime ldt2 = LocalDateTime.of(2017, 11, 23, 22, 6, 55);
        System.out.println(ldt2);
        // atTime(): atribui um horario a determinada data
        LocalDateTime ldt3 = date.atTime(18, 36, 25);
        System.out.println(ldt3);
        // Para atribuir o horario atual
        LocalDateTime ldt4 = date.atTime(LocalTime.now());
        System.out.println(ldt4);
        // Da mesma forma, podemos atribuir datas a horarios
        LocalDateTime ldt5 = time.atDate(LocalDate.of(2012, 12, 25));
        System.out.println(ldt5);
        LocalDateTime ldt6 = time.atDate(LocalDate.now());
        System.out.println(ldt6);



    }

}
