package com.generation.ReadCsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReadCsv {

	public static void main(String[] args) {

		String delimitador = ";";
		String lineData;
		File csvFile = new File("C:\\Users\\gabi_\\OneDrive\\Área de Trabalho\\Generation\\Ler arquivos\\ReadCsv\\input-data (1).csv");

		try {

			BufferedReader read = new BufferedReader(new FileReader(csvFile));
			JSONArray arrayofJSONobjects = new JSONArray();

			while ((lineData = read.readLine()) != null) {

				String[] individualRecordFromCSV = lineData.split(delimitador);

//				System.out.println("ID:" + individualRecordFromCSV[0] + " Data da Transação:"
//						+ individualRecordFromCSV[1] + "Documento:" + individualRecordFromCSV[2] + "Nome"
//						+ individualRecordFromCSV[3] + "idade" + individualRecordFromCSV[4] + "valor"
//						+ individualRecordFromCSV[5] + "Num. de Parcelas" + individualRecordFromCSV[6]);

				JSONObject jsonObj = new JSONObject();
				jsonObj.put("id", individualRecordFromCSV[0]);
				jsonObj.put("data_da_Transação", individualRecordFromCSV[1]);
				jsonObj.put("documento", individualRecordFromCSV[2]);
				jsonObj.put("nome", individualRecordFromCSV[3]);
				jsonObj.put("idade", individualRecordFromCSV[4]);
				jsonObj.put("valor", individualRecordFromCSV[5]);
				jsonObj.put("Num_de_Parcelas", individualRecordFromCSV[6]);
                 System.out.println(jsonObj);
				arrayofJSONobjects.put(jsonObj);

			}
			

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
