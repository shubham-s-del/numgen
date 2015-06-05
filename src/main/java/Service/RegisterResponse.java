package Service;

/**
 * Created by shubham.srivastava on 05/06/15.
 */
public class RegisterResponse {

    public String id;

    public boolean isSuccess;

    public RegisterResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisterResponse)) return false;

        RegisterResponse that = (RegisterResponse) o;

        if (isSuccess != that.isSuccess) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (isSuccess ? 1 : 0);
        return result;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
