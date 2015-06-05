package Store.support;

/**
 * Created by shubham.srivastava on 06/06/15.
 */
public class UserInfo {

    private String emailId;
    private double lat;
    private double lon;
    private String phNo;
    private String gcmId;

    public UserInfo(String emailId, double lat, double lon, String phNo, String gcmId) {
        this.emailId = emailId;
        this.lat = lat;
        this.lon = lon;
        this.phNo = phNo;
        this.gcmId = gcmId;
    }

    public UserInfo(String emailId, double lat, double lon, String gcmId) {

        this.emailId = emailId;
        this.lat = lat;
        this.lon = lon;
        this.gcmId = gcmId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getGcmId() {
        return gcmId;
    }

    public void setGcmId(String gcmId) {
        this.gcmId = gcmId;
    }
}
