package Store.support;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Property;

/**
 * Created by shubham.srivastava on 06/06/15.
 */
@Entity(noClassnameStored=true, value="UserInfo")
public class UserInfo {

    @Id
    private ObjectId id;

    @Property("emailId") @Indexed(unique=true)
    private String emailId;

    @Property("latitude")
    private double lat;

    @Property("longitude")
    private double lon;

    public UserInfo(String emailId, String gcmId) {
        this.emailId = emailId;
        this.gcmId = gcmId;
    }

    @Property("phoneNo")

    private String phNo;

    public UserInfo(ObjectId id, String emailId, String phNo, String gcmId) {
        this.id = id;
        this.emailId = emailId;
        this.phNo = phNo;
        this.gcmId = gcmId;
    }

    @Property("gcmId")
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
