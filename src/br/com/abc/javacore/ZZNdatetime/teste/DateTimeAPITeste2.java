package br.com.abc.javacore.ZZNdatetime.teste;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTimeAPITeste2 {
    public static void main(String[] args) {
        /**
         * Instant: representa um ponto no tempo em nanossegundos. É como a Date().getTime, que
         * lança um numero grande e confuso ao ser chamado, mas com maior precisão, já
         * que são nanossegundos - Além de que a Date começa em 1970.
         * Serve para facilitar a comunicação sobre datas com o computador
         */

        System.out.println("---------------------------- INSTANT ----------------------------");

        Instant instant = Instant.now();
        // O resultado exibido aqui é no horário zulu (ou UTC), um
        // fuso horário de referência a partir do qual se calculam todas as
        // outras zonas horárias do mundo. (Daí que vem o Z do fim)
        System.out.println(instant);
        System.out.println(LocalDateTime.now());

        // Para pegar o momento atual em nano, primeiro você deve pegá-lo em segundos:
        // getEpochSecond(): mostra a contagem atual de segundos,
        // sendo meia noite de 1-1-1970 o marco 0 para a contagem
        System.out.println(instant.getEpochSecond());
        // getNano(): Pega os segundos trazidos anteriormente e os transformam num valor nano
        // (Sempre serão exibidos valores menores que 999.999.999)
        System.out.println(instant.getNano());

        // ofEpochSecond(): método estático que retorna 1-1-1970, podendo
        // ser acrescidos segundos e se fazer ajustes em nanossegundos
        // (Inútil, mas ta ai)
        System.out.println(Instant.ofEpochSecond(25));

        System.out.println("---------------------------- DURATION ----------------------------");

        /**
         * Duration: faz operações com as durações entre um momento e outro
         */

        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = LocalDateTime.of(2018, 12, 6, 23, 5);

        LocalTime timeNow = LocalTime.now();
        LocalTime time2 = LocalTime.of(5, 0, 0);

        // between(): método estático, pede duas datas e mostra a duração entre elas em hora, minuto e segundo.
        // Não permite o uso do LocalDate, já que pede até os segundos e nanossegundos.
        // Também não pode misturar LocalDateTime com LocalTime, já que na segunda se usa apenas a hora.
        Duration d1 = Duration.between(dt1, dt2);
        Duration d2 = Duration.between(timeNow, time2);
        // plusSeconds(): Adiciona segundos ao momento referido
        Duration d3 = Duration.between(Instant.now(), Instant.now().plusSeconds(200));

        // atDate(): Atribui uma data a um valor em horas
        // toLocalDate(): pega apenas a data de um LocalDateTime
        Duration d4 = Duration.between(dt2, time2.atDate(dt2.toLocalDate()));

        // ofMinutes(): converte uma duração em minutos para horas e minutos
        Duration d5 = Duration.ofMinutes(250);

        // ofDays(): converte uma duração em dias para horas
        Duration d6 = Duration.ofDays(9);

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);
        System.out.println(d5);
        System.out.println(d6);

        /**
         * Period: mesma coisa que a Duration, mas lidando com dias meses e anos
         */

        System.out.println("---------------------------- PERIOD ----------------------------");

        Period p1 = Period.between(dt1.toLocalDate(), dt2.toLocalDate());
        // ofDays(): Exibe a quantidade de dias passados no argumento
        Period p2 = Period.ofDays(368);
        // ofWeeks(): Exibe as semanas passadas como argumentos na forma de dias
        Period p3 = Period.ofWeeks(58);

        // A conversão de unidades na classe Period é manual:
        // Primeiro você precisa pegar o tamanho do intervalo "PeriodoDesejado - Agora" com um between()
        // para, aí sim, pegar os meses, semanas ou anos daquilo.

//        int period = Period.between(LocalDate.now(), LocalDate.now().plusDays(p3.getDays())).getMonths();

        // Contudo, a classe Period não é exatamente propria para isso, o que torna melhor usar um
        // LocalDateTime.
        LocalDateTime now = LocalDateTime.now();
        // until(): método que conta a duração do seu objeto de referencia a uma data passada como argumento
        long period = now.until(now.plusDays(p3.getDays()), ChronoUnit.MONTHS);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(period);

        /**
         * ChronoUnit: um enum facilitador de conversões
         */

        System.out.println("---------------------------- CHRONOUNIT ----------------------------");

        LocalDateTime aniversario = LocalDateTime.of(1999, 12, 30, 18, 15);
        long b1 = ChronoUnit.DAYS.between(aniversario, now);
        long b2 = ChronoUnit.WEEKS.between(aniversario, now);
        long b3 = ChronoUnit.MONTHS.between(aniversario, now);
        long b4 = ChronoUnit.YEARS.between(aniversario, now);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);

    }
}
