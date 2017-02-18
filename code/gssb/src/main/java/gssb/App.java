package gssb;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
// import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class App {

	private static final SimpleDateFormat format 
					= new SimpleDateFormat("HH:mm:ss");
	
  // 5秒ごとに実行されるメソッド。
  // @Scheduled(fixedRate = 5000)
  public void reportTime() {
    System.out.println(format.format(new Date()));
  }
	
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}