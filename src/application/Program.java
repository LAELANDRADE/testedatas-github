package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf4 = new SimpleDateFormat("EEE, dd MMMMM yyyy hh:mm aaa");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
		sdf4.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date x1 = new Date();
		Date x2 = new Date(System.currentTimeMillis());
		Date x3 = new Date(0L);
		Date x4 = new Date(1000L * 60L * 60L * 5L);
		Date y1 = sdf1.parse("25/06/2018");
		Date y2 = sdf2.parse("25/06/2018 15:42:07");
		Date y3 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		System.out.println("------------- Sem formato");
		System.out.println("x1: " + x1);
		System.out.println("x2: " + x2);
		System.out.println("x3: " + x3);
		System.out.println("x4: " + x4);
		System.out.println("y1: " + y1);
		System.out.println("y2: " + y2);
		System.out.println("y3: " + y3);
		System.out.println("------------- Formato 02");
		System.out.println("x1: " + sdf2.format(x1));
		System.out.println("x2: " + sdf2.format(x2));
		System.out.println("x3: " + sdf2.format(x3));
		System.out.println("x4: " + sdf2.format(x4));
		System.out.println("y1: " + sdf2.format(y1));
		System.out.println("y2: " + sdf2.format(y2));
		System.out.println("y3: " + sdf2.format(y3));
		System.out.println("------------- Formato 03 - com GMT Brasil");
		System.out.println("x1: " + sdf3.format(x1));
		System.out.println("x2: " + sdf3.format(x2));
		System.out.println("x3: " + sdf3.format(x3));
		System.out.println("x4: " + sdf3.format(x4));
		System.out.println("y1: " + sdf3.format(y1));
		System.out.println("y2: " + sdf3.format(y2));
		System.out.println("y3: " + sdf3.format(y3));
		
		// Usando o Calendar
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		System.out.println(sdf.format(d));
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.HOUR_OF_DAY, 4);
		d = cal.getTime();
		System.out.println("Horário atual com 4 horas acrescentadas; " + sdf.format(d));

		// Usando o Calendar para obter uma unidade de tempo
		
		SimpleDateFormat sdf0 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dt = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		System.out.println(sdf0.format(d));
		Calendar caly = Calendar.getInstance();
		caly.setTime(dt);
		int minutes = caly.get(Calendar.MINUTE);
		int month = 1 + caly.get(Calendar.MONTH);
		int year = caly.get(Calendar.YEAR) - 55;
		System.out.println("Minutes: " + minutes);
		System.out.println("Month: " + month);
		System.out.println("Year.: " + year);
		
		// Minha data de aniversário
		
		Date dtnasc = Date.from(Instant.parse("1964-08-27T23:00:00Z"));
		System.out.println();
		Calendar caldtnasc = Calendar.getInstance();
		caldtnasc.setTime(dtnasc);
		int dsem = caldtnasc.get(Calendar.DAY_OF_WEEK); 
		System.out.println("Dia da semana que eu nasci: " + dsem);		
		System.out.println("Data Nascimento: " + dtnasc);
		System.out.println("Data Nascimento: " + sdf2.format(dtnasc));
		System.out.println("Data Nascimento: " + sdf3.format(dtnasc));
		System.out.println("Data Nascimento: " + sdf1.format(dtnasc));
		System.out.println("Data Nascimento: " + sdf4.format(dtnasc));
	}

}
