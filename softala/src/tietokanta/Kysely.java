package tietokanta;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import tietokanta.Yhteys;

/**
 * Sis�lt�� tietokantakyselyiss� tarvittavat metodit ja tuloksen tallentamiseen
 * tarvittavat attribuutit.
 * 
 * @author Jukka Harju, Jukka Juslin
 */
public class Kysely {

	private ArrayList<HashMap> tulosjoukko;
	private Connection yhteys;

	public Kysely(Connection avattuYhteys) {
		tulosjoukko = new ArrayList<HashMap>();
		yhteys = avattuYhteys;
	}

	/**
	 * Suorittaa INSERT-, UPDATE- sek� DELETE-lauseet.
	 * 
	 * @param sqlLause
	 *            Suoritettava SQL-lause.
	 * @param parametrit
	 *            SQL-lauseen parametrit prepared statementsia varten. Voi olla
	 *            my�s monimuotoinen ArrayLista.
	 */
	public void suoritaYksittainenKyselyParametreilla(String sqlLause,
			ArrayList<Integer> parametrit) {
		//MUUTA YLEMPI INTEGER JOS JOKIN KUSEE!!!!!!!!!!!!!!!!!!!!!!!
		tulosjoukko.clear();

		ResultSet resultSet = null;

		try {
			PreparedStatement valmisteltuLause = yhteys
					.prepareStatement(sqlLause);
			for (int i = 0; i < parametrit.size(); i++) {
				valmisteltuLause.setObject(i + 1, parametrit.get(i));

			}

			System.out.println(valmisteltuLause);
			resultSet = valmisteltuLause.executeQuery();

			while (resultSet.next()) {
				HashMap tulosrivi = tallennaHashMappiin(resultSet);
				tulosjoukko.add(tulosrivi);
			}
		} catch (SQLException ex) {
			Yhteys.kasitteleVirhe("Virhe kyselyn suorittamisessa.", ex);
		} finally {
			try {
				resultSet.close();
			} catch (SQLException ex) {
				Yhteys.kasitteleVirhe("Virhe sulkemisessa.", ex);
			}
		}
	}

	public void suoritaYksittainenKysely(String sqlLause) {
		tulosjoukko.clear();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = yhteys.createStatement();
			resultSet = statement.executeQuery(sqlLause);
			while (resultSet.next()) {
				HashMap tulosrivi = tallennaHashMappiin(resultSet);
				tulosjoukko.add(tulosrivi);
			}
		} catch (SQLException ex) {
			Yhteys.kasitteleVirhe("Virhe kyselyn suorittamisessa.", ex);
		} finally {
			try {
				statement.close(); // sulkee myös ResultSetin
			} catch (SQLException ex) {
				Yhteys.kasitteleVirhe("Virhe sulkemisessa.", ex);
			}
		}
	}

	/**
	 * Tallentaa annetun ResultSetin k�sittelyn alla olevan rivin tiedot
	 * HashMappiin.
	 * 
	 * @param resultSet
	 *            Purettava ResultSet-luokan olio.
	 * @return tulosrivi ResultSetist� purettu rivi.
	 */
	public HashMap tallennaHashMappiin(ResultSet resultSet) {
		HashMap<String, String> tulosrivi = new HashMap<String, String>();

		try {
			ResultSetMetaData metaData = resultSet.getMetaData();
			int sarakkeidenLkm = metaData.getColumnCount();
			// Tallennetaan k�sittelyn alla olevan
			// rivin tiedot HashMappiin.
			for (int i = 1; i <= sarakkeidenLkm; i++) {
				tulosrivi
						.put(metaData.getColumnName(i), resultSet.getString(i));
			}
		} catch (SQLException ex) {
			Yhteys.kasitteleVirhe("Virhe kyselyn suorittamisessa.", ex);
		}
		return tulosrivi;
	}

	public String toString() {
		String tiedot = "";
		Iterator iteraattori;
		for (int i = 0; i < tulosjoukko.size(); i++) {
			HashMap tulosrivi = (HashMap) tulosjoukko.get(i);
			Set sarakkeet = tulosrivi.keySet();
			iteraattori = sarakkeet.iterator();
			while (iteraattori.hasNext()) {
				String sarake = (String) iteraattori.next();
				tiedot = tiedot + sarake + " = " + tulosrivi.get(sarake) + "\n";
			}
			tiedot = tiedot + "\n";
		}
		return tiedot;
	}

	public ArrayList getTulosjoukko() {
		return tulosjoukko;
	}

}
