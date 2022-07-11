package cl.mingeso.Reportes.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Transient;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Data
@Builder
public class Horarios {
    private Long id;
    private Date fecha;
    private Time hora_ingreso;
    private Time hora_salida;
    private Long id_empleado;

    @Transient
    private Time horas_trabajadas;

    public Time getHoras_trabajadas() {
        Time horas_trabajadas = new Time(0,0,0);
        if (hora_ingreso != null && hora_salida != null) {

            //Separar la hora de ingreso en hora, minutos y segundos
            String[] hora_ingreso_split = hora_ingreso.toString().split(":");
            int h_i_h = Integer.parseInt(hora_ingreso_split[0]);
            int h_i_m = Integer.parseInt(hora_ingreso_split[1]);
            int h_i_s = Integer.parseInt(hora_ingreso_split[2]);
            //Separar la hora de salida en hora, minutos y segundos
            String[] hora_salida_split = hora_salida.toString().split(":");
            int h_s_h = Integer.parseInt(hora_salida_split[0]);
            int h_s_m = Integer.parseInt(hora_salida_split[1]);
            int h_s_s = Integer.parseInt(hora_salida_split[2]);

            LocalTime time1 = LocalTime.of(h_i_h, h_i_m, h_i_s);
            LocalTime time2 = LocalTime.of(h_s_h, h_s_m, h_s_s);

            // Calcular la diferencia en horas, minutos y segundos
            //Horas
            long horas = ChronoUnit.HOURS.between(time1, time2);

            //Minutos
            long minutos
                    = ChronoUnit.MINUTES.between(time1, time2) % 60;

            //Segundos
            long segundos
                    = ChronoUnit.SECONDS.between(time1, time2) % 60;

            horas_trabajadas = new Time((int)horas, (int)minutos, (int)segundos);

        }
        return horas_trabajadas;
    }

}
