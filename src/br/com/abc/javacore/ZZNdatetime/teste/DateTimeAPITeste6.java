package br.com.abc.javacore.ZZNdatetime.teste;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.util.Map;

/**
 * ULTIMA AULA DO MARATONA JAVA
 */

public class DateTimeAPITeste6 {
    public static void main(String[] args) {
        /**
         * Trabalhando com zonas temporais
         */

        // Exibindo as zonas disponíveis no Java
        for (Map.Entry<String, String> zonas : ZoneId.SHORT_IDS.entrySet()){
            System.out.println(zonas.getKey() + " " + zonas.getValue() );
        }

        System.out.println("--------------------------");
        // Pegando a zona default do sistema
        System.out.println(ZoneId.systemDefault());

        // Pegando a zona de algum lugar especifico
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        System.out.println(tokyoZone);

        // atZone(): Associa um LocalDateTime a uma TimeZone
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        ZonedDateTime zonedDateTime = dateTime.atZone(tokyoZone);
        System.out.println(zonedDateTime);

        // Também é possível associar TimeZones a Instant, aqui é exibida a hora da TimeZone em questão
        // ao se usar o atZone()
        Instant instant = Instant.now();
        System.out.println(instant);
        ZonedDateTime zonedDateTime2 = instant.atZone(tokyoZone);
        System.out.println(zonedDateTime2);

        /**
         * ZoneOffset: trabalha com os GMTs das TimeZones
         */
        // Os valores mínimo e máximo do GMT
        System.out.println(ZoneOffset.MAX);
        System.out.println(ZoneOffset.MIN);

        // of(): puxa a time zone do GMT fornecido
        ZoneOffset manausOffset = ZoneOffset.of("-04:00");
        System.out.println(manausOffset);

        // Adicionando um GMT a um LocalDateTime de duas formas diferentes
        LocalDateTime dateTime2 = LocalDateTime.now();
        OffsetDateTime offsetDateTime = OffsetDateTime.of(dateTime2, manausOffset);
        OffsetDateTime offsetDateTime1 = dateTime2.atOffset(manausOffset);
        System.out.println(offsetDateTime);
        System.out.println(offsetDateTime1);

        // Ou para obter o horário diretamente de Manaus
        Instant instant2 = Instant.now();
        System.out.println(instant2.atOffset(manausOffset));

        // Bônus: também é possível lidar diretamente com o calendario japonês
        JapaneseDate japaneseDate = JapaneseDate.from(LocalDate.now());
        System.out.println(japaneseDate);
        LocalDate antigamente = LocalDate.of(1900, 2, 1);
        System.out.println(JapaneseDate.from(antigamente));


    }
}
