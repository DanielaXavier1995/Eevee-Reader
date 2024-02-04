package com.generation.ReadCsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReadCsv {
	
	private RabbitTemplate rabbitTemplate;

	public ReadCsv(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void read() {

		String delimitador = ";";
		String lineData;
		File csvFile = new File("C:\\projetos-Asapcard\\ReadCsv---Eeve\\input-data.csv");

		try {

			BufferedReader read = new BufferedReader(new FileReader(csvFile));
			JSONArray arrayofJSONobjects = new JSONArray();

			while ((lineData = read.readLine()) != null) {

				String[] individualRecordFromCSV = lineData.split(delimitador);

				JSONObject jsonObj = new JSONObject();
				jsonObj.put("id", individualRecordFromCSV[0]);
				jsonObj.put("data_da_Transação", individualRecordFromCSV[1]);
				jsonObj.put("documento", individualRecordFromCSV[2]);
				jsonObj.put("nome", individualRecordFromCSV[3]);
				jsonObj.put("idade", individualRecordFromCSV[4]);
				jsonObj.put("valor", individualRecordFromCSV[5]);
				jsonObj.put("Num_de_Parcelas", individualRecordFromCSV[6]);
                 System.out.println(jsonObj);
				arrayofJSONobjects.put(jsonObj.toString());
				
				rabbitTemplate.convertAndSend("", "queue-a", jsonObj.toString());

			}
			

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
