package br.com.abc.javacore.ZZNdatetime.teste;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeAPITeste5 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        // format(): formata uma data para retornar uma String

        // DateTimeFormatter.BASIC_ISO_DATE: formata uma data sem o offset (horário em relação ao
        // meridiano de Greenwich). Tem o formato 20190826
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(s1);

        // DateTimeFormatter.ISO_DATE: formata uma data com o offset, se disponível
        String s2 = date.format(DateTimeFormatter.ISO_DATE);
        System.out.println(s2);

        // DateTimeFormatter.ISO_DATE: formata uma data como ano-dia-mês
        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s3);

        // parse(): cria um objeto LocalDate baseado na data em uma string
        String s4 = "20190826";
        String s5 = "2019-08-26";

        // Caso o formato seja de um tipo diferente de ano-mes-dias, deve-se especificar no argumento
        LocalDate parse = LocalDate.parse(s4, DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate parse2 = LocalDate.parse(s5);

        System.out.println(parse);
        System.out.println(parse2);

        LocalDateTime dateTime = LocalDateTime.now();
        // DateTimeFormatter.ISO_DATE_TIME: formata data e horario como 2011-12-03T10:15:30, com ou sem offset
        String s6 = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(s6);

        LocalDateTime parse3 = LocalDateTime.parse("2019-08-26T08:42:09.271");
        System.out.println(parse3);

        // ofPattern(): estático, permite que o desenvolvedor crie seu próprio padrão de formatação
        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Daí é só usar o format() para imprimir essa data
        String formatBR = LocalDate.now().format(formatterBR);
        System.out.println(formatBR);
        // Ou o parse() para atribuir essa data a um objeto LocalDate padrão do Java
        LocalDate parse4 = LocalDate.parse("27/08/2012", formatterBR);
        System.out.println(parse4);

        // Também é possível manipular datas associando elas a locais
        DateTimeFormatter formatterFR = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.FRANCE);
        String formatFR = LocalDate.now().format(formatterFR);
        System.out.println(formatFR);

        LocalDate parse5 = LocalDate.parse("26.août.2019", formatterFR);
        System.out.println(parse5);

    }
}
