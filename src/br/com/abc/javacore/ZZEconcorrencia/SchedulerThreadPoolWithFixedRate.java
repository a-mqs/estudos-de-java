package br.com.abc.javacore.ZZEconcorrencia;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class SchedulerThreadPoolWithFixedRate {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void beep(){
        final Runnable horario = new Runnable() {
            @Override
            public void run() {
                System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date()) + " beep");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2 segundos processamento");
            }
        };

        final ScheduledFuture<?> beep = scheduler.scheduleWithFixedDelay(horario, 0,5, TimeUnit.SECONDS);

        final Runnable cancelar = new Runnable() {
            @Override
            public void run() {
                System.out.println("Cancelando");
                beep.cancel(true);
                scheduler.shutdown();
            }
        };

        scheduler.schedule(cancelar, 40, TimeUnit.SECONDS);


    }

    public static void main(String[] args) {
        beep();
    }



}
