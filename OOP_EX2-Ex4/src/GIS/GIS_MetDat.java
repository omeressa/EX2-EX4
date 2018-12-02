package GIS;

import Geom.Point3D;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *all the details of one gps point in file
 */
public class GIS_MetDat implements Meta_data {
	/**
	 * gps point information
	 */
	private String Mac;
	private String SSID;
	private String Auth_mode;
	private String FS;
	private String Channel;
	private String RSSI;
	private String Accuracy;
	private String Type;
	private long data;
	Point3D Orientation;//not needed here for now!

	public GIS_MetDat(String mac, String ssid, String Auth_mode, String FS, String channel, String RSSI,
			String Accurcy, String Type) {
		this.Mac = mac;
		this.SSID = ssid;
		this.Auth_mode = Auth_mode;
		this.FS = FS;
		this.Channel = channel;
		this.RSSI = RSSI;
		this.Accuracy = Accurcy;
		this.Type = Type;
	}




	public GIS_MetDat(long utc) {
		this.data=utc;
		// TODO Auto-generated constructor stub
	}
	/**
	 * Use the FS as the date of creation for viewing on the gps point
	 *
	 * @return FS time in mili seconds.
	 */
	@Override
	public long getUTC() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long milliseconds = 0;
		try {
			Date d = date.parse(this.FS);
			milliseconds = d.getTime();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return Math.abs(milliseconds);
	}

	/**
	 * null as requested in Ex2
	 */
	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * getters and setters
	 * @return
	 */
	public String getMac() {
		return Mac;
	}

	public void setMac(String mac) {
		Mac = mac;
	}

	public String getSSID() {
		return SSID;
	}

	public void setSSID(String sSID) {
		SSID = sSID;
	}

	public String getAuth_mode() {
		return Auth_mode;
	}

	public void setAuth_mode(String auth_mode) {
		this.Auth_mode = auth_mode;
	}

	public String getFirst_seen() {
		return FS;
	}

	public void setFirst_seen(String first_seen) {
		this.FS = first_seen;
	}

	public String getChannel() {
		return Channel;
	}

	public void setChannel(String channel) {
		Channel = channel;
	}

	public String getRssi() {
		return RSSI;
	}

	public void setRssi(String rssi) {
		this.RSSI = rssi;
	}

	public String getAccuracy() {
		return Accuracy;
	}

	public void setAccuracy(String accuracy) {
		Accuracy = accuracy;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	/**
	 * toString function
	 */
	@Override
	public String toString() {
		return "GIS_MetDat [Mac=" + Mac + ", SSID=" + SSID + ", Auth_mode=" + Auth_mode + ", FS=" + FS + ", Channel="
				+ Channel + ", RSSI=" + RSSI + ", Accuracy=" + Accuracy + ", Type=" + Type + ", data=" + data
				+ ", Orientation=" + Orientation + "]";
	}


}