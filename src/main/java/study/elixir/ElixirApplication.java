package study.elixir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import study.elixir.module.BaseElixir;

@SpringBootApplication
public class ElixirApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElixirApplication.class, args);


		BaseElixir es =  new BaseElixir(14);

		es.select("rebedo");
		es.selectSimulation();
		es.print();
		es.resetSelectSimulation();
		es.select("viriditas");
		es.selectSimulation();
		es.print();
		es.resetSelectSimulation();
		es.select("viriditas");
		es.selectSimulation();
		es.print();
		es.resetSelectSimulation();


	}

}
