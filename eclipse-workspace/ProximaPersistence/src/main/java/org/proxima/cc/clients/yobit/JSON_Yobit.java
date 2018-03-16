package org.proxima.cc.clients.yobit;

import java.math.BigDecimal;
import java.util.Map;

public class JSON_Yobit {
	private Map<String, BigDecimal> btc_usd;
	private Map<String, BigDecimal> ltc_usd;
	private Map<String, BigDecimal> eth_usd;
	
	public Map<String, BigDecimal> getBtc_usd() {
		return btc_usd;
	}
	public Map<String, BigDecimal> getLtc_usd() {
		return ltc_usd;
	}
	public Map<String, BigDecimal> getEth_usd() {
		return eth_usd;
	}
	public void setBtc_usd(Map<String, BigDecimal> btc_usd) {
		this.btc_usd = btc_usd;
	}
	public void setLtc_usd(Map<String, BigDecimal> ltc_usd) {
		this.ltc_usd = ltc_usd;
	}
	public void setEth_usd(Map<String, BigDecimal> eth_usd) {
		this.eth_usd = eth_usd;
	}
	}
