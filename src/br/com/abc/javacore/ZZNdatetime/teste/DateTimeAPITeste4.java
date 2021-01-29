package br.com.abc.javacore.ZZNdatetime.teste;

import br.com.abc.javacore.ZZNdatetime.util.ObterProximoDiaUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateTimeAPITeste4 {
    public static void main(String[] args) {
        /**
         * TemporalAdjusters: serve para fazer ajustes em datas,
         * coisas como "pegar o próximo domingo em relação ao fornecido".
         * Tem a sua versão em interface, que é a TemporalAdjuster.
         */
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        // nextOrSame(): retorna a próxima ocorrencia da unidade que você colocar.
        // Retornará o dia de hoje se essa tal ocorrencia for hoje.
        date = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        // next(): mesma coisa, mas retorna apenas a próxima ocorrência.
        date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        // previous() e previousOrSame(): mesma coisa, mas retorna a ocorrência aneterior.
        date = date.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        // firstDayOfMonth() e lastDayOfMonth(): retorna o primeiro e ultimo dias do mês, para se obter o dia da semana.
        date = date.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        // firstDayOfNextYear(): retorna o primeiro dia do ano, para se obter o dia da semana.
        date = date.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        // Método para contar o proximo dia util, feito com a interface TemporalAdjuster
        date = date.with(new ObterProximoDiaUtil());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());
















    }

}
