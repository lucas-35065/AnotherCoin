package br.com.lucas.anothercoin.modelos;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Conversor {
    public String result;
    public String time_last_update_utc;
    public String base_code;
    public String target_code;
    public Double conversion_rate;
    public Double conversion_result;
    
    public String getResult() {
        return result;
    }
    public String getTime_last_update_utc() {
        
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dateTimeFormat = now.format(formatter);
        return dateTimeFormat;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public Double getConversion_rate() {
        return conversion_rate;
    }

    public Double getConversion_result() {
        return conversion_result;
    }

    @Override
    public String toString() {
        return String.format("""
            ****************************************
            Sucesso!

            Data da conversão: %s
            Converteu de: %s
            Converteu para: %s
            Taxa de conversão: %.2f
            Resultado da conversão: %.2f

            """, getTime_last_update_utc(), getBase_code(), getTarget_code(), getConversion_rate(), getConversion_result()); 
    }

}
