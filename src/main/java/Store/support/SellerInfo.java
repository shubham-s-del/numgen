
package Store.support;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Property;

import java.util.List;
import java.util.Map;

/**
 * Created by shubham.srivastava on 05/06/15.
 */
@Entity(noClassnameStored=true, value="UserInfo")
public class SellerInfo {

    @Id
    private ObjectId id;

    @Property("emailId") @Indexed(unique=true)
    private String emailId;

    @Property("sellerName")
    private String sellerName;

    @Property("latitude")
    private float lat;

    @Property("longitude")
    private float lon;

    @Property("phoneNo")
    private String phNo;

    @Property("openHours")
    private Map<EnumList.DaysOfTheWeek, List<OpenHours>> openHours;

    @Property("sellerType")
    private String sellerType;

    public Map<EnumList.DaysOfTheWeek, List<OpenHours>> getOpenHours() {
        return openHours;
    }

    public void setOpenHours(Map<EnumList.DaysOfTheWeek, List<OpenHours>> openHours) {
        this.openHours = openHours;
    }

    public String getSellerType() {
        return sellerType;
    }

    public void setSellerType(String sellerType) {
        this.sellerType = sellerType;
    }

    public SellerInfo(String sellerName, String emailId, float lat, float lon, String phNo, String sellerType, Map<EnumList.DaysOfTheWeek, List<OpenHours>> openHours) {
        this.sellerName = sellerName;
        this.emailId = emailId;
        this.lat = lat;
        this.lon = lon;
        this.phNo = phNo;
        this.sellerType = sellerType;
        this.openHours = openHours;
    }

    public SellerInfo(String sellerName, String emailId, float lat, float lon, String sellerType, Map<EnumList.DaysOfTheWeek, List<OpenHours>> openHours) {

        this.sellerName = sellerName;
        this.emailId = emailId;
        this.lat = lat;
        this.lon = lon;
        this.sellerType = sellerType;
        this.openHours = openHours;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

}
