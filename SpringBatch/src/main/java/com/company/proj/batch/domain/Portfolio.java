/**
 * 
 */
package com.company.proj.batch.domain;

/**
 * @author Yaswanth
 *
 */
public class Portfolio {
	private String fiscal_year, accouting_period, data_soruce;

	public Portfolio(String fiscal_year, String accouting_period, String data_soruce) {
		super();
		this.fiscal_year = fiscal_year;
		this.accouting_period = accouting_period;
		this.data_soruce = data_soruce;
	}

	/**
	 * @return the fiscal_year
	 */
	public String getFiscal_year() {
		return fiscal_year;
	}

	/**
	 * @param fiscal_year the fiscal_year to set
	 */
	public void setFiscal_year(String fiscal_year) {
		this.fiscal_year = fiscal_year;
	}

	/**
	 * @return the accouting_period
	 */
	public String getAccouting_period() {
		return accouting_period;
	}

	/**
	 * @param accouting_period the accouting_period to set
	 */
	public void setAccouting_period(String accouting_period) {
		this.accouting_period = accouting_period;
	}

	/**
	 * @return the data_soruce
	 */
	public String getData_soruce() {
		return data_soruce;
	}

	/**
	 * @param data_soruce the data_soruce to set
	 */
	public void setData_soruce(String data_soruce) {
		this.data_soruce = data_soruce;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Portfolio [fiscal_year=" + fiscal_year + ", accouting_period=" + accouting_period + ", data_soruce="
				+ data_soruce + "]";
	}
	
}
